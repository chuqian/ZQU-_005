package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dto.Commodity;
import com.entity.AllCommodity;
import com.entity.Collect;
import com.entity.Seller;
import com.entity.Type;
import com.service.AllCommodityService;
import com.service.CollectService;
import com.service.CustomerService;
import com.service.SellerAndMallService;
import com.service.TypeService;
import com.util.ConditionBeanUnit;
import com.util.DateChange;

/**
 * @author liangjiahong
 * @date 2018年9月26日 下午4:10:11
 * @describe 
 */
@Controller
@RequestMapping("/customer_1")
public class CustomerController_1 {
	
	@Autowired
	private TypeService typeService;
	@Autowired
	private AllCommodityService allCommodityService;
	@Autowired
	private SellerAndMallService sellerAndMallService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CollectService collectService;

	//加载首页分类
	@RequestMapping(value = "/typeURL", method = RequestMethod.POST)
	public void initType(HttpServletRequest request,HttpServletResponse response){
		List<Type> lists = new ArrayList<>();
		lists = typeService.getAllType();
		try {
			JSONObject o = new JSONObject();
			Object json = JSONArray.toJSON(lists);
			o.put("dataType", json);
			response.getWriter().write(o.toString());
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//加载首页商品列表
	@RequestMapping(value = "/allCommodityURL", method = RequestMethod.POST)
	public void initAllCommodity(HttpServletRequest request,HttpServletResponse response){
		List<AllCommodity> lists = new ArrayList<>();
		lists = allCommodityService.getAllCommodityByPage(0, 10);
		try {
			JSONObject o = new JSONObject();
			Object json = JSONArray.toJSON(lists);
			o.put("dataAllCommodity", json);
			response.getWriter().write(o.toString());
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//搜索功能
	@RequestMapping(value = "/searchURL", method = RequestMethod.POST)
	public void initSearch(HttpServletRequest request,HttpServletResponse response){
		String searchContent = request.getParameter("searchContent");
		String skip = request.getParameter("skip");
		String limit = request.getParameter("limit");
		if(skip==null || limit==null)
		{
			skip = "0";
			limit = "12";
		}
		List<AllCommodity> lists = new ArrayList<>();
//		System.out.println(searchContent.matches("^\\s*$"));
		try {
			if(searchContent.matches("^\\s*$")) {
				lists = allCommodityService.getAllCommodityByPage(Integer.parseInt(skip), Integer.parseInt(limit));
			}
			else {
				List<ConditionBeanUnit> conditionBeanUnits = new ArrayList<>();
				ConditionBeanUnit co1 = new ConditionBeanUnit();
				ConditionBeanUnit co2 = new ConditionBeanUnit();
				ConditionBeanUnit co3 = new ConditionBeanUnit();
				co1.setKey("id");
				co1.setValue(searchContent);
				conditionBeanUnits.add(co1);
				co2.setKey("commodityName");
				co2.setValue(searchContent);
				conditionBeanUnits.add(co2);
				co3.setKey("commodityType");
				co3.setValue(searchContent);
				conditionBeanUnits.add(co3);
				lists = allCommodityService.getSearchCommodityByPage(conditionBeanUnits, Integer.parseInt(skip), Integer.parseInt(limit));
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		}
		System.out.println(lists.size());
		try {
			request.setAttribute("dataSearch", lists);
			request.setAttribute("searchContent", searchContent);
//			request.setAttribute("searchContent", searchContent);
			request.getRequestDispatcher("/unitShop/search.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	//商品详情页
	@SuppressWarnings("unused")
	@RequestMapping(value = "/introductionURL", method = RequestMethod.POST)
	public void IntroductionPage(HttpServletRequest request,HttpServletResponse response){
		String PageURL = request.getParameter("PageURL");
		String customerId = request.getParameter("customerId");
		customerId = "12345678";
		String commodityId = request.getParameter("commodityId");
		String searchContent = request.getParameter("searchContent");
		Seller seller = sellerAndMallService.findByCommodityId(commodityId);
		try {
			if (seller!=null) {
				Commodity commodity = new Commodity();
				List<Commodity> lists = seller.getCommoditys();
				for (Commodity commodity2 : lists) {
					if(commodity2.getId().equals(commodityId)) {
						commodity = commodity2;
						System.out.println(commodity.toString());
						break;
					}
				}
				if(customerId!=null) {
					Collect collect = collectService.findByCusIdAndCommodity(customerId, commodityId);
					int isCollent;
					if(collect!=null)
						isCollent = 1;
					else
						isCollent = -1;
					System.out.println("isCollent:" + isCollent);
					request.setAttribute("isCollent", isCollent);
				}
				if (commodity!=null) {
					int commentNum = 0;
					if(commodity.getComments()!=null)
						commentNum = commodity.getComments().size();
					System.out.println(commentNum);
					request.setAttribute("commodity", commodity);
					request.setAttribute("name", seller.getName());
					request.setAttribute("sellerId", seller.getId());
					request.setAttribute("commentNum", commentNum);
					request.getRequestDispatcher("/unitShop/introduction.jsp").forward(request, response);
				}
				else {
					JOptionPane.showMessageDialog(null, "该商品不存在", "提示", JOptionPane.INFORMATION_MESSAGE);
					if (PageURL.equals("home")) {
						response.sendRedirect("/shopping/unitShop/home.jsp");
					}
					else {
						request.setAttribute("searchContent", searchContent);
						initSearch(request,response);
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "该店铺不存在", "提示", JOptionPane.INFORMATION_MESSAGE);
				if (PageURL.equals("home")) {
					response.sendRedirect("/shopping/unitShop/home.jsp");
				}
				else {
					request.setAttribute("searchContent", searchContent);
					initSearch(request,response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/addCollent" , method = RequestMethod.POST)
	public void addCollection(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("intoaddCollection");
		String customerId = request.getParameter("customerId");
		String commodityId = request.getParameter("commodityId");
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		String imgScr = request.getParameter("imgScr");
//		System.out.println(request.getParameter("datetime"));
		Date datetime = new DateChange().StringToDate(request.getParameter("datetime"));
		Collect collect = new Collect();
		collect.setCommodityId(commodityId);
		collect.setCustomerId(customerId);
		collect.setName(name);
		collect.setPrice(price);
		collect.setImgScr(imgScr);
		collect.setDatetime(datetime);
//		System.out.println(collect.toString());
//		customerService.insertCollection(collect, customerId, commodityId);
		
		String flag = "isAdd";
		try {
			response.getWriter().write(flag);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/deleteCollent" , method = RequestMethod.POST)
	public void deleteCollent(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("intodeleteCollent");
		String customerId = request.getParameter("customerId");
		String commodityId = request.getParameter("commodityId");
//		customerService.deleteCollection(customerId, commodityId);
		
		String flag = "isNull";
		try {
			response.getWriter().write(flag);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}

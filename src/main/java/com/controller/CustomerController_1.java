package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.AllCommodity;
import com.entity.Type;
import com.service.AllCommodityService;
import com.service.TypeService;
import com.util.ConditionBeanUnit;

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

	@RequestMapping(value = "/searchURL", method = RequestMethod.POST)
	public void initSearch(HttpServletRequest request,HttpServletResponse response){
		String con = request.getParameter("searchContent");
		String skip = request.getParameter("skip");
		String limit = request.getParameter("limit");
		if(skip==null && limit==null)
		{
			skip = "0";
			limit = "10";
		}
		List<AllCommodity> lists = new ArrayList<>();
		if(con.equals("")) {
			lists = allCommodityService.getAllCommodityByPage(Integer.parseInt(skip), Integer.parseInt(limit));
		}
		else {
			List<ConditionBeanUnit> conditionBeanUnits = new ArrayList<>();
			ConditionBeanUnit co1 = new ConditionBeanUnit();
			ConditionBeanUnit co2 = new ConditionBeanUnit();
			ConditionBeanUnit co3 = new ConditionBeanUnit();
			co1.setKey("id");
			co1.setValue(con);
			conditionBeanUnits.add(co1);
			co2.setKey("commodityName");
			co2.setValue(con);
			conditionBeanUnits.add(co2);
			co3.setKey("commodityType");
			co3.setValue(con);
			conditionBeanUnits.add(co3);
			lists = allCommodityService.getSearchCommodityByPage(conditionBeanUnits, Integer.parseInt(skip), Integer.parseInt(limit));
		}
		System.out.println(lists.size());
		try {
			request.setAttribute("dataSearch", lists);
			request.getRequestDispatcher("/unitShop/search.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	

}

package com.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.PageQueryVo;
import com.common.Pager;
import com.dto.Commodity;
import com.enumm.StoreType;
import com.service.SellerService;

/**
 * @author chenchuqian
 * @date 2018年9月7日 下午4:06:15
 * @describe
 */
@Controller
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	/**
	 * 首页
	 * @return
	 */
	/*@RequestMapping("/index")
	public String goodsPullOn(){
		return "/front/seller/goodsPullOn";
	}*/
	
	/**
	 * 店铺/卖家信息
	 * @param sellerId
	 * @return	
	 */
	@RequestMapping("/storeInfo")
	public ModelAndView storeInfo(String sellerId){
		//ModelAndView mv = new ModelAndView("/front/seller/storeInfo");
		sellerId = "5b9625662fcc73437f2a47ce";
		ModelAndView mv = new ModelAndView("/front/seller/editShopInfo");
		mv.addObject("seller", sellerService.info(sellerId));
		mv.addObject("storeTypes", StoreType.values());
		return mv;
	}
	
	/**
	 * 店铺/卖家信息保存
	 * @param seller
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/storeSave")
	public void storeSave(Map<String, String> editInfo, HttpServletResponse response) throws IOException{
		sellerService.infoSave(editInfo);
	
		response.getWriter().write("保存成功");
	}
	
	/**
	 * 店铺注销
	 * @param sellerId
	 */
	@RequestMapping("/storeCancel")
	public void storeCancel(String sellerId){
		sellerService.storeCancel(sellerId);
	}
	
	/**
	 * 获取在卖商品
	 * @param sellerId
	 * @param page
	 * @return
	 */
	@RequestMapping("/commodityList")
	public ModelAndView commodityList(String sellerId, Commodity commodity, PageQueryVo page){
		ModelAndView mv = new ModelAndView("/front/seller/....");
		Pager<Commodity> pager = sellerService.getCommodiyBySeller(sellerId, commodity, page);
		mv.addObject("pager", pager);
		return mv;
	}
	
	/**
	 * 添加在卖商品
	 * @param sellerId
	 * @param commodity
	 */
	@RequestMapping("/commodityAdd")
	public void commodityAdd(String sellerId, Commodity commodity){
		sellerService.commodityToSeller(sellerId, commodity);
	}
	
	/**
	 * 商家有关订单
	 * @param sellerId
	 * @param orderState
	 * @param page
	 * @return
	 */
	@RequestMapping("/orders")
	public ModelAndView orders(String sellerId, int orderState, PageQueryVo page){
		ModelAndView mv = new ModelAndView("/front/seller/orders");
		mv.addObject("pager", sellerService.getOrders(sellerId, orderState, page));
		return mv;
	}
	
}

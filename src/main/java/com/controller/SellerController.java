package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.common.PageQueryVo;
import com.common.Pager;
import com.common.SystemConst;
import com.dto.Commodity;
import com.entity.Seller;
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
	
	@RequestMapping("/index")
	public String goodsPullOn(){
		return "/front/seller/goodsPullOn";
	}
	
	@RequestMapping("/info")
	public ModelAndView storeInfo(String sellerId){
		sellerId = "shangjia0Mon Sep 10 16:03:50 CST 2018";
		ModelAndView mv = new ModelAndView("/front/seller/editShopInfo");
		mv.addObject("storeTypes", SystemConst.StoreType.values());
		mv.addObject("seller", sellerService.info(sellerId));
		return mv;
	}
	
	@RequestMapping("/infoSave")
	public void storeSave(Seller seller, CommonsMultipartFile file,	HttpServletResponse response) throws IOException{
		
		//sellerService.save(seller);
		System.out.println(seller.getContactAddress());
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
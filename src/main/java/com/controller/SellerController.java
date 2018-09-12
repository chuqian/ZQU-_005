package com.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Seller;
import com.service.SellerService;

/**
 * @author chenchuqian
 * @date 2018年9月7日 下午4:06:15
 * @describe
 */
@Controller
@RequestMapping(value="/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@RequestMapping("/index")
	public String goodsPullOn(){
		return "/front/seller/goodsPullOn";
	}
	
	/*@RequestMapping("/storeSave")
	public void storeSave(Seller seller, HttpServletResponse ){
		sellerService.save(seller);
		return null;
	}*/
	
	
	
	
}

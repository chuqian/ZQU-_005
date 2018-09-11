package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenchuqian
 * @date 2018年9月7日 下午4:06:15
 * @describe
 */
@Controller
@RequestMapping(value="/seller")
public class SellerController {

	@RequestMapping("/index")
	public String goodsPullOn(){
		return "/front/seller/goodsPullOn";
	}
}

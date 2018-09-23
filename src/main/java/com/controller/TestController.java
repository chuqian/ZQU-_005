package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class TestController {
	
	{
		System.out.println("ini....");
	}
	
	@RequestMapping("/goodsPullOn")
	public String goodsPullOn(){
		return "/front/seller/goodsPullOn";
	}
	
	
}

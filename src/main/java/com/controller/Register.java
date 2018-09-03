/**
 *@author : lgpeng
 *@datetime : Sep 3, 2018 4:50:11 PM
 *@descriptioin :  
 */
package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Seller;

@Controller
public class Register {
	
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerSaller(Seller seller) {
		
		
		return "";
	}
}

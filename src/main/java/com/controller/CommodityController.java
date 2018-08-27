package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.Pager;
import com.entity.Commodity;
import com.service.CommodityService;

/**
 * @author chenchuqian
 * @date 2018年8月25日 上午10:42:19
 * @describe 商品管理
 */
@Controller
@RequestMapping("/commodiy")
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	
	/**
	 * 商品展示
	 * @param map
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(Map<String, String> map){
		ModelAndView mv = new ModelAndView("/front/list");
		Pager<Commodity> pager = commodityService.list();
		mv.addObject("pager", pager);
		return mv;
	}
	
	@RequestMapping("/addOrupdate")
	public String up(Commodity commodity){
		int state = commodityService.addOrUpdate(commodity);
		return "/front/list";
	}
	
	/**
	 * 商品上/下架
	 * @param shelf
	 * @return
	 */
	@RequestMapping("/onOrDown")
	@ResponseBody
	public String onOrDown(@RequestParam(required=true)String id,
			@RequestParam(required=true) int shelf){
		
		return "成功";
	}
}

package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.PageQueryVo;
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
	 * @param 
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(Commodity commodity, PageQueryVo page) {
		ModelAndView mv = new ModelAndView("/front/commodity/list");
		Pager<Commodity> pager = commodityService.list(commodity, page);
		
		mv.addObject("pager", pager);
		return mv;
	}
	
	@RequestMapping("/save")
	public String save(Commodity commodity){
		commodityService.save(commodity);
		return "/front/list";
	}
	
	/**
	 * 商品删除
	 * @param id
	 * @return 
	 */
	@RequestMapping("/del")
	@ResponseBody
	public String del(@RequestParam(required=true)String id) {
		 String state = commodityService.delete(id);
		 return state;
	}
	
	/**
	 * 商品上/下架(考虑一下是否有必要加这个方法)
	 * @param id
	 * @param shelf
	 * @return
	 */
	@RequestMapping("/onOrDown")
	@ResponseBody
	public String onOrDown(@RequestParam(required=true)String id,
			@RequestParam(required=true) int shelf) {
		
		return "succe";
	}
}

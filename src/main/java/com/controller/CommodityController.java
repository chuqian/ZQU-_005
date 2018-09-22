package com.controller;

import static org.junit.Assert.fail;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.common.PageQueryVo;
import com.common.Pager;
import com.dto.Commodity;
import com.entity.AllCommodity;
import com.service.CommodityService;
import com.service.FileService;

/**
 * @author chenchuqian
 * @date 2018年8月25日 上午10:42:19
 * @describe 商品管理
 */
@Controller
@RequestMapping("/commodiy")
public class CommodityController {
	
	{
		System.out.println("init++++ ");
	}

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private FileService fileService;
	
	/**
	 * 商品展示
	 * @param 
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(AllCommodity commodity, PageQueryVo page) {
		ModelAndView mv = new ModelAndView("/front/commodity/list");
		Pager<AllCommodity> pager = commodityService.list(commodity, page);
		
		mv.addObject("pager", pager);
		return mv;
	}
	
	@RequestMapping("/save")
	public String save(AllCommodity commodity){
		commodityService.save(commodity);
		return "/front/list";
	}
	
	/**
	 * 商品删除
	 * @param sellerId
	 * @param commodityId
	 * @return
	 */
	@RequestMapping("/commodityDel")
	@ResponseBody
	public String del(String sellerId, String commodityId) {
		 if(commodityService.delete(sellerId, commodityId))
			 return "success";
		 else
			 return "fail";
	}
	
	/**
	 * 跳转到商品上架页面
	 * @return
	 */
	@RequestMapping("/goodsPullOn")
	public String toGoodsPullOn(){
		return "/front/seller/goodsPullOn";
	}
	
	/**
	 * 商品上架
	 * @param commodity 商品信息
	 * @param files 商品图片
	 * @param sellerId 卖家id
	 * @param request 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/commodityShelf")
	public String onOrDown(Commodity commodity, 
			@RequestParam("file") CommonsMultipartFile[] files,
			String sellerId, HttpServletRequest request) {
		//图片保存在webapp目录下的img目录中
		String savePath = request.getSession().getServletContext().getRealPath("img");
		//保存上传的图片，返回图片名
		String[] imSrc = fileService.saveFiles(files, savePath);
		//商品图片路径
		commodity.setImgSrc(imSrc);
		System.out.println(files.length);
		commodityService.commodityUpload(sellerId, commodity);
		return "succe";
	}
	
	/**
	 * 跳转到商品信息页面
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="/toGoodInfo")
	public ModelAndView toGoodInfo(@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage){
		int pageSize = 10;
		String sellerId = "5b9625662fcc73437f2a47ce";
		List<Commodity> commoditys = commodityService.findSellerCommodity(sellerId, (currentPage-1)*pageSize, pageSize);
		System.out.println(commoditys.size());
		ModelAndView mv = new ModelAndView();
		mv.addObject("commoditys", commoditys);
		mv.setViewName("/front/seller/goodsInfo");
		return mv;
	}
}

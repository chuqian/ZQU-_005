package com.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.common.PageQueryVo;
import com.common.Pager;
import com.dao.CommodityDao;
import com.dao.impl.CommodityDaoImpl;
import com.dao.impl.SellerDaoImpl;
import com.dto.Commodity;
import com.entity.AllCommodity;
import com.entity.Seller;
import com.service.CommodityService;

/**
 * 
 * @author chenchuqian
 * @date 2018年8月26日 下午8:54:38
 * @describe
 */
@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDaoImpl;
	
	@Override
	public Pager<AllCommodity> list(AllCommodity commodity, PageQueryVo page) {
		int skip = (page.getPage()-1) * page.getSize();
		long total = commodityDaoImpl.rowsCount(commodity);
		long pageCount = total%page.getSize()==0 ? total/page.getSize() : total/page.getSize()+1;
		List<AllCommodity> rows = commodityDaoImpl.findByCondition(commodity, skip, page.getSize());
		
		Pager<AllCommodity> pager = new Pager<>();
		pager.setTotal(total);        //文档总条数
		pager.setCurrentPage(page.getPage());   //当前页
		pager.setPageCount(pageCount);        //总页数
		pager.setRows(rows);         //文档内容
		return pager;
	}
	
	@Override
	public String save(AllCommodity commodity) {
		commodityDaoImpl.save(commodity);
		return "succe";
	}
	
	@Override
	public boolean delete(String sellerId, String commodityId) {
		boolean commodityFlag = this.commodityDaoImpl.commodityDelete(sellerId, commodityId);
//		boolean allCommodityFlag = this.commodityDaoImpl.allCommodityDelete(commodityId);
		return commodityFlag; //&& allCommodityFlag;
	}
	
	@Override
	public boolean commodityUpload(String sellerId, Commodity commodity) {
		//完善店铺商品信息
		String commdityId = UUID.randomUUID().toString().replace("-", "");
		commodity.setId(commdityId);
		commodity.setSaledNum(0);
		commodity.setShelfTime(new Date());
		commodity.setScore(0);
		//完善平台上平
		AllCommodity allCommodity = new AllCommodity();
		allCommodity.setSellerId(sellerId);
		allCommodity.setId(commdityId);
		allCommodity.setCommodityName(commodity.getName());
		allCommodity.setPrice(commodity.getPrice());
		allCommodity.setSaledNum(commodity.getSaledNum());
		allCommodity.setImgSrc(commodity.getImgSrc()[0]);
		allCommodity.setCommodityType(commodity.getCommodityType());
		commodityDaoImpl.commodityUpload(commodity, allCommodity);
		return false;
	}

	
}

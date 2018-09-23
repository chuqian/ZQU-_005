package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.PageQueryVo;
import com.common.Pager;
import com.dao.SellerDao;
import com.dto.Commodity;
import com.dto.SellerOrder;
import com.entity.Seller;
import com.service.SellerService;

/**
 * @author chenchuqian
 * @date 2018年9月11日 上午11:21:57
 * @describe 卖家service实现
 */
@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerDao sellerDao;

	@Override
	public Seller info(String sellerId) {
		return sellerDao.getInfoById(sellerId);
	}
	
	@Override
	public void infoSave(Map<String, String> editInfo) {
		sellerDao.InfoSave(editInfo);
	}
 	@Override
	public void storeCancel(String sellerId) {
		sellerDao.storeCancel(sellerId);
	}
	
	
	@Override
	public Pager<Commodity> getCommodiyBySeller(String sellerId, Commodity commodity, PageQueryVo page) {
		long limit = page.getSize();
		long skip = (page.getPage()-1) * limit;
		List<Commodity> commoditys = sellerDao.getCommodiyBySeller(sellerId, skip, limit);
		
		Pager<Commodity> pager = new Pager<>();
		pager.setCurrentPage(page.getPage());
		pager.setSize(page.getSize());
		//pager.setPageCount(pageCount);  
		//pager.setTotal(total);
		pager.setRows(commoditys);
		return pager;
	}
 	@Override
	public void commodityToSeller(String sellerId, Commodity commodity) {
		sellerDao.commodityToSeller(sellerId, commodity);
	}
 	@Override
	public Pager<SellerOrder> getOrders(String sellerId, int orderState, PageQueryVo page) {
		long limit = page.getSize();
		long skip = (page.getPage()-1) * limit;
		List<SellerOrder> orders = sellerDao.getOrdersBySeller(sellerId, orderState, skip, limit);
		
		Pager<SellerOrder> pager = new Pager<>();
		pager.setCurrentPage(page.getPage());
		pager.setSize(page.getSize());
		//pager.setPageCount(pageCount);  
		//pager.setTotal(total);
		pager.setRows(orders);
		return pager;
	}

	
	
}

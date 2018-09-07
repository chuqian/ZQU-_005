package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.PageQueryVo;
import com.common.Pager;
import com.dao.impl.CommodityDaoImpl;
import com.dto.Commodity;
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
	private CommodityDaoImpl commodityDaoImpl;
	
	@Override
	public Pager<Commodity> list(Commodity commodity, PageQueryVo page) {
		int skip = (page.getPage()-1) * page.getSize();
		long total = commodityDaoImpl.rowsCount(commodity);
		long pageCount = total%page.getSize()==0 ? total/page.getSize() : total/page.getSize()+1;
		List<Commodity> rows = commodityDaoImpl.findByCondition(commodity, skip, page.getSize());
		
		Pager<Commodity> pager = new Pager<>();
		pager.setTotal(total);        //文档总条数
		pager.setCurrentPage(page.getPage());   //当前页
		pager.setPageCount(pageCount);        //总页数
		pager.setRows(rows);         //文档内容
		return pager;
	}
	
	@Override
	public String save(Commodity commodity) {
		commodityDaoImpl.save(commodity);
		return "succe";
	}
	
	@Override
	public String delete(String id) {
		if(commodityDaoImpl.deleteById(id) > 0)
			return "succe";
		return "fail";
	}
	
	@Override
	public String onOrDown(String id, int shelf) {
		// TODO Auto-generated method stub
		return null;
	}

}

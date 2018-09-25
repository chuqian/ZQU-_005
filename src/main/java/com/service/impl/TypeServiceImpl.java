package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TypeDao;
import com.entity.Type;
import com.service.TypeService;

/**
 * @author liangjiahong
 * @date 2018年9月21日 下午6:23:11
 * @describe 商品类型实现
 */
@Service
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	private TypeDao typeDao;

	@Override
	public List<Type> getAllType() {
		return typeDao.findAll();
	}

	@Override
	public int saveType(Type type) {
		return typeDao.save(type);
	}

	@Override
	public int deleteOneType(String id) {
		return typeDao.deleteById(id);
	}

	@Override
	public int deleTypeOneCommodityType(String id, String commodityType) {
		return typeDao.deleteCommodityTypes(id, commodityType);
	}

}

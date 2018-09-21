package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TypeDao;
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

}

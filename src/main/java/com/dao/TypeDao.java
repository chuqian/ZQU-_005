package com.dao;

import com.entity.Type;

/**
 * @author liangjiahong
 * @date 2018年9月19日 上午11:50:09
 * @describe 商品类型接口
 */
public interface TypeDao extends BaseDao<Type> {
	
	/**
	 * 删除类型里的一个商品类型
	 * @param id
	 * @param commodityTypes
	 * @return
	 */
	int deleteCommodityTypes(String id, String commodityType);
}

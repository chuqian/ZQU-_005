package com.service;
/**
 * @author liangjiahong
 * @date 2018年9月21日 下午6:22:51
 * @describe 商品类型
 */

import java.util.List;

import com.entity.Type;

public interface TypeService {
	
	/**
	 * 所有商品类型
	 * @return
	 */
	public List<Type> getAllType();
	
	/**
	 * 添加一个类型/商品类型
	 * @param type
	 * @return
	 */
	public int saveType(Type type);
	
	/**
	 * 删除一个类型
	 * @param type
	 * @return
	 */
	public int deleteOneType(String id);
	
	/**
	 * 删除类型里的一个商品类型(修改)
	 * @return
	 */
	public int deleTypeOneCommodityType(String id, String commodityType);
}

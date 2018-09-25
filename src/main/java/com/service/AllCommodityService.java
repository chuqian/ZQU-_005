package com.service;
/**
 * @author liangjiahong
 * @date 2018年9月21日 下午6:25:25
 * @describe 平台商品
 */

import java.util.List;

import com.entity.AllCommodity;
import com.util.ConditionBeanUnit;

public interface AllCommodityService {
	
	/**
	 * 所有平台商品并分页
	 * @param skip
	 * @param limit
	 * @return
	 */
	public List<AllCommodity> getAllCommodityByPage(int skip, int limit);
	
	/**
	 * 商品搜索结果并分页（同时满足三个属性条件id、commodityName、commodityType）
	 * @param conditionBeanUnits
	 * @param skip
	 * @param limit
	 * @return
	 */
	public List<AllCommodity> getSearchCommodityByPage(List<ConditionBeanUnit> conditionBeanUnits,int skip, int limit);
	
	/**
	 * 添加/修改一条商品信息
	 * @param allCommodity
	 * @return
	 */
	public int saveOrUpdateOneAllCommodity(AllCommodity allCommodity);
	
	/**
	 * 根据商品id删除一条商品信息
	 * @param id
	 * @return
	 */
	public int deleteOneAllCommodity(String id);

}

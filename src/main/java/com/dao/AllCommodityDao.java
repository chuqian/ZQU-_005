package com.dao;

import java.util.List;

import com.entity.AllCommodity;
import com.util.ConditionBeanUnit;

/**
 * @author liangjiahong
 * @date 2018年9月19日 下午3:58:01
 * @describe 平台商品接口
 */
public interface AllCommodityDao extends BaseDao<AllCommodity> {
	
	/**
	 * 根据条件列表模糊查询商品信息
	 * @param conditionBeanUnits
	 * @param skip 跳过个数
	 * @param limit 查询个数
	 * @return
	 */
	List<AllCommodity> findFuzzy(List<ConditionBeanUnit> conditionBeanUnits,int skip, int limit);
}

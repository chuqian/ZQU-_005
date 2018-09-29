package com.service;

import com.entity.Collect;

/**
 * @author liangjiahong
 * @date 2018年9月29日 下午5:05:13
 * @describe 
 */
public interface CollectService {

	Collect findByCusIdAndCommodity(String customerId, String commodityId);
}

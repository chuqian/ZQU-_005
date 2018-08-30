package com.dao;

import java.util.List;

/**
 * @author chenchuqian
 * @date 2018年8月25日 上午11:11:01
 * @describe 公共Dao接口
 */
public interface BaseDao<T> {

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public T findById(String id);
	
	/**
	 * 所有数据查询
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 分页查询
	 * @param skip 跳过个数
	 * @param limit 查询个数
	 * @return
	 */
	public List<T> find(int skip, int limit);
	
	/**
	 * 新增单个数据
	 * @param objToSave
	 * @return 新增个数 
	 */
	public int insert(Object objToSave);
	
	/**
	 * 批量增加数据
	 * @param rows
	 * @return 增加数据数目
	 */
	public int insert(List<T> rows);
	
	/**
	 * 根据id删除数据
	 * @param id
	 * @return 删除数据数目
	 */
	public int deleteById(String id);
	
	/**
	 * 批量删除数据
	 * @param ids 
	 * @return 删除数据数目
	 */
	public int delete(String[] ids);
	
	/**
	 * 数据更新
	 * @param id
	 * @param objToUpdate
	 * @return 更新数目
	 */
	public int update(String id, Object objToUpdate);
	
}

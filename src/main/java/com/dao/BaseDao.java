package com.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.entity.Customer;

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
	 * 数据保存
	 * @param t
	 * @return
	 */
	public int save(T t);
	
	/**
	 * 批量数据保存
	 * @param rows
	 * @return
	 */
	public int save(List<T> rows);
	
	/**
	 * 根据id删除数据
	 * @param ids
	 * @return 删除数据数目
	 */
	public int deleteById(String... ids);

	/**
	 * 统计记录条数
	 * @return 
	 */
	public long rowsCount();

	/**
	 * add by lgp
	 * @param query
	 * @param update
	 * @param entityClass
	 * @description 修改数据
	 */
	public T findAndModify(Query query, Update update, Class<T> entityClass);
	
}

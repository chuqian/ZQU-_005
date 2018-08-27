package com.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.dao.BaseDao;

/**
 * @author chenchuqian
 * @date 2018年8月25日 下午7:53:03
 * @describe 
 * @param <T> 
 */
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private MongoTemplate mongoTemplate;
	private Class<T> clazz;
	
	public BaseDaoImpl() {
		ParameterizedType ptype = (ParameterizedType) 
				((Class<T>)this.getClass()).getGenericSuperclass();  //获取运行类的父类的参数化类型
		Type[] types = ptype.getActualTypeArguments();     //获取实际类型参数
		this.clazz = (Class<T>)types[0];
		
	}
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
	
	@Override
	public T findById(String id){
		return mongoTemplate.findById(id, clazz);
	}
	
	@Override
	public List<T> findAll() {
		return mongoTemplate.findAll(clazz);
	}

	@Override
	public List<T> findByPage(int skip, int limit){
		Query query = new Query().skip(skip).limit(limit);
		return mongoTemplate.find(query, clazz);
	}
	
	@Override
	public int insert(Object objToSave){
		mongoTemplate.insert(objToSave);
		return 1;
	}
	
	@Override
	public int insert(List<T> rows) {
		mongoTemplate.insertAll(rows);
		return rows.size();
	}

	@Override
	public int deleteById(String id){
		mongoTemplate.remove(new Query(Criteria.where("id").is(id)), clazz);
		return 1;
	}
	
	@Override
	public int delete(String[] ids) {
		for(int i=0; i<ids.length; i++)
			mongoTemplate.remove(new Query(Criteria.where("id").is(ids[i])), clazz);
		return ids.length;
	}

	@Override
	public int update(Object objToUpdate) {
		return 1;
	}
	
	@Override
	public int update(List<T> rows) {
		return rows.size();
	}
	
}

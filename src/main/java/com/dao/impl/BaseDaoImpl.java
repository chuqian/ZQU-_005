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
 * @describe 公共Dao实现类
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
	
	public String getCollectionName() {
		return clazz.getSimpleName().toLowerCase();
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
	public List<T> find(int skip, int limit){
		Query query = new Query().skip(skip).limit(limit);
		return mongoTemplate.find(query, clazz);
	}
	
	@Override
	public int save(T t) {
		System.out.println("the mongoTemplate value is " + mongoTemplate);
		System.out.println(t + "the t value");
		mongoTemplate.save(t);
		System.out.println("success to save the user");
		return 1;
	}
	
	@Override
	public int save(List<T> rows) {
		for(T t : rows){
			mongoTemplate.save(t);
		}
		return rows.size();
	}
	
	@Override
	public int deleteById(String... ids) {
		for(String id : ids)
			mongoTemplate.remove(new Query(Criteria.where("id").is(id)), clazz);
		return ids.length;
	}
	
	@Override
	public long rowsCount(){
		return mongoTemplate.count(new Query(), clazz);
	}
	
}


package com.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.dao.UserDao;
import com.entity.User;

/**
 *@author : lgpeng
 *@datetime : Sep 1, 2018 12:58:25 PM
 *@descriptioin :  
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	private static final String TARGET = "id";
	
	@Override
	public void addRole(String key, String value) {
		Update update = new Update().addToSet(key, value);
		this.getMongoTemplate().findAndModify(getQuery(key), update, User.class);
	}

	@Override
	public void updatePassword(String key, String value) {
		Update update = new Update().set(key, value);
		this.getMongoTemplate().updateFirst(getQuery(key), update, User.class);
	}
	
	private static final Query getQuery(String key) {
		return new Query(Criteria.where(TARGET).is(key));
	}
}

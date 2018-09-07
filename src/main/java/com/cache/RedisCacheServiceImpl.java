
package com.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
/**
 *@author : 李国鹏
 *@datetime : Sep 5, 2018 3:12:04 PM
 *@descriptioin :  
 */
@Service
public class RedisCacheServiceImpl implements BaseCacheService{
    
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public void set(String key, String value) {
		// TODO Auto-generated method stub
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return (String)redisTemplate.opsForValue().get(key);
	}

	@Override
	public void append(String key, String value) {
		// TODO Auto-generated method stub
		redisTemplate.opsForValue().append(key, value);
	}

	@Override
	public void del(String key) {
		// TODO Auto-generated method stub
		redisTemplate.delete(key);
	}

	@Override
	public void expire(String key, long seconds) {
		// TODO Auto-generated method stub
		redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
	}
	
	/**
	 * param ： key
	 * return ： 过期时间
	 * description ： 获取过期时间 
	 */
	@Override
	public Long ttl(String key) {
		// TODO Auto-generated method stub
		return this.redisTemplate.getExpire(key);
	}

	@Override
	public <T> long rPush(String key, List<T> list) {
		// TODO Auto-generated method stub
		return this.redisTemplate.opsForList().rightPush(key, list.toArray());
	}

	@SuppressWarnings("unchecked")
	public <T> T lindex(String key, long index) {
		return (T) this.redisTemplate.opsForList().index(key, index);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> lRange(String key, long start, long end) {
		return (List<T>) this.redisTemplate.opsForList().range(key, start, end);
	}

	@Override
	public void lTrim(String key, long start, long end) {
		this.redisTemplate.opsForList().trim(key, start, end);
	}

	@Override
	public <T> void setList(String key, List<T> list) {
		this.del(key);
		this.rPush(key, list);
	}

	@Override
	public void setHmap(String key, Map<String, Object> map) {
		this.redisTemplate.opsForHash().put(key, "12454", map);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getHmap(String key) {

		return (Map<String, Object>) this.redisTemplate.opsForHash().get(key, "12454");
	}

	@Override
	public void setPersist(String key) {
		redisTemplate.persist(key);

	}

	@Override
	public boolean isExist(String key) {
		return redisTemplate.hasKey(key);

	}
}

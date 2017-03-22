package com.yangle.web.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisBaseDao {

	private static final Logger logger = LoggerFactory.getLogger(RedisBaseDao.class);

	@Resource(name = "redisTemplate")
	protected RedisTemplate<String, String> valueOperations;

	public void del(String key) {
		valueOperations.delete(key);
	}

	public Boolean set(String key, String value) {
		try {
			valueOperations.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}

	public String get(String key) {
		try {
			return valueOperations.opsForValue().get(key);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	/**
	 * 列表操作--在列表头插入
	 * 
	 * @param key
	 * @param value
	 * @return 列表长度
	 */
	public long lLSet(String key, String value) {
		return valueOperations.opsForList().leftPush(key, value);
	}

	/**
	 * 列表操作--在列表尾插入
	 * 
	 * @param key
	 * @param value
	 * @return 列表长度
	 */
	public Long lRSet(String key, String value) {
		return valueOperations.opsForList().rightPush(key, value);
	}

	/**
	 * 列表操作--获取列表长度
	 * 
	 * @param key
	 * @return
	 */
	public Long lgetListSize(String key) {
		return valueOperations.opsForList().size(key);
	}

	/**
	 * 列表操作--获取列表
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public List<String> lgetList(String key, Long start, Long end) {
		return valueOperations.opsForList().range(key, start, end);
	}

	/**
	 * 列表操作--获取列表
	 * 
	 * @param key
	 * @return
	 */
	public List<String> lgetList(String key) {
		return valueOperations.opsForList().range(key, 0, valueOperations.opsForList().size(key));
	}

	/**
	 * Hash表操作--增加
	 * 
	 * @param key
	 * @param hashKey
	 * @param value
	 */
	public void hSet(String key, String hashKey, Object value) {
		valueOperations.opsForHash().put(key, hashKey, value);
	}

	/**
	 * Hash表操作--取值
	 * 
	 * @param key
	 * @param hashKey
	 * @return
	 */
	public Object hGet(String key, String hashKey) {
		return valueOperations.opsForHash().get(key, hashKey);
	}

	/**
	 * Hash表操作--删除
	 * 
	 * @param key
	 * @param fields
	 */
	public void hDel(String key, Object... fields) {
		valueOperations.opsForHash().delete(key, fields);
	}

	/**
	 * Hash表操作--获取所有值
	 * 
	 * @param key
	 * @return
	 */
	public Map<Object, Object> hGetAll(String key) {
		return valueOperations.opsForHash().entries(key);
	}

	/**
	 * set操作--增加
	 * 
	 * @param key
	 * @param values
	 */
	public void sAdd(String key, String... members) {
		valueOperations.opsForSet().add(key, members);
	}

	/**
	 * set操作--获取值
	 * 
	 * @param key
	 * @return
	 */
	public Set<String> sgetAll(String key) {
		return valueOperations.opsForSet().members(key);
	}

	/**
	 * SortedSet（有序集合）
	 * 
	 * @param key
	 * @param member
	 * @param score
	 */
	public void zAdd(String key, String member, double score) {
		valueOperations.opsForZSet().add(key, member, score);
	}

	/**
	 * SortedSet（有序集合）
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public Set<String> zRange(String key, double start, double end) {
		return valueOperations.opsForZSet().rangeByScore(key, start, end);
	}

}

package com.yangle.web.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;

/**
 * 利用序列化操作java对象
 * 
 * @author YL
 * 
 */
@Repository
public class RedisDao {

	private static final Logger logger = LoggerFactory.getLogger(RedisDao.class);

	@Resource(name = "redisTemplate")
	protected RedisTemplate<String, String> valueOperations;

	/**
	 * 保存java对象
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Boolean set(String key, Object value) {
		try {
			String json = JSON.toJSONString(value);
			valueOperations.opsForValue().set(key, json);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}

	/**
	 * 获取java对象
	 * 
	 * @param key
	 * @param clazz
	 * @return
	 */
	public <T> T get(String key, Class<T> clazz) {
		try {
			String value = valueOperations.opsForValue().get(key);
			return JSON.parseObject(value, clazz);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	/**
	 * 保存list
	 * 
	 * @param key
	 * @param list
	 */
	public <T> Boolean setList(String key, List<T> list) {
		try {
			String value = JSON.toJSONString(list);
			valueOperations.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}

	}

	/**
	 * 获取list对象
	 * 
	 * @param key
	 * @return
	 */
	public <T> List<T> getList(String key, Class<T> clazz) {
		try {
			String value = valueOperations.opsForValue().get(key);
			if (value == null || value.length() == 0) {
				return null;
			}
			List<T> list = JSON.parseArray(value, clazz);
			return list;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	/**
	 * 设置 map
	 * 
	 * @param <T>
	 * @param key
	 * @param value
	 */
	public <T> Boolean setMap(String key, Map<String, T> map) {
		try {
			String value = JSON.toJSONString(map);
			valueOperations.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}

	/**
	 * 获取map
	 * 
	 * @param <T>
	 * @param key
	 * @return list
	 */
	public <T> Map<String, T> getMap(String key) {
		try {
			String value = valueOperations.opsForValue().get(key);
			if (value == null || value.length() == 0) {
				return null;
			}
			Map<String, T> map = JSON.parseObject(value, Map.class);
			return map;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}
}

package com.yangle.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yangle.dubbo.vo.CityVo;
import com.yangle.web.dao.RedisBaseDao;
import com.yangle.web.dao.RedisDao;

@RestController
@RequestMapping("/redis")
public class RedisController {

	private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

	@Autowired
	private RedisBaseDao redisBaseDao;
	@Autowired
	private RedisDao redisDao;

	@RequestMapping("/save")
	public Boolean saveToRedis() {
		// redis存字符串
		redisBaseDao.set("string", "value");

		List<CityVo> list = new ArrayList<CityVo>();
		for (Long i = 0L; i < 5; i++) {
			CityVo city = new CityVo(i, i, "北京", "aaaaa", new Date());
			// 存java对象
			redisDao.set("city", city);
			list.add(city);
		}
		redisDao.setList("javalist", list);
		List<CityVo> list2 = redisDao.getList("javalist", CityVo.class);
		CityVo vo = redisDao.get("city11", CityVo.class);
		// map 对象
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		redisDao.setMap("map", map);
		Map<String, Object> map0 = redisDao.getMap("map");
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("a1", "b1");
		map1.put("a2", "b2");
		map1.put("a3", "b3");
		map1.put("a4", "b4");
		redisDao.setMap("map", map1);
		Map<String, Object> map2 = redisDao.getMap("map");
		// // 列表
		// redisBaseDao.lLSet("list", "11");
		// redisBaseDao.lLSet("list", "22");
		// redisBaseDao.lLSet("list", "33");
		// redisBaseDao.lRSet("list", "44");
		// List<String> resultList = redisBaseDao.lgetList("list");
		// Long listSize = redisBaseDao.lgetListSize("list");
		// // Hash
		// redisBaseDao.hSet("hash", "name", "yangle");
		// redisBaseDao.hSet("hash", "qq", "54363207");
		// redisBaseDao.hSet("hash", "aa", "aa");
		// redisBaseDao.hSet("hash", "bb", "bb");
		// String name = (String) redisBaseDao.hGet("hash", "name");
		// Map<Object, Object> map1 = redisBaseDao.hGetAll("hash");
		// redisBaseDao.hDel("hash", "name", "bb");
		// Map<Object, Object> map2 = redisBaseDao.hGetAll("hash");
		// // set
		// redisBaseDao.sAdd("set", "set1", "set2", "set3");
		// Set<String> set1 = redisBaseDao.sgetAll("set");
		// // zset
		// redisBaseDao.zAdd("zset", "z1", 1);
		// redisBaseDao.zAdd("zset", "z4", 4);
		// redisBaseDao.zAdd("zset", "z2", 2);
		// redisBaseDao.zAdd("zset", "z3", 3);
		// Set<String> set2 = redisBaseDao.zRange("zset", 0, 5);

		return true;
	}

	@RequestMapping("/get")
	public String getFromRedis(String key) {
		String result = redisBaseDao.get(key);
		return result;
	}
}

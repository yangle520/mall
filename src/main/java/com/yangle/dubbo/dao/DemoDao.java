package com.yangle.dubbo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface DemoDao {

	public Integer findCount();

	public List<String> findTableName();

}

package com.example.dubbo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface TestDao {

	public Integer findCount();

	public List<String> findTableName();

}

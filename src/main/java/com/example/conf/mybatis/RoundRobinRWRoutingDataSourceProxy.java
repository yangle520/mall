package com.example.conf.mybatis;

import java.util.List;

import javax.sql.DataSource;

public class RoundRobinRWRoutingDataSourceProxy {

	private DataSource writeDataSource;
	private List<Object> readDataSoures;
	private String readKey;
	private String writeKey;

	public DataSource getWriteDataSource() {
		return writeDataSource;
	}

	public void setWriteDataSource(DataSource writeDataSource) {
		this.writeDataSource = writeDataSource;
	}

	public List<Object> getReadDataSoures() {
		return readDataSoures;
	}

	public void setReadDataSoures(List<Object> readDataSoures) {
		this.readDataSoures = readDataSoures;
	}

	public String getReadKey() {
		return readKey;
	}

	public void setReadKey(String readKey) {
		this.readKey = readKey;
	}

	public String getWriteKey() {
		return writeKey;
	}

	public void setWriteKey(String writeKey) {
		this.writeKey = writeKey;
	}

}

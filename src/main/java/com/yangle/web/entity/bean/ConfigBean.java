package com.yangle.web.entity.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 从配置文件中读取变量 <strong>需要注入，new出来的获取不到值</strong>
 * 
 * @author YL
 * 
 */
@Configuration
@ConfigurationProperties(prefix = "com.yangle")
public class ConfigBean {

	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

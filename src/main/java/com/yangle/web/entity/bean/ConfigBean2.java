package com.yangle.web.entity.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 从自定义的配置文件中读取变量
 * 
 * @author YL
 * 
 */
// 如果不加@Configuration这个注释，需要在Application中@EnableConfigurationProperties({ConfigBean2.class})后指明加载那个bean
@Configuration
@ConfigurationProperties(prefix = "com.yangle")
@PropertySource("classpath:conf/config.properties")
public class ConfigBean2 {

	private String aa;
	private String bb;

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	public String getBb() {
		return bb;
	}

	public void setBb(String bb) {
		this.bb = bb;
	}

}

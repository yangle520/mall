package com.yangle;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// 启注解事务管理
@EnableTransactionManagement
// 从配置文件读取变量
@EnableConfigurationProperties
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	static {
		try {
			// 初始化log4j
			String log4jPath = "";
			// 配置本地地址
			log4jPath = DemoApplication.class.getClassLoader().getResource("").getPath() + "log4j.properties";
			PropertyConfigurator.configure(log4jPath);
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}

}

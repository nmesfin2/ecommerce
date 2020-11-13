package com.tcs.ecommerce.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;

public class DBConfig {
	@Autowired
	private Environment environment;
	
	@Bean("mysqlDataSource")
	public DataSource getMySQLDataSource() {
			System.out.println("Hello from Nati");
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(environment.getProperty("db.driver"));
			dataSource.setUrl(environment.getProperty("db.url"));
			dataSource.setUsername(environment.getProperty("db.username"));
			dataSource.setPassword(environment.getProperty("db.password"));
			
			return dataSource;
	}
}

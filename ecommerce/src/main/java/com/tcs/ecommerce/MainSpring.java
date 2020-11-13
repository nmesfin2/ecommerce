package com.tcs.ecommerce;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.ecommerce.config.DBConfig;

public class MainSpring {
	public static void main(String [] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		DataSource dataSource = context.getBean("mysqlDataSource", DataSource.class);
		
		DataSource dataSource2 = (DataSource) context.getBean("mysqlDataSource");
		System.out.println(dataSource.equals(dataSource2));
		System.out.println(dataSource == dataSource2);
		context.close();
	}
}

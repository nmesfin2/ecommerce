package com.tcs.ecommerce;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.ecommerce.config.DBConfig;
import com.tcs.ecommerce.model.Product;
import com.tcs.ecommerce.service.ProductService;

public class MainSpring {
	public static void main(String [] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		//DataSource dataSource = context.getBean("getMySQLDataSource", DataSource.class);
		/**
		DataSource dataSource2 = (DataSource) context.getBean("getMySQLDataSource");
		System.out.println(dataSource.equals(dataSource2));
		System.out.println(dataSource == dataSource2);
		*/
		ProductService productService = context.getBean(ProductService.class);
		ProductService productService2 = context.getBean(ProductService.class);
		Product product = new Product(1 ,"laptop modified", "i5 10th gen", 123.0f, "mac");
		String result = productService.createProduct(product);
		System.out.println(result);
		System.out.println(productService.equals(productService2));
		System.out.println(productService == productService2);
		
		Optional<List<Product>> optional = productService.getProductsByCategory("mac");
		if(optional.isPresent()) {
			List<Product> products = optional.get();
			products.forEach(p ->{
				System.out.println(p);
			});
		}else {
			System.out.println("not available");
		}
		
		
//		if(productService.getProductById(5).isPresent()) {
//			System.out.println("product exist");
//		}else {
//			System.out.println("not available");
//		}
		context.close();
	}
}

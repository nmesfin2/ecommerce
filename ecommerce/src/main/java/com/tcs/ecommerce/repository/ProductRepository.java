package com.tcs.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.ecommerce.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByCategory(String catName);
	
	// select * from product where price > priceValue
	List<Product> findByPriceGreaterThan(float priceValue);
	
	List<Product> findByPriceGreaterAndPriceLessThan(String category, float price);
	
	//("a%") : give me all the products start with a
	List<Product> findByProductNameLike(String productName);
}

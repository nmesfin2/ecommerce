package com.tcs.ecommerce.service;

import java.util.Optional;

import com.tcs.ecommerce.dao.ProductDAO;
import com.tcs.ecommerce.dao.ProductDAOImpl;
import com.tcs.ecommerce.model.Product;

public class ProductServiceImpl implements ProductService {
	
	private static ProductService productService;
	private ProductServiceImpl() {}
	
	public static ProductService getInstance() {
		if(productService == null) {
			productService = new ProductServiceImpl();
			return productService;
		}
		return productService;
	}
	
	ProductDAO dao = ProductDAOImpl.getInstance();
	// singlton implementation

	
	
	@Override
	public String createProduct(Product product) {
		// TODO Auto-generated method stub
		return dao.createProduct(product);
	}

	@Override
	public Optional<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		return dao.getProductById(id);
	}

}

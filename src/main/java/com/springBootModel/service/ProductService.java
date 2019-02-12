package com.springBootModel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootModel.model.Product;
import com.springBootModel.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product save(Product product) {
		return productRepository.save(product);
	}

}

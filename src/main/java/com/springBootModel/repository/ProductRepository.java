package com.springBootModel.repository;

import org.springframework.data.repository.CrudRepository;

import com.springBootModel.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}

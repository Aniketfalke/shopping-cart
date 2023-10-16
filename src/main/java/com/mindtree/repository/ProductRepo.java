package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	Product findByProductId(Integer productId);

	Product findByProductName(String productName);

	Product findByCategory(String category);

}

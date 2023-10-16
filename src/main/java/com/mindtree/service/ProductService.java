package com.mindtree.service;

import com.mindtree.entity.Product;
import com.mindtree.exception.ProductDoesNotExistException;

public interface ProductService {

	Product findByProductId(Integer productId) throws ProductDoesNotExistException;

	Product findByProductName(String productName) throws ProductDoesNotExistException;

	Product findByCategory(String category) throws ProductDoesNotExistException;

}

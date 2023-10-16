package com.mindtree.dao;

import com.mindtree.entity.Product;
import com.mindtree.exception.ProductDoesNotExistException;

public interface ProductDao {

	Product findByProductId(Integer productId) ;

	Product findByProductName(String productName);

	Product findByCategory(String category);

}

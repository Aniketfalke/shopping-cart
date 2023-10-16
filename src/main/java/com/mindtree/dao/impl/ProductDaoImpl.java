package com.mindtree.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.constant.ExceptionConstants;
import com.mindtree.dao.ProductDao;
import com.mindtree.entity.Product;
import com.mindtree.exception.ProductDoesNotExistException;
import com.mindtree.repository.ProductRepo;

@Component
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product findByProductId(Integer productId)  {
		// TODO Auto-generated method stub
		
		return productRepo.findByProductId(productId);
		
	}

	@Override
	public Product findByProductName(String productName) {
		// TODO Auto-generated method stub
		return productRepo.findByProductName(productName);
	}

	@Override
	public Product findByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepo.findByCategory(category);
	}

}

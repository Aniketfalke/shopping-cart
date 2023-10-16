package com.mindtree.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.constant.ExceptionConstants;
import com.mindtree.dao.ProductDao;
import com.mindtree.entity.Product;
import com.mindtree.exception.ProductDoesNotExistException;
import com.mindtree.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductDao productDao;
	
	public Product findByProductId(Integer productId) throws ProductDoesNotExistException {
		// TODO Auto-generated method stub
		Product existingProduct= productDao.findByProductId(productId);
		if(existingProduct==null) {
			throw new ProductDoesNotExistException(ExceptionConstants.INVALID_PRODUCT_ID_IN_REQUEST);
		}
		return existingProduct;
	}

	public Product findByProductName(String productName) throws ProductDoesNotExistException {
		// TODO Auto-generated method stub
		Optional<Product> existingProduct=Optional.ofNullable(productDao.findByProductName(productName));
		if(!existingProduct.isPresent()) {
			throw new ProductDoesNotExistException(ExceptionConstants.INVALID_PRODUCT_NAME_IN_REQUEST);
		}
		return existingProduct.get();
	}

	public Product findByCategory(String category) throws ProductDoesNotExistException {
		// TODO Auto-generated method stub
		Optional<Product>existingProduct= Optional.ofNullable(productDao.findByCategory(category));
		if(!existingProduct.isPresent()) {
			throw new ProductDoesNotExistException(ExceptionConstants.INVALID_CATEGORY_NAME_IN_REQUEST);
		}
		return existingProduct.get();
	}

}

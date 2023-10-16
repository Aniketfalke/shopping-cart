package com.mindtree.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Product;
import com.mindtree.exception.ProductDoesNotExistException;
import com.mindtree.repository.ProductRepo;
import com.mindtree.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	/*
	 * Logger for this class
	 */
	private static Logger logger=LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	/*
	 * Endpoint to fetch product using productId
	 */
	@GetMapping("/get/id/{id}")
	public ResponseEntity<?> getProductById(@PathVariable ("id")Integer productId) {
	
		try {
			logger.info("Request received to fetch  product from database using productId-{}",productId);
			return new ResponseEntity<Product> (productService.findByProductId(productId),HttpStatus.FOUND);
		} catch (ProductDoesNotExistException e) {
			// TODO Auto-generated catch block
			logger.error("ProductDoesNotExistException occured in productcontroller:;Message -{}",e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	/*
	 * Endpoint to fetch product using productName
	 */
	
	@GetMapping("/get/name/{name}")
	public ResponseEntity<?> getProductByName(@PathVariable ("name") String productName) {
		try {
			logger.info("Request received to fetch  product from database using  ProductName-{}",productName);
			return new ResponseEntity<Product>(productService.findByProductName(productName), HttpStatus.FOUND);
		} catch (ProductDoesNotExistException e) {
			// TODO Auto-generated catch block
			logger.error("ProductDoesNotExistException occured in productcontroller:;Message -{}",e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * Endpoint to fetch product using category
	 */
	@GetMapping("/get/category/{category}")
	public  ResponseEntity<?>  getProductByCategory(@PathVariable("category") String category) {
		try {
			logger.info("Request received to fetch  product from database using category-{}",category);
			return  ResponseEntity.status(HttpStatus.FOUND).body(productService.findByCategory(category));
		} catch (ProductDoesNotExistException e) {
			// TODO Auto-generated catch block
			logger.error("ProductDoesNotExistException occured in productcontroller:;Message -{}",e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

}

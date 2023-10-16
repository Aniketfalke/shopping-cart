package com.mindtree.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.MyCart;
import com.mindtree.exception.CartNotAssociatedException;
import com.mindtree.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	
	@Autowired
	private CartService cartService;
	/*
	 * logger for this class
	 */
	private static Logger logger=LoggerFactory.getLogger(CartController.class);
	
	@PostMapping("/save/{id}")
	public ResponseEntity<MyCart> saveCart(@RequestBody MyCart cart,@PathVariable ("id") Integer userId) {
		logger.info("Request received to save cart" );
		return ResponseEntity.status(HttpStatus.CREATED).body(cartService.saveCart(cart, userId));
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getCartById(@PathVariable ("id")Integer cartId) {
		try {
			logger.info("Request received to fetch cartItems list for CartId -{}", cartId);
			return ResponseEntity.ok(cartService.findByCartId(cartId));
		} catch (CartNotAssociatedException e) {
			// TODO Auto-generated catch block
			
			logger.info("CartNotAssociatedException Occured in CartController::getCartList.Message -{}",e.getMessage() );
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_FOUND);
			
		}
	}
	

	
}

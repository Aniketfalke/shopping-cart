package com.mindtree.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.CartItem;
import com.mindtree.exception.CartItemDoesNotExistException;
import com.mindtree.exception.CartNotAssociatedException;
import com.mindtree.exception.ProductDoesNotExistException;
import com.mindtree.service.CartItemService;

@RestController
@RequestMapping("/cart")
public class CartIteamController {
	/*
	 * Logger for this class
	 */
	private static Logger logger=LoggerFactory.getLogger(CartIteamController.class);
	
	
	@Autowired
	private CartItemService cartItemService;
	

	/*
	 * Endpoint to save cartItem in cart
	 */
	@PostMapping("/{cartId}/product/{productId}/add")
	public ResponseEntity<?> saveCartItem(@RequestBody CartItem cartIteam,@PathVariable Integer cartId,@PathVariable("productId") Integer productId){
		
		CartItem cartItem;
		try {
			logger.info("Request received to add cartItem in cart with cartId -{}",cartId);
			cartItem = cartItemService.saveCartItem(cartIteam,cartId,productId);
			return ResponseEntity.status(HttpStatus.CREATED).body(cartItem);

		} catch (CartNotAssociatedException | ProductDoesNotExistException e) {
			// TODO Auto-generated catch block
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	
		
	}
	 /*
	  * Endpoint to Delete Product Form cart
	  */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductFromCart(@PathVariable("id") Integer productId) {
		
		try {
			logger.info("Request Received to delete product with  productId -{} ",productId);
			return ResponseEntity.status(HttpStatus.OK).body(cartItemService.deleteProductFromCartItem(productId));
		} catch (ProductDoesNotExistException e) {
			// TODO Auto-generated catch block
			logger.error("ProductDoesNotExistException occured in cartItemController:: Messgase -{}",e.getMessage());
			return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}
	}
	
	/*
	 * Endpoint to Delete All product from cart
	 */
	@DeleteMapping("/delete/all/{cartId}")
	public ResponseEntity<String> deleteAllProductFromCart(@PathVariable Integer cartId) {
		try {
			logger.info("Request received to delete all product from cart-{}",cartId);
			return ResponseEntity.ok(cartItemService.deleteAllProductFromCartItem(cartId));
		} catch (CartItemDoesNotExistException e) {
			// TODO Auto-generated catch block
			logger.error("CartItemDoesNotExistException occured in cartItemController::Message-{}",e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	
	/*
	 * Endpoint to update product Quantity 
	 */
	@PutMapping("/update/{cartId}/product/{id}")
	public ResponseEntity<String> updateProductQuantity(@RequestBody CartItem cartItem, @PathVariable ("id") Integer ProductId,
			@PathVariable ("cartId")Integer cartId) {
		try {
			logger.info("Request received to Update  product from cart-{}",cartId);
			return ResponseEntity.ok(cartItemService.updateProductQuantity(cartItem,cartId,ProductId));
		} catch (CartItemDoesNotExistException e) {
			// TODO Auto-generated catch block
			logger.error("CartItemDoesNotExistException occured in cartItemController::Message-{}",e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
}

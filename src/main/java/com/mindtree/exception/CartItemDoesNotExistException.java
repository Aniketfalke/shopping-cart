package com.mindtree.exception;

public class CartItemDoesNotExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartItemDoesNotExistException(String message) {
		super(message);
	}
}

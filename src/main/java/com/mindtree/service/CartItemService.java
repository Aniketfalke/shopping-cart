package com.mindtree.service;

import com.mindtree.entity.CartItem;
import com.mindtree.exception.CartItemDoesNotExistException;
import com.mindtree.exception.CartNotAssociatedException;
import com.mindtree.exception.ProductDoesNotExistException;


public interface CartItemService {

	CartItem saveCartItem(CartItem cartIteam, Integer cartId, Integer productId) throws CartNotAssociatedException, ProductDoesNotExistException;

	String deleteProductFromCartItem(Integer productId) throws ProductDoesNotExistException;

	String deleteAllProductFromCartItem(Integer cartId) throws CartItemDoesNotExistException;

	String updateProductQuantity(CartItem cartItem, Integer cartId, Integer productId) throws CartItemDoesNotExistException;

}

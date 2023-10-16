package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.CartItem;

public interface CartItemDao {

	CartItem findByProductIdAndCartId(Integer productId, Integer cartId);

	CartItem save(CartItem tempCartItem);

	CartItem findByProductId(Integer productId);

	void delete(CartItem cartItem);

	List<CartItem> findByCardId(Integer cartId);

	void deleteAll(List<CartItem> cartItems);

}

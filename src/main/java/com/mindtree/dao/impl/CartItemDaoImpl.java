package com.mindtree.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.dao.CartItemDao;
import com.mindtree.entity.CartItem;
import com.mindtree.repository.CartItemRepo;


@Component
public class CartItemDaoImpl implements CartItemDao {
	
	@Autowired
	private CartItemRepo cartItemRepo;

	@Override
	public CartItem findByProductIdAndCartId(Integer productId, Integer cartId) {
		// TODO Auto-generated method stub
		return cartItemRepo.findByProductIdAndCartId(productId, cartId);
	}

	@Override
	public CartItem save(CartItem tempCartItem) {
		// TODO Auto-generated method stub
		return cartItemRepo.save(tempCartItem);
	}

	@Override
	public CartItem findByProductId(Integer productId) {
		// TODO Auto-generated method stub
		return cartItemRepo.findByProductId(productId);
	}

	@Override
	public void delete(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemRepo.delete(cartItem);
	}

	@Override
	public List<CartItem> findByCardId(Integer cartId) {
		// TODO Auto-generated method stub
		return cartItemRepo.findByCardId(cartId);
	}

	@Override
	public void deleteAll(List<CartItem> cartItems) {
		// TODO Auto-generated method stub
		cartItemRepo.deleteAll(cartItems);
	}

}

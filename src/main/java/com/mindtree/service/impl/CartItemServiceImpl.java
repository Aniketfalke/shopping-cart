package com.mindtree.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.constant.ExceptionConstants;
import com.mindtree.dao.CartDao;
import com.mindtree.dao.CartItemDao;
import com.mindtree.dao.ProductDao;
import com.mindtree.entity.CartItem;
import com.mindtree.entity.MyCart;
import com.mindtree.entity.Product;
import com.mindtree.exception.CartItemDoesNotExistException;
import com.mindtree.exception.CartNotAssociatedException;
import com.mindtree.exception.ProductDoesNotExistException;

import com.mindtree.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {
	/*
	 * Logger for this class
	 */
	private static Logger logger=LoggerFactory.getLogger(CartItemServiceImpl.class);
	@Autowired
	private CartItemDao cartItemDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	public CartItem saveCartItem(CartItem cartItem,Integer cartId,Integer productId) throws CartNotAssociatedException, ProductDoesNotExistException {
		
		/*
		 * Cheking product is already added or not 
		 */
		 
		 CartItem existingCartItem=cartItemDao.findByProductIdAndCartId(productId,cartId);
		
		if(existingCartItem!=null) {
			existingCartItem.setQuantity( existingCartItem.getQuantity()+1);
			return cartItemDao.save(existingCartItem);
		}
		/*
		 * fetching the cart details
		 */
		MyCart cart = cartDao.findByCartId(cartId);
			if(cart==null) {
				logger.error("CartNotAssociatedException occured in cartServiceImpl.class::Message -{}",ExceptionConstants.CART_MISSING_IN_CART_ITEM_REQUEST);
				throw new CartNotAssociatedException(ExceptionConstants.CART_MISSING_IN_CART_ITEM_REQUEST);
			}
			 cartItem.setCart(cart);
		
		/*
		 * fetching product from product Database;
		 */
		 Product product=productDao.findByProductId(productId);
		 if(product==null) {
			 logger.error("ProductDoesNotExistException occured in cartServiceImpl.class::Message -{}",ExceptionConstants.PRODUCT_MISSING_IN_CART_ITEM_REQUEST);
			 throw new ProductDoesNotExistException(ExceptionConstants.PRODUCT_MISSING_IN_CART_ITEM_REQUEST);
		 }
	      cartItem.setProduct(product);
	    
		return cartItemDao.save(cartItem);
	}
	
	
	
	public String deleteProductFromCartItem(Integer productId) throws ProductDoesNotExistException {
		// TODO Auto-generated method stub
		
		 Optional<CartItem> cartItem= Optional.ofNullable((cartItemDao.findByProductId(productId)));
		
		 if(!cartItem.isPresent()) {
			 throw new ProductDoesNotExistException(ExceptionConstants.PRODUCT_ID_INVALID_DELETE_REQUEST);
		 }
		 cartItemDao.delete(cartItem.get());
		
		return "Deleted Successfully";
	}
	
	
	public String deleteAllProductFromCartItem(Integer cartId) throws CartItemDoesNotExistException {
		// TODO Auto-generated method stub
		List<CartItem> cartItems=cartItemDao.findByCardId(cartId);
		if(cartItems==null) {
			throw new CartItemDoesNotExistException(ExceptionConstants.CART_ID_INVALID_DELETE_REQUEST);
		}
		cartItemDao.deleteAll(cartItems);
		return "Delected Successfully";
	}
	
	
	public String updateProductQuantity(CartItem cartItem,Integer cartId,Integer productId) throws CartItemDoesNotExistException {
		// TODO Auto-generated method stub
		CartItem existingCartItem=cartItemDao.findByProductIdAndCartId(productId, cartId);
		if(existingCartItem==null) {
			throw new CartItemDoesNotExistException(ExceptionConstants.CART_ITEM_MISSING_IN_REQUEST);
		}
		if(cartItem.getQuantity()<0) {
			return "Quantity should not be negative ";
		}
		if(cartItem.getQuantity()==0) {
			cartItemDao.delete(existingCartItem);
			return"updated successufully";
		}
		existingCartItem.setQuantity(cartItem.getQuantity());
		cartItemDao.save(existingCartItem);
		return "updated successfully";
	}

}

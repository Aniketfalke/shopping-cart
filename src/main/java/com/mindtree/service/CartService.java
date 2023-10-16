package com.mindtree.service;

import com.mindtree.entity.MyCart;
import com.mindtree.exception.CartNotAssociatedException;

public interface CartService {

	MyCart saveCart(MyCart cart, Integer userId);

	MyCart findByCartId(Integer cartId) throws CartNotAssociatedException;

}

package com.mindtree.dao;

import com.mindtree.entity.MyCart;
import com.mindtree.exception.CartItemDoesNotExistException;

public interface CartDao {

	MyCart findByCartId(Integer cartId) ;

	MyCart save(MyCart cart);

}

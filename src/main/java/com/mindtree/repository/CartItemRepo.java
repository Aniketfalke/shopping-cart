package com.mindtree.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.CartItem;
import com.mindtree.entity.Product;


@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer>{
	
	@Query(
			value="select * From cart_item where product_id=?1 And cart_id=?2",
			nativeQuery = true
	  )
	CartItem findByProductIdAndCartId(Integer ProductId, Integer cartId);

	@Query(
			value="select * From cart_item where product_id=?1 ",
			nativeQuery = true
	  )
     CartItem findByProductId(Integer productId);
	

	@Query(
			value="select * From cart_item where cart_id=?1 ",
			nativeQuery = true
	  )
	List<CartItem> findByCardId(Integer cartId);

	
	

}

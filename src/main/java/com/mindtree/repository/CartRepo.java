package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.MyCart;

public interface CartRepo extends JpaRepository<MyCart, Integer>{

	MyCart findByCartId(Integer cartId);

}

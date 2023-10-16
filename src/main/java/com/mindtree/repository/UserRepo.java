package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findByUserId(Integer userId);

}

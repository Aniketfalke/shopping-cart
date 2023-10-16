package com.mindtree.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.dao.UserDao;
import com.mindtree.entity.User;
import com.mindtree.repository.UserRepo;


@Component
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userRepo.findByUserId(userId);
	}

}

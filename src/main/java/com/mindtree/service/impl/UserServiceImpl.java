package com.mindtree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.UserDao;
import com.mindtree.entity.User;
import com.mindtree.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public  User saveUser(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

}

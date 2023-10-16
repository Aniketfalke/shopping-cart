package com.mindtree.dao;

import com.mindtree.entity.User;

public interface UserDao {

	User save(User user);

	User findByUserId(Integer userId);

}

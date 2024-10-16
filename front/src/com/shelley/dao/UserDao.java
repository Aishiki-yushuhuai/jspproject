package com.shelley.dao;

import com.shelley.entity.User;

public interface UserDao {
	
	User findById(Integer id);
	
	User findByUsernameAndPassword(User user);
	
	void save(User user);
	
	long getCountWithName(String name);
	
	Integer getId(String name);
	
	User get(Integer id);
	
	void update(User user);
	

}

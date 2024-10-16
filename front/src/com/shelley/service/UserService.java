package com.shelley.service;

import com.shelley.entity.User;

public interface UserService {
	
	User login(User user);
	
	void save(User user);
	
	long getCountWithName(String name);
	
	Integer getId(String name);
	
	void update(User user);
	
	User get(Integer id);
}

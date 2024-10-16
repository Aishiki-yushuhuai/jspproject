package com.shelley.dao;

import java.util.List;

import com.shelley.entity.User;

public interface UserDao {
	User findById(Integer id);
	
	User findByStatus(Integer status);
	
	User findByUsernameAndPassword(User user);
	
	Integer status(String username);
	
	List<User> getAllStatus(Integer sf,Integer ss,Integer index ,Integer pageSize);
	
	List<User> getAllStatusSearch(String username,Integer index ,Integer pageSize);
	
	
	Long getCount(Integer menuId);
	
	void delete(Integer id);
	
	long getCountWithName(String name);
	
	User get(Integer id);
	
	void update(User user);
	
	void save(User user);
	
	Integer getId(String name);
}

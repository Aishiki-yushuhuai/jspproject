package com.shelley.service.impl;

import java.util.Date;

import com.shelley.dao.UserDao;
import com.shelley.dao.impl.UserDaoImpl;
import com.shelley.entity.User;
import com.shelley.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(User user) {
		return userDao.findByUsernameAndPassword(user);
	}

	@Override
	public void save(User user) {
		user.setManager(1);
		user.setStatus(3);
		user.setTime(new Date());
		user.setMenuId(0);
		userDao.save(user);
	}

	@Override
	public long getCountWithName(String name) {
		
		return userDao.getCountWithName(name);
	}

	@Override
	public Integer getId(String name) {
		
		return userDao.getId(name);
	}

	@Override
	public void update(User user) {
		user.setTime(new Date());
		userDao.update(user);
	}

	@Override
	public User get(Integer id) {
		return userDao.get(id);
	}

}

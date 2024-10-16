package com.shelley.dao.impl;

import com.shelley.dao.UserDao;
import com.shelley.entity.User;
import com.shelley.util.DAO;

public class UserDaoImpl extends DAO<User> implements UserDao {

	@Override
	public User findById(Integer id) {
		String sql = "select id,username,password,manager,time from user where id = ?";
		return super.get(sql, id);
	}

	@Override
	public User findByUsernameAndPassword(User user) {
		String sql = "select id,username,password,manager,time,status from user where username = ? and password = ?";
		return super.get(sql, user.getUsername(),user.getPassword());
	}

	@Override
	public void save(User user) {
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		super.update(sql, null,user.getUsername(),user.getPassword(),user.getManager(),user.getTime(),user.getStatus(),user.getMenuId(),user.getPhone());
	}

	@Override
	public long getCountWithName(String name) {
		String sql = "select count(id) from user where username = ?";
		return super.getForValue(sql, name);
	}
	
	@Override
	public Integer getId(String name) {
		String sql = "select id from user where username = ?";
		return super.getForValue(sql, name);
	}

	@Override
	public User get(Integer id) {
		String sql="select id,username,password,manager,time,status,menuId,phone from user where id =?";
		return super.get(sql,id);
	}

	@Override
	public void update(User user) {
		String sql = "update user set username = ? , password = ?   where id = ?";
		super.update(sql, user.getUsername(),user.getPassword(),user.getId());
	}
}

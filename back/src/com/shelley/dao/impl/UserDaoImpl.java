package com.shelley.dao.impl;

import java.util.List;

import com.shelley.dao.UserDao;
import com.shelley.entity.User;
import com.shelley.util.DAO;

public class UserDaoImpl extends DAO<User> implements UserDao{

	@Override
	public User findByStatus(Integer status) {
		String sql = "select id,username,password,manager,time,status,menuId,phone from user where status = ?  ";
		return super.get(sql, status);
	}

	@Override
	public User findByUsernameAndPassword(User user) {
		String sql = "select id,username,password,manager,time,status,menuId,phone from user where username = ? and password = ? ";
		return super.get(sql, user.getUsername(),user.getPassword());
	}

	@Override
	public Integer status(String username) {
		String sql = "select status from user where username = ?";
		return super.getForValue(sql, username);
	}

	@Override
	public List<User> getAllStatus(Integer sf,Integer ss,Integer index, Integer pageSize) {
		String sql = "select id,username,password,manager,time,status,menuId,phone from user where status = ? or status = ? order by time asc limit ?,?";
		return super.getForList(sql, sf,ss,index,pageSize);
	}



	@Override
	public Long getCount(Integer menuId) {
		String sql = "select count(id) from user where menuId = ?";
		return super.getForValue(sql, menuId);
	}

	@Override
	public void delete(Integer id) {
		String sql ="delete from user where id = ?";
		super.update(sql, id);
	}

	@Override
	public User get(Integer id) {
		String sql="select id,username,password,manager,time,status,menuId,phone from user where id =?";
		return super.get(sql,id);
	}

	@Override
	public long getCountWithName(String name) {
		String sql = "select count(id) from user where username = ?";
		return super.getForValue(sql, name);
	}

	@Override
	public void update(User user) {
		String sql = "update user set username = ? , password = ?  ,phone =? where id = ?";
		super.update(sql, user.getUsername(),user.getPassword(),user.getPhone(),user.getId());
	}

	@Override
	public void save(User user) {
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		super.update(sql, null,user.getUsername(),user.getPassword(),user.getManager(),user.getTime(),user.getStatus(),user.getMenuId(),user.getPhone());
	}

	@Override
	public List<User> getAllStatusSearch(String username, Integer index, Integer pageSize) {
		String sql = "select id,username,password,manager,time,status,menuId,phone from user where username like ? order by time asc limit ?,?";
		return super.getForList(sql, username,index,pageSize);
	}

	@Override
	public Integer getId(String name) {
		String sql = "select id from user where username = ?";
		return super.getForValue(sql, name);
	}

	@Override
	public User findById(Integer id) {
		String sql = "select id,username,password,manager,time,status,menuId,phone from user where id = ?  ";
		return super.get(sql, id);
	}

	

}

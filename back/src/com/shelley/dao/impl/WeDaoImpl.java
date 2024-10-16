package com.shelley.dao.impl;

import java.util.List;

import com.shelley.dao.WeDao;
import com.shelley.entity.We;
import com.shelley.util.DAO;

public class WeDaoImpl extends DAO<We> implements WeDao{

	@Override
	public List<We> getAll(Integer menuId, Integer index, Integer pageSize) {
		String sql = "select id,address,telphone,person,manager,time,image,menuId from we where menuId = ? order by time desc limit ?,? ";
		return getForList(sql, menuId, index, pageSize);
	}

	@Override
	public void save(We we) {
		String sql = "insert into we values(?,?,?,?,?,?,?,?)";
		super.update(sql, null,we.getAddress(),we.getTelphone(),we.getPerson(),we.getManager(),we.getTime(),we.getImage(),we.getMenuId());
	}

	@Override
	public We get(Integer id, Integer menuId) {
		String sql = "select id,address,telphone,person,manager,time,image,menuId from we where id = ? and menuId = ? ";
		return super.get(sql,id,menuId);
	}

	@Override
	public void delete(Integer id) {
		String sql ="delete from we where id = ?";
		super.update(sql, id);
	}

	@Override
	public void update(We we) {
		String sql = "update we set address =? , telphone = ? , person = ? , manager = ?, time = ? ,image = ? ,menuId = ? where id = ?";
		super.update(sql, we.getAddress(),we.getTelphone(),we.getPerson(),we.getManager(),we.getTime(),we.getImage(),we.getMenuId(),we.getId());
		
	}

}

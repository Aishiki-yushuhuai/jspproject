package com.shelley.dao.impl;

import java.util.List;

import com.shelley.dao.InfoDao;
import com.shelley.entity.Info;
import com.shelley.util.DAO;

public class InfoDaoImpl extends DAO<Info> implements InfoDao {

	@Override
	public List<Info> getAll1(Integer index,Integer pageSize) {
		String sql = "select id,image,message,remark,manager,time,menuId from info where menuId = 1 limit ?,?";
		return getForList(sql,index,pageSize);
	}

	@Override
	public Info get(Integer id,Integer menuId) {
		String sql = "select id,image,message,remark,manager,time,menuId from info where menuId = ? and id = ?";
		return super.get(sql, menuId,id);
	}

	@Override
	public long getCount() {
		String sql = "select count(id) from info";
		return super.getForValue(sql);
	}

	@Override
	public List<Info> getAll2(Integer index, Integer pageSize) {
		String sql = "select id,image,message,remark,manager,time,menuId from info where menuId = 2 limit ?,?";
		return getForList(sql,index,pageSize);
	}

	@Override
	public List<Info> getAll3(Integer index, Integer pageSize) {
		String sql = "select id,image,message,remark,manager,time,menuId from info where menuId = 3 limit ?,?";
		return getForList(sql,index,pageSize);
	}

	@Override
	public List<Info> getAll4(Integer index, Integer pageSize) {
		String sql = "select id,image,message,remark,manager,time,menuId from info where menuId = 4 limit ?,?";
		return getForList(sql,index,pageSize);
	}

	@Override
	public List<Info> getAllByMenuId(Integer menuId, Integer index, Integer pageSize) {
		String sql = "select id,image,message,remark,manager,time from info where menuId = ? limit ?,?";
		return super.getForList(sql, menuId,index,pageSize);
	}

	@Override
	public long getCountByMenuId(Integer menuId) {
		String sql = "select count(id) from info where menuId = ?";
		return super.getForValue(sql,menuId);
	}

}

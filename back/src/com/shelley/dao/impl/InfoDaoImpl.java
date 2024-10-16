package com.shelley.dao.impl;

import java.util.List;

import com.shelley.dao.InfoDao;
import com.shelley.dto.InfoDTO;
import com.shelley.entity.Info;
import com.shelley.util.DAO;

public class InfoDaoImpl extends DAO<Info> implements InfoDao {

	@Override
	public List<Info> getAll(Integer menuId ,Integer index ,Integer pageSize) {
		String sql = "select id,image,message,remark,manager,time,menuId from info where menuId = ? order by time desc limit ?,? ";
		return getForList(sql, menuId, index, pageSize);
	}

	@Override
	public void save(Info info) {
		String sql = "insert into info values(?,?,?,?,?,?,?)";
		super.update(sql, info.getId(),info.getImage(),info.getMessage(),info.getRemark(),info.getManager(),info.getTime(),info.getMenuId());
	}

	@Override
	public Info get(Integer id, Integer menuId) {
		String sql = "select id,image,message,remark,manager,time,menuId from info where id = ? and menuId = ? ";
		return super.get(sql,id,menuId);
	}

	@Override
	public void delete(Integer id) {
		String sql ="delete from info where id = ?";
		super.update(sql, id);
	}

	@Override
	public long getCountWithName(String name) {
		String sql = "select count(id) from info where message = ?";
		return super.getForValue(sql, name);
	}

	@Override
	public void update(Info info) {
		String sql = "update info set image = ? , message = ? , remark = ? , manager = ?, time = ? ,menuId = ? where id = ?";
		super.update(sql, info.getImage(),info.getMessage(),info.getRemark(),info.getManager(),info.getTime(),info.getMenuId(),info.getId());
	}

	@Override
	public Long getCount(Integer menuId) {
		String sql = "select count(id) from info where menuId = ?";
		return super.getForValue(sql, menuId);
	}

	@Override
	public List<Info> getForListWithInfoSearch(Integer menuId,  String message, Integer index, Integer pageSize) {
		String sql = "select id,image,message,remark,manager,time,menuId from info where menuId = ? and message like ? order by time desc limit ?,? ";
		return super.getForList(sql, menuId,message,index,pageSize);
	}



}

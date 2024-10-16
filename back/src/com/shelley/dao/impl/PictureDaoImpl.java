package com.shelley.dao.impl;

import java.util.List;

import com.shelley.dao.PictureDao;
import com.shelley.entity.Picture;
import com.shelley.util.DAO;

public class PictureDaoImpl extends DAO<Picture> implements PictureDao{

	@Override
	public void delete(Integer id) {
		String sql ="delete from picture where id = ?";
		super.update(sql, id);
	}

	@Override
	public List<Picture> getAll(Integer menuId, Integer index, Integer pageSize) {
		String sql = "select id,image,manager,time,menuId from picture where menuId = ? order by time desc limit ?,? ";
		return getForList(sql, menuId, index, pageSize);
	}

	@Override
	public void save(Picture picture) {
		String sql = "insert into picture values(?,?,?,?,?)";
		super.update(sql,null,picture.getImage(),picture.getManager(),picture.getTime(),picture.getMenuId());
	}

	@Override
	public Long getCount(Integer menuId) {
		String sql = "select count(id) from picture where menuId = ?";
		return super.getForValue(sql, menuId);
	}

}

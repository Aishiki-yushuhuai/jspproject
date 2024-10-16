package com.shelley.dao.impl;

import java.util.List;

import com.shelley.dao.PictureDao;
import com.shelley.entity.Picture;
import com.shelley.util.DAO;

public class PictureDaoImpl extends DAO<Picture> implements PictureDao{

	@Override
	public List<Picture> getAll(Integer index, Integer pageSize) {
		String sql = "select id,image,manager,time,menuId from picture where menuId = 7 limit ?,?";
		return getForList(sql,index,pageSize);
	}
	
	@Override
	public long getCount() {
		String sql = "select count(id) from picture";
		return super.getForValue(sql);
	}
}

package com.shelley.dao.impl;

import java.util.List;

import com.shelley.dao.ReviewDao;
import com.shelley.entity.Review;
import com.shelley.util.DAO;

public class ReviewDaoImpl extends DAO<Review> implements ReviewDao{

	@Override
	public void delete(Integer id) {
		String sql ="delete from review where id = ?";
		super.update(sql, id);
	}

	@Override
	public List<Review> getAll(Integer menuId,Integer index ,Integer pageSize) {
		String sql = "select id,message,manager,time from review where menuId = ? order by time desc limit ?,? ";
		return getForList(sql,menuId, index, pageSize);
	}

	@Override
	public Long getCount(Integer menuId) {
		String sql = "select count(id) from review where menuId = ?";
		return super.getForValue(sql, menuId);
	}

}

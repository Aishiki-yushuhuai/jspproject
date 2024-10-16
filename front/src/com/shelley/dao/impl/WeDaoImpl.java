package com.shelley.dao.impl;

import java.util.List;

import com.shelley.dao.WeDao;
import com.shelley.entity.We;
import com.shelley.util.DAO;

public class WeDaoImpl extends DAO<We> implements WeDao{

	@Override
	public List<We> getAll(Integer menuId) {
		String sql = "select id,address,telphone,person,manager,time,image,menuId from we where menuId = ?";
		return getForList(sql, menuId);
	}

	

}

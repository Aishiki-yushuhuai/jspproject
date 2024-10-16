package com.shelley.service.impl;

import java.util.List;

import com.shelley.dao.WeDao;
import com.shelley.dao.impl.WeDaoImpl;
import com.shelley.entity.We;
import com.shelley.service.WeService;

public class WeServiceImpl implements WeService{
	private WeDao weDao = new WeDaoImpl();

	@Override
	public List<We> getAll(Integer menuId) {
		
		return weDao.getAll(menuId);
	}


}

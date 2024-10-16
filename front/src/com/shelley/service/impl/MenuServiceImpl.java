package com.shelley.service.impl;

import java.util.List;

import com.shelley.dao.MenuDao;
import com.shelley.dao.impl.MenuDaoImpl;
import com.shelley.entity.Menu;
import com.shelley.service.MenuService;

public class MenuServiceImpl implements MenuService {
	
	private MenuDao menuDao = new MenuDaoImpl();
	
	@Override
	public Menu getMenuByMenuId(Integer menuId) {
		return menuDao.getMenuById(menuId);
	}

	@Override
	public List<Menu> findAll() {
		
		return menuDao.findAll();
	}

}
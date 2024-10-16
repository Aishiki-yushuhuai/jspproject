package com.shelley.service;

import java.util.List;

import com.shelley.entity.Menu;

public interface MenuService {
	
	Menu getMenuByMenuId(Integer menuId);
	
	List<Menu> findAll();

}

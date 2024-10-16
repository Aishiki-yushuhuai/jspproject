package com.shelley.dao;

import java.util.List;

import com.shelley.entity.Menu;

public interface MenuDao {
	
	Menu getMenuById(Integer id);
	
	List<Menu> findAll();

}

package com.shelley.dao.impl;

import java.util.List;

import com.shelley.dao.MenuDao;
import com.shelley.entity.Menu;
import com.shelley.util.DAO;

public class MenuDaoImpl extends DAO<Menu> implements MenuDao {

	@Override
	public Menu getMenuById(Integer id) {
		
		return super.get("select id,name from menu where id = ?", id);
	}

	@Override
	public List<Menu> findAll() {
		String sql = "select id,name,manager,time from menu";
		return super.getForList(sql, null);
	}

}

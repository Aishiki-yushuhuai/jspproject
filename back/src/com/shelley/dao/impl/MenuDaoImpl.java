package com.shelley.dao.impl;

import com.shelley.dao.MenuDao;
import com.shelley.entity.Menu;
import com.shelley.util.DAO;

public class MenuDaoImpl extends DAO<Menu> implements MenuDao{

	@Override
	public Menu getMenuById(Integer id) {
		String sql = "select id,name from menu where id =  ?";
		return super.get(sql, id);
	}

}

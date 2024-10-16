package com.shelley.dao;

import java.util.List;

import com.shelley.entity.We;

public interface WeDao {
	
	List<We> getAll(Integer menuId);
	
}

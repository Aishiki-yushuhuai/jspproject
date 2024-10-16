package com.shelley.dao;

import java.util.List;

import com.shelley.entity.We;

public interface WeDao {
	
	List<We> getAll(Integer menuId ,Integer index ,Integer pageSize);

	void save(We we);

	We get(Integer id,Integer menuId);

	void delete(Integer id);

	void update(We we);

}

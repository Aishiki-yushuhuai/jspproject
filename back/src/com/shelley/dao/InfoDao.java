package com.shelley.dao;

import java.util.List;

import com.shelley.entity.Info;

public interface InfoDao {
	
	List<Info> getAll(Integer menuId ,Integer index ,Integer pageSize);
	
	void save(Info info);
	
	Info get(Integer id,Integer menuId);
	
	void delete(Integer id);
	
	/**
	 * 返回和name相等的记录数
	 */
	long getCountWithName(String name);

	void update(Info info);
	
	Long getCount(Integer menuId);
	
	List<Info> getForListWithInfoSearch(Integer menuId,  String message,Integer index, Integer pageSize);
}

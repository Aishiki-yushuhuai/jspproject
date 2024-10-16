package com.shelley.dao;

import java.util.List;

import com.shelley.entity.Info;

public interface InfoDao  {
	
	List<Info> getAll1(Integer index,Integer pageSize);
	List<Info> getAll2(Integer index,Integer pageSize);
	List<Info> getAll3(Integer index,Integer pageSize);
	List<Info> getAll4(Integer index,Integer pageSize);
	
	Info get(Integer id,Integer menuId);
	
	long getCount();
	
	List<Info> getAllByMenuId(Integer menuId,Integer index,Integer pageSize);
	
	long getCountByMenuId(Integer menuId);
}

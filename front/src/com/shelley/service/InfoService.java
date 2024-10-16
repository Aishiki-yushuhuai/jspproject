package com.shelley.service;

import com.shelley.entity.Info;
import com.shelley.util.PageHelper;

public interface InfoService {
	
	PageHelper<Info> getAll1(Integer page,Integer pageSize);
	PageHelper<Info> getAll2(Integer page,Integer pageSize);
	PageHelper<Info> getAll3(Integer page,Integer pageSize);
	PageHelper<Info> getAll4(Integer page,Integer pageSize);
	
	PageHelper<Info> getAllByMenuId(Integer menuId, Integer page,Integer pageSize);
	
	long getCountByMenuId(Integer menuId);
}

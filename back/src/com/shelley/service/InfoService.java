package com.shelley.service;

import com.shelley.dto.InfoDTO;
import com.shelley.entity.Info;
import com.shelley.util.PageHelper;

public interface InfoService {
	
	PageHelper<InfoDTO> getAllWithInfoDTO(Integer menuId, Integer page, Integer pageSize);
	
	PageHelper<Info> getAll(Integer menuId, Integer page, Integer pageSize);
	
	void save(Info info);
	
	void delete(Integer id);
	
	void update(Info info);
	
	Info get(Integer id,Integer menuId);
	
	
	/**
	 * 返回和name相等的记录数
     */
    long getCountWithName(String name);
    
    PageHelper<InfoDTO> getForListWithWithInfoSearch(Integer menuId,  String message, Integer page, Integer pageSize);
}

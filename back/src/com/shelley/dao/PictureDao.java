package com.shelley.dao;

import java.util.List;

import com.shelley.entity.Picture;

public interface PictureDao {
	
	void delete(Integer id);
	
	List<Picture> getAll(Integer menuId ,Integer index ,Integer pageSize);
	
	void save(Picture picture);
	
	Long getCount(Integer menuId);
	
	
	
}

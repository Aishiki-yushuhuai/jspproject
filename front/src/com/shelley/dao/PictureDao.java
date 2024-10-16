package com.shelley.dao;

import java.util.List;

import com.shelley.entity.Picture;

public interface PictureDao {
	List<Picture> getAll(Integer index,Integer pageSize);
	long getCount();
}

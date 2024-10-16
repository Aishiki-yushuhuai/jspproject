package com.shelley.dao;

import java.util.List;

import com.shelley.entity.Review;

public interface ReviewDao {
	void save(Review re);
	List<Review> getAll(Integer menuId,Integer index ,Integer pageSize);
	Long getCount(Integer menuId);
}

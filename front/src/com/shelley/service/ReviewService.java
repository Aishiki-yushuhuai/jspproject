package com.shelley.service;

import com.shelley.dto.ReviewDTO;
import com.shelley.entity.Review;
import com.shelley.util.PageHelper;

public interface ReviewService {
	
	void save(Review re);
	
	PageHelper<ReviewDTO> getAllWithReviewDTO(Integer menuId,Integer page, Integer pageSize);
}

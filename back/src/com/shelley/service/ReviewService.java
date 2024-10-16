package com.shelley.service;

import com.shelley.dto.ReviewDTO;
import com.shelley.util.PageHelper;

public interface ReviewService {
	
	void delete(Integer id);
	
	PageHelper<ReviewDTO> getAllWithReviewDTO(Integer menuId,Integer page, Integer pageSize);
	
}

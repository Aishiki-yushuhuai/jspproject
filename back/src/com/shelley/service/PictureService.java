package com.shelley.service;

import com.shelley.dto.PictureDTO;
import com.shelley.entity.Picture;
import com.shelley.util.PageHelper;

public interface PictureService {
	
	void save(Picture picture);
	
	void delete(Integer id);
	
	PageHelper<PictureDTO> getAllWithPictureDTO(Integer menuId, Integer page, Integer pageSize);
	
}

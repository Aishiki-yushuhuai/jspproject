package com.shelley.service;

import com.shelley.entity.Picture;
import com.shelley.util.PageHelper;

public interface PictureService {
	PageHelper<Picture> getAll(Integer page,Integer pageSize);
}

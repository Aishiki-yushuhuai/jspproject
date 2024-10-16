package com.shelley.service;

import com.shelley.dto.WeDTO;
import com.shelley.entity.We;
import com.shelley.util.PageHelper;

public interface WeService {
	
	PageHelper<WeDTO> getAllWithWeDTO(Integer menuId, Integer page, Integer pageSize);

	void save(We we);

	void delete(Integer id);

	void update(We we);

	We get(Integer id,Integer menuId);


}

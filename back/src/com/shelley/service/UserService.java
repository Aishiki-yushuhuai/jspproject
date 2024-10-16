package com.shelley.service;

import com.shelley.dto.UserDTO;
import com.shelley.entity.User;
import com.shelley.util.PageHelper;

public interface UserService {
	
	User login(User user);
	
	Integer statusId(String name);
	
	PageHelper<UserDTO> getAllWithUserDTO(Integer sf,Integer ss,Integer page, Integer pageSize);
	
	PageHelper<UserDTO> getAllWithUserDTOSearch(String username,Integer page, Integer pageSize);
	
	
	User get(Integer id);
	
	void delete(Integer id);
	
	long getCountWithName(String name);
	
	void update(User user);
	
	void save(User user);
	
	Integer getId(String name);
}

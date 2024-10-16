package com.shelley.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shelley.dao.UserDao;
import com.shelley.dao.impl.UserDaoImpl;
import com.shelley.dto.UserDTO;
import com.shelley.entity.User;
import com.shelley.service.UserService;
import com.shelley.util.Commons;
import com.shelley.util.PageHelper;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(User user) {
		
		return userDao.findByUsernameAndPassword(user);
	}

	@Override
	public Integer statusId(String name) {
		
		return userDao.status(name);
	}

	@Override
	public PageHelper<UserDTO> getAllWithUserDTO(Integer sf,Integer ss,Integer page, Integer pageSize) {
		PageHelper<UserDTO> pageHelper = new PageHelper<UserDTO>();
		//当前页
		pageHelper.setPage(page);
		//总记录数
		Long count = userDao.getCount(0);
		pageHelper.setTotalRecords(count);
		//总页数 = (double)总记录数 / 每页显示的条数 向上取整
		Integer pageCount = (int)Math.ceil((double)count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		//显示的数据
		List<User> list = userDao.getAllStatus(sf,ss,(page - 1) * pageSize, pageSize);
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		for (User user1 : list) {
			Integer status = user1.getManager();
			User user = userDao.findByStatus(status);
			UserDTO dto = new UserDTO();
			dto.setId(user1.getId());
			dto.setManagerName(user.getUsername());
			dto.setUsername(user1.getUsername());
			dto.setPassword(user1.getPassword());
			dto.setManager(user1.getManager());
			dto.setTime(user1.getTime());
			dto.setMenuId(0);
			dto.setStatus(user1.getStatus());
			dto.setPhone(user1.getPhone());
			dtoList.add(dto);
		}
		pageHelper.setData(dtoList);
		return pageHelper;
	}

	

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public User get(Integer id) {
		return userDao.get(id);
	}

	@Override
	public long getCountWithName(String name) {
		
		return userDao.getCountWithName(name);
	}

	@Override
	public void update(User user) {
		user.setTime(new Date());
		userDao.update(user);
	}

	@Override
	public void save(User user) {
		user.setManager(1);
		user.setStatus(2);
		user.setTime(new Date());
		user.setMenuId(0);
		userDao.save(user);
	}

	@Override
	public PageHelper<UserDTO> getAllWithUserDTOSearch(String username,Integer page, Integer pageSize) {
		PageHelper<UserDTO> pageHelper = new PageHelper<UserDTO>();
		//当前页
		pageHelper.setPage(page);
		//总记录数
		Long count = userDao.getCount(0);
		pageHelper.setTotalRecords(count);
		//总页数 = (double)总记录数 / 每页显示的条数 向上取整
		Integer pageCount = (int)Math.ceil((double)count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		//显示的数据
		String usernames = "%"+username+"%";
		List<User> list = userDao.getAllStatusSearch(usernames, (page - 1) * pageSize, pageSize);
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		for (User user1 : list) {
			Integer status = user1.getManager();
			User user = userDao.findByStatus(status);
			UserDTO dto = new UserDTO();
			dto.setId(user1.getId());
			dto.setManagerName(user.getUsername());
			dto.setUsername(user1.getUsername());
			dto.setPassword(user1.getPassword());
			dto.setManager(user1.getManager());
			dto.setTime(user1.getTime());
			dto.setMenuId(0);
			dto.setStatus(user1.getStatus());
			dto.setPhone(user1.getPhone());
			dtoList.add(dto);
		}
		pageHelper.setData(dtoList);
		return pageHelper;
	}

	@Override
	public Integer getId(String name) {
		
		return userDao.getId(name);
	}

	

}

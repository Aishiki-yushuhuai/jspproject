package com.shelley.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shelley.dao.UserDao;
import com.shelley.dao.WeDao;
import com.shelley.dao.impl.UserDaoImpl;
import com.shelley.dao.impl.WeDaoImpl;
import com.shelley.dto.WeDTO;
import com.shelley.entity.Info;
import com.shelley.entity.User;
import com.shelley.entity.We;
import com.shelley.service.WeService;
import com.shelley.util.PageHelper;

public class WeServiceImpl implements WeService{
	private WeDao weDao = new WeDaoImpl();
	private UserDao userDao = new UserDaoImpl();

	@Override
	public PageHelper<WeDTO> getAllWithWeDTO(Integer menuId, Integer page, Integer pageSize) {
		PageHelper<WeDTO> pageHelper = new PageHelper<WeDTO>();
		//当前页
		pageHelper.setPage(1);
		//总记录数
		pageHelper.setTotalRecords((long)1);
		//总页数 
		pageHelper.setPageCount(1);
		//显示的数据
		List<We> list = weDao.getAll(menuId, (page - 1) * pageSize, pageSize);
		List<WeDTO> dtoList = new ArrayList<WeDTO>();
		for (We we : list) {
			Integer id = we.getManager();
			User user = userDao.findById(id);
			WeDTO dto = new WeDTO();
			dto.setId(we.getId());
			dto.setAddress(we.getAddress());
			dto.setTelphone(we.getTelphone());
			dto.setPerson(we.getPerson());
			dto.setManager(we.getManager());
			dto.setUsername(user.getUsername());
			dto.setTime(we.getTime());
			dto.setImage(we.getImage());
			dto.setMenuId(menuId);
			
			dtoList.add(dto);
		}
		pageHelper.setData(dtoList);
		return pageHelper;
	}

	@Override
	public void save(We we) {
		we.setTime(new Date());
		weDao.save(we);
	}

	@Override
	public void delete(Integer id) {
		weDao.delete(id);
	}

	@Override
	public void update(We we) {
		we.setTime(new Date());
		weDao.update(we);
	}

	@Override
	public We get(Integer id, Integer menuId) {
		
		return weDao.get(id, menuId);
	}

}

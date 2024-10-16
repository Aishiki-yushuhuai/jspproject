package com.shelley.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shelley.dao.InfoDao;
import com.shelley.dao.UserDao;
import com.shelley.dao.impl.InfoDaoImpl;
import com.shelley.dao.impl.UserDaoImpl;
import com.shelley.dto.InfoDTO;
import com.shelley.entity.Info;
import com.shelley.entity.User;
import com.shelley.service.InfoService;
import com.shelley.util.Commons;
import com.shelley.util.PageHelper;

public class InfoServiceImpl implements InfoService {

	private InfoDao infoDao = new InfoDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	@Override
	public PageHelper<Info> getAll(Integer menuId, Integer page, Integer pageSize) {
		PageHelper<Info> pageHelper = new PageHelper<Info>();
		//当前页
		pageHelper.setPage(page);
		//总记录数
		Long count = infoDao.getCount(menuId);
		pageHelper.setTotalRecords(count);
		//总页数 = (double)总记录数 / 每页显示的条数 向上取整
		Integer pageCount = (int)Math.ceil((double)count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		//显示的数据
		List<Info> list = infoDao.getAll(menuId, (page - 1) * pageSize, pageSize);
		pageHelper.setData(list);
		return pageHelper;
	}

	@Override
	public void save(Info info) {
		info.setTime(new Date());
		infoDao.save(info);
	}

	@Override
	public PageHelper<InfoDTO> getAllWithInfoDTO(Integer menuId, Integer page, Integer pageSize) {
		PageHelper<InfoDTO> pageHelper = new PageHelper<InfoDTO>();
		//当前页
		pageHelper.setPage(page);
		//总记录数
		Long count = infoDao.getCount(menuId);
		pageHelper.setTotalRecords(count);
		//总页数 = (double)总记录数 / 每页显示的条数 向上取整
		Integer pageCount = (int)Math.ceil((double)count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		//显示的数据
		List<Info> list = infoDao.getAll(menuId, (page - 1) * pageSize, pageSize);
		List<InfoDTO> dtoList = new ArrayList<InfoDTO>();
		for (Info info : list) {
			Integer id = info.getManager();
			User user = userDao.findById(id);
			InfoDTO dto = new InfoDTO();
			dto.setId(info.getId());
			dto.setImage(info.getImage());
			dto.setMessage(info.getMessage());
			dto.setRemark(info.getRemark());
			dto.setUsername(user.getUsername());
			dto.setManager(info.getManager());
			dto.setTime(info.getTime());
			dto.setMenuId(menuId);
			
			dtoList.add(dto);
		}
		pageHelper.setData(dtoList);
		return pageHelper;
	}

	@Override
	public void delete(Integer id) {
		infoDao.delete(id);
	}

	@Override
	public void update(Info info) {
		info.setTime(new Date());
		infoDao.update(info);
	}

	@Override
	public Info get(Integer id,Integer menuId) {
		return infoDao.get(id, menuId);
	}

	@Override
	public long getCountWithName(String name) {
		
		return infoDao.getCountWithName(name);
	}

	@Override
	public PageHelper<InfoDTO> getForListWithWithInfoSearch(Integer menuId,  String message,Integer page, Integer pageSize) {
		PageHelper<InfoDTO> pageHelper = new PageHelper<InfoDTO>();
		//当前页
		pageHelper.setPage(page);
		//总记录数
		Long count = infoDao.getCount(menuId);
		pageHelper.setTotalRecords(count);
		//总页数 = (double)总记录数 / 每页显示的条数 向上取整
		Integer pageCount = (int)Math.ceil((double)count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		//显示的数据
		String messages = "%"+message+"%";
		List<Info> list = infoDao.getForListWithInfoSearch(menuId, messages, (page - 1) * pageSize, pageSize);
		List<InfoDTO> dtoList = new ArrayList<InfoDTO>();
		for (Info info : list) {
			Integer id = info.getManager();
			User user = userDao.findById(id);
			InfoDTO dto = new InfoDTO();
			dto.setId(info.getId());
			dto.setImage(info.getImage());
			dto.setMessage(info.getMessage());
			dto.setRemark(info.getRemark());
			dto.setUsername(user.getUsername());
			dto.setManager(info.getManager());
			dto.setTime(info.getTime());
			dto.setMenuId(menuId);
			
			dtoList.add(dto);
		}
		pageHelper.setData(dtoList);
		return pageHelper;
	}

}

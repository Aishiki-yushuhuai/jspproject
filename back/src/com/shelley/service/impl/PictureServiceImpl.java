package com.shelley.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shelley.dao.PictureDao;
import com.shelley.dao.UserDao;
import com.shelley.dao.impl.PictureDaoImpl;
import com.shelley.dao.impl.UserDaoImpl;
import com.shelley.dto.PictureDTO;
import com.shelley.entity.Picture;
import com.shelley.entity.User;
import com.shelley.service.PictureService;
import com.shelley.util.Commons;
import com.shelley.util.PageHelper;

public class PictureServiceImpl implements PictureService{
	
	private PictureDao pictureDao = new PictureDaoImpl();
	
	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public void save(Picture picture) {
		picture.setMenuId(7);
		picture.setTime(new Date());
		
		pictureDao.save(picture);
	}

	@Override
	public void delete(Integer id) {
		pictureDao.delete(id);
	}

	@Override
	public PageHelper<PictureDTO> getAllWithPictureDTO(Integer menuId, Integer page, Integer pageSize) {
		PageHelper<PictureDTO> pageHelper = new PageHelper<PictureDTO>();
		//当前页
		pageHelper.setPage(page);
		//总记录数
		Long count = pictureDao.getCount(menuId);
		pageHelper.setTotalRecords(count);
		//总页数 = (double)总记录数 / 每页显示的条数 向上取整
		Integer pageCount = (int)Math.ceil((double)count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		List<Picture> list = pictureDao.getAll(menuId,  (page - 1) * pageSize, pageSize);
		List<PictureDTO> dtoList = new ArrayList<PictureDTO>();
		for (Picture picture : list) {
			Integer status = picture.getManager();
			User user = userDao.findByStatus(status);
			PictureDTO dto = new PictureDTO();
			dto.setId(picture.getId());
			dto.setImage(picture.getImage());
			dto.setUsername(user.getUsername());
			dto.setManager(picture.getManager());
			dto.setTime(user.getTime());
			dto.setMenuId(menuId);
			
			dtoList.add(dto);
		}
		
		pageHelper.setData(dtoList);
		return pageHelper;
	}

}

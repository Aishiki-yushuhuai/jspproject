package com.shelley.service.impl;

import java.util.List;

import com.shelley.dao.PictureDao;
import com.shelley.dao.impl.PictureDaoImpl;
import com.shelley.entity.Picture;
import com.shelley.service.PictureService;
import com.shelley.util.Commons;
import com.shelley.util.PageHelper;

public class PictureServiceImpl implements PictureService{
	
	private PictureDao pictureDao = new PictureDaoImpl();
	
	@Override
	public PageHelper<Picture> getAll(Integer page, Integer pageSize) {
		PageHelper<Picture> pageHelper = new PageHelper<Picture>();
		// 当前页
		pageHelper.setPage(page);
		// 总记录数
		long count = pictureDao.getCount();
		pageHelper.setTotalRecords(count);
		// 总页数 = (double)总记录数 / 每页显示的条数
		Integer pageCount = (int) Math.ceil((double) count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		// 显示的数据
		List<Picture> list = pictureDao.getAll( (page - 1) * pageSize, pageSize);
		pageHelper.setData(list);

		return pageHelper;
	}

}

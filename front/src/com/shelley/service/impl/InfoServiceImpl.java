package com.shelley.service.impl;

import java.util.List;

import com.shelley.dao.InfoDao;
import com.shelley.dao.impl.InfoDaoImpl;
import com.shelley.entity.Info;
import com.shelley.service.InfoService;
import com.shelley.util.Commons;
import com.shelley.util.PageHelper;

public class InfoServiceImpl implements InfoService {

	private InfoDao infoDao = new InfoDaoImpl();

	@Override
	public PageHelper<Info> getAll1(Integer page, Integer pageSize) {
		PageHelper<Info> pageHelper = new PageHelper<Info>();
		// 当前页
		pageHelper.setPage(page);
		// 总记录数
		long count = infoDao.getCount();
		pageHelper.setTotalRecords(count);
		// 总页数 = (double)总记录数 / 每页显示的条数
		Integer pageCount = (int) Math.ceil((double) count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		// 显示的数据
		List<Info> list = infoDao.getAll1( (page - 1) * pageSize, pageSize);
		pageHelper.setData(list);

		return pageHelper;
	}
	@Override
	public PageHelper<Info> getAll2(Integer page, Integer pageSize) {
		PageHelper<Info> pageHelper = new PageHelper<Info>();
		// 当前页
		pageHelper.setPage(page);
		// 总记录数
		long count = infoDao.getCount();
		pageHelper.setTotalRecords(count);
		// 总页数 = (double)总记录数 / 每页显示的条数
		Integer pageCount = (int) Math.ceil((double) count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		// 显示的数据
		List<Info> list = infoDao.getAll2( (page - 1) * pageSize, pageSize);
		pageHelper.setData(list);

		return pageHelper;
	}
	@Override
	public PageHelper<Info> getAll3(Integer page, Integer pageSize) {
		PageHelper<Info> pageHelper = new PageHelper<Info>();
		// 当前页
		pageHelper.setPage(page);
		// 总记录数
		long count = infoDao.getCount();
		pageHelper.setTotalRecords(count);
		// 总页数 = (double)总记录数 / 每页显示的条数
		Integer pageCount = (int) Math.ceil((double) count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		// 显示的数据
		List<Info> list = infoDao.getAll3( (page - 1) * pageSize, pageSize);
		pageHelper.setData(list);

		return pageHelper;
	}
	@Override
	public PageHelper<Info> getAll4(Integer page, Integer pageSize) {
		PageHelper<Info> pageHelper = new PageHelper<Info>();
		// 当前页
		pageHelper.setPage(page);
		// 总记录数
		long count = infoDao.getCount();
		pageHelper.setTotalRecords(count);
		// 总页数 = (double)总记录数 / 每页显示的条数
		Integer pageCount = (int) Math.ceil((double) count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		// 显示的数据
		List<Info> list = infoDao.getAll4( (page - 1) * pageSize, pageSize);
		pageHelper.setData(list);

		return pageHelper;
	}
	@Override
	public PageHelper<Info> getAllByMenuId(Integer menuId, Integer page, Integer pageSize) {
		PageHelper<Info> pageHelper = new PageHelper<Info>();
		// 当前页
		pageHelper.setPage(page);
		// 总记录数
		long count = infoDao.getCountByMenuId(menuId);
		pageHelper.setTotalRecords(count);
		// 总页数 = (double)总记录数 / 每页显示的条数
		Integer pageCount = (int) Math.ceil((double) count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		// 显示的数据
		List<Info> list = infoDao.getAllByMenuId(menuId, (page - 1) * pageSize, pageSize);
		pageHelper.setData(list);
		return pageHelper;
	}
	@Override
	public long getCountByMenuId(Integer menuId) {
		
		return infoDao.getCountByMenuId(menuId);
	}
}

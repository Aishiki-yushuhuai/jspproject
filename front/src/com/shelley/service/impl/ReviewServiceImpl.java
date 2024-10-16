package com.shelley.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shelley.dao.ReviewDao;
import com.shelley.dao.UserDao;
import com.shelley.dao.impl.ReviewDaoImpl;
import com.shelley.dao.impl.UserDaoImpl;
import com.shelley.dto.ReviewDTO;
import com.shelley.entity.Review;
import com.shelley.entity.User;
import com.shelley.service.ReviewService;
import com.shelley.util.Commons;
import com.shelley.util.PageHelper;

public class ReviewServiceImpl implements ReviewService{
	private UserDao userDao = new UserDaoImpl();
	private ReviewDao reviewDao = new ReviewDaoImpl();
	
	@Override
	public void save(Review re) {
		re.setTime(new Date());
		reviewDao.save(re);
	}

	@Override
	public PageHelper<ReviewDTO> getAllWithReviewDTO(Integer menuId, Integer page, Integer pageSize) {
		PageHelper<ReviewDTO> pageHelper = new PageHelper<ReviewDTO>();

		//当前页
		pageHelper.setPage(page);
		//总记录数
		Long count = reviewDao.getCount(menuId);
		pageHelper.setTotalRecords(count);
		//总页数 = (double)总记录数 / 每页显示的条数 向上取整
		Integer pageCount = (int)Math.ceil((double)count / Commons.PAGE_SIZE);
		pageHelper.setPageCount(pageCount);
		//显示的数据
		List<Review> list = reviewDao.getAll(menuId, (page - 1) * pageSize, pageSize);
		List<ReviewDTO> dtoList = new ArrayList<ReviewDTO>();
		for (Review re : list) {
			Integer id = re.getManager();
			User user = userDao.findById(id);
			ReviewDTO dto = new ReviewDTO();
			dto.setId(re.getId());
			dto.setMessage(re.getMessage());
			dto.setUsername(user.getUsername());
			dto.setManager(re.getManager());
			dto.setTime(re.getTime());
			dto.setMenuId(menuId);

			dtoList.add(dto);
		}
		pageHelper.setData(dtoList);


		return pageHelper;
	}

}

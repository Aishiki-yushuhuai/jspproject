package com.shelley.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shelley.dto.ReviewDTO;
import com.shelley.entity.Review;
import com.shelley.service.ReviewService;
import com.shelley.service.UserService;
import com.shelley.service.impl.ReviewServiceImpl;
import com.shelley.service.impl.UserServiceImpl;
import com.shelley.util.Commons;
import com.shelley.util.PageHelper;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("*.rev")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private ReviewService reviewService = new ReviewServiceImpl();
	private UserService userService = new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0,methodName.length() - 4);
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menuIdStr = request.getParameter("menuId");
		String pageStr = request.getParameter("index");
		Integer menuId = null;
		Integer page = null;
		if(pageStr == null || "".equals(pageStr)) {
			pageStr = "1";
		}
		try {
			menuId = Integer.parseInt(menuIdStr.trim());
			request.getSession().setAttribute("menuId", menuId);
			page = Integer.parseInt(pageStr);
		} catch (NumberFormatException e) {}
		
		PageHelper<ReviewDTO> pageHelper = reviewService.getAllWithReviewDTO(menuId,page,Commons.PAGE_SIZE);
		request.setAttribute("pageHelper", pageHelper);
		request.getRequestDispatcher("/WEB-INF/info/review.jsp").forward(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String revStr = request.getParameter("rev");
		String username = request.getParameter("username");
		Integer id = userService.getId(username);
		try {
			Review review = new Review();
			review.setManager(id);
			review.setMenuId(5);
			review.setMessage(revStr);
			reviewService.save(review);
			request.setAttribute("msg", "1");
			response.sendRedirect("list.rev?menuId=5&index=1");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}

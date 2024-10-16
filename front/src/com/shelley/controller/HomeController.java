package com.shelley.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shelley.entity.Info;
import com.shelley.entity.Picture;
import com.shelley.entity.We;
import com.shelley.service.InfoService;
import com.shelley.service.PictureService;
import com.shelley.service.WeService;
import com.shelley.service.impl.InfoServiceImpl;
import com.shelley.service.impl.PictureServiceImpl;
import com.shelley.service.impl.WeServiceImpl;
import com.shelley.util.PageHelper;


@WebServlet("*.html")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InfoService infoService = new InfoServiceImpl();
	
	private PictureService pictureService = new PictureServiceImpl();
	
	private WeService weService = new WeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0,methodName.length() - 5);
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menuIdStr = request.getParameter("menuId");
		Integer menuId = null;
		try {
			menuId = Integer.parseInt(menuIdStr);
			request.getSession().setAttribute("menuId", menuId);
		} catch (Exception e) {
		}
		
		
		PageHelper<Info> infoList1 = infoService.getAll1(1,6);
		request.setAttribute("infoList1", infoList1);
		
		long menuId1 = infoService.getCountByMenuId(1);
		request.setAttribute("menuId1", menuId1);
		
		PageHelper<Info> infoList2 = infoService.getAll2(1,3);
		request.setAttribute("infoList2", infoList2);
		
		long menuId2 = infoService.getCountByMenuId(2);
		request.setAttribute("menuId2", menuId2);
		
		PageHelper<Info> infoList3 = infoService.getAll3(1,8);
		request.setAttribute("infoList3", infoList3);
		
		long menuId3 = infoService.getCountByMenuId(3);
		request.setAttribute("menuId3", menuId3);
		
		PageHelper<Info> infoList4 = infoService.getAll4(1,4);
		request.setAttribute("infoList4", infoList4);
		
		long menuId4 = infoService.getCountByMenuId(4);
		request.setAttribute("menuId4", menuId4);
		
		PageHelper<Picture> picList = pictureService.getAll(1,5);
		request.setAttribute("picList", picList);
		
		List<We> lou = weService.getAll(menuId);
		request.setAttribute("lou", lou);
		
		request.getRequestDispatcher("/WEB-INF/home/home.jsp").forward(request, response);
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/home/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}

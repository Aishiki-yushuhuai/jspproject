package com.shelley.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shelley.entity.Menu;
import com.shelley.service.MenuService;
import com.shelley.service.impl.MenuServiceImpl;

@WebServlet("*.html")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService menuService = new MenuServiceImpl();
	
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
		if(menuIdStr == null || "".equals(menuIdStr)) {
			menuIdStr = "8";
		}
		try {
			menuId = Integer.parseInt(menuIdStr.trim());
			request.getSession().setAttribute("menuId", menuId);
		} catch (NumberFormatException e) {}
		request.getRequestDispatcher("/WEB-INF/info/home.jsp").forward(request, response);
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/home/login.jsp").forward(request, response);
	}
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwordPath = "/error.jsp";
        String menuIdStr = request.getParameter("menuId");
        try {
        	Menu menu = menuService.getMenuByMenuId(Integer.parseInt(menuIdStr.trim()));
            if (menu != null){
            
                forwordPath = "/WEB-INF/home/add.jsp";
                request.setAttribute("menu",menu);
            	
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher(forwordPath).forward(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

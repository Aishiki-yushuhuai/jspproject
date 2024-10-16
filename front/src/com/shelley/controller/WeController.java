package com.shelley.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shelley.entity.We;
import com.shelley.service.WeService;
import com.shelley.service.impl.WeServiceImpl;

/**
 * Servlet implementation class WeController
 */
@WebServlet("*.our")
public class WeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WeService weService = new WeServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 4);
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menuIdStr = request.getParameter("menuId");
		Integer menuId = null;
		try {
			menuId = Integer.parseInt(menuIdStr);
			List<We> list = weService.getAll(menuId);
			request.setAttribute("list", list);

		} catch (Exception e) {
		}
		request.getRequestDispatcher("/WEB-INF/info/our.jsp").forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.shelley.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.shelley.entity.Info;
import com.shelley.entity.Menu;
import com.shelley.service.InfoService;
import com.shelley.service.MenuService;
import com.shelley.service.impl.InfoServiceImpl;
import com.shelley.service.impl.MenuServiceImpl;
import com.shelley.util.Commons;
import com.shelley.util.PageHelper;

@SuppressWarnings("unused")
@WebServlet("*.info")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InfoService infoService = new InfoServiceImpl();
	private MenuService menuService = new MenuServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 5);
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menuIdStr = request.getParameter("menuId");
		String indexStr = request.getParameter("index");
		Integer menuId = null;
		Integer index = null;
		try {
			menuId = Integer.parseInt(menuIdStr);
			request.getSession().setAttribute("menuId",menuId);
			index = Integer.parseInt(indexStr);
			PageHelper<Info> infoList = infoService.getAllByMenuId(menuId, index, 6);
			
			Menu menu = menuService.getMenuByMenuId(menuId);
			request.setAttribute("infoList", infoList);
			request.setAttribute("menu", menu);
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/info/list.jsp").forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

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

import com.shelley.dto.PictureDTO;
import com.shelley.entity.Menu;
import com.shelley.entity.Picture;
import com.shelley.service.PictureService;
import com.shelley.service.impl.PictureServiceImpl;
import com.shelley.util.Commons;
import com.shelley.util.PageHelper;


@WebServlet("*.pic")
public class PictureController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PictureService pictureService = new PictureServiceImpl();

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
		String pageStr = request.getParameter("page");
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
		PageHelper<PictureDTO> pageHelper = pictureService.getAllWithPictureDTO(menuId,page,Commons.PAGE_SIZE);
		request.setAttribute("pageHelper", pageHelper);
		request.getRequestDispatcher("/WEB-INF/picture/picture.jsp").forward(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idStr = request.getParameter("id");
		String menuIdStr = request.getParameter("menuId");
		int id = 0;
		int menuId= 0;
		try {
			menuId = Integer.parseInt(menuIdStr);
			id = Integer.parseInt(idStr);
			pictureService.delete(id);
		} catch (NumberFormatException e) {
		}
		response.sendRedirect("list.pic?menuId=" + menuId);
	}

	private void addedit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String forwordPath = "/error.jsp";
		String menuIdStr = request.getParameter("menuId");
		try {
			Integer menu = Integer.parseInt(menuIdStr);
			if (menu == 7){

				forwordPath = "/WEB-INF/picture/addPic.jsp";
				request.setAttribute("menu",menu);

			}
		}catch (Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(forwordPath).forward(request,response);

	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		Picture picture = new Picture();
		picture.setManager((int)(session.getAttribute("manager")));
		//1、FileItem有方法可以判断提交过来的数据是文件还是普通的文本，得到FileItem集合
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置内存中最多可以存放的上传文件的大小，若超出，则把文件写到一个临时文件夹中，以byte为单位
		factory.setSizeThreshold(1024*50);
		//指定临时目录
		File tempDirectory = new File("D:\\My Document\\PROGRAMME\\temp");
		if (!tempDirectory.exists()) {
			tempDirectory.mkdir();
		}
		//临时目录和工厂关联
		factory.setRepository(tempDirectory);
		//创建一个请求解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		//设置上传文件的总大小
		upload.setSizeMax(Commons.FILE_SIZE);

		try {
			List<FileItem> items = upload.parseRequest(request);
			//2、遍历items
			for (FileItem item : items) {
				//若是一个一般的表单，打印输出信息
				if(item.isFormField()) {
					String fieldName = item.getFieldName();
					String value = item.getString("utf-8");
				}else {
					// 获取文件名称
					String fileName = item.getName();
					InputStream inputStream = item.getInputStream();

					// 获取项目路径
					String realPath = request.getServletContext().getRealPath("");
					System.out.println(realPath);
					String contextPath = request.getContextPath();
					System.out.println(contextPath);
					// 服务器的根目录的路径
					String path = realPath.replace(contextPath.substring(1), "");
					System.out.println(path);
					// 根目录下拼接upload目录
					String uploadPath = path + "upload";
					//					String uploadPath = "D:\\my\\upload";
					String[] strings = fileName.split("\\.");
					// 处理文件名
					String ext = strings[strings.length - 1];
					String newFileName = UUID.randomUUID().toString().replace("-", "").substring(0,4)+ new Date().getTime() + new Random().nextInt(5) + "." + ext;
					File file = new File(uploadPath,newFileName);

					// 文件的复制
					FileUtils.copyInputStreamToFile(inputStream, file);

					// 返回图片的访问路径，并把路径保存到数据库
					String image = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ "/upload/" + newFileName;
					picture.setImage(image);
				}

			}
			picture.setMenuId(7);
			pictureService.save(picture);
			response.sendRedirect("list.pic?menuId=7");

		} catch (FileUploadException e) {
			request.setAttribute("size", "上传文件过大，最大不得超过1024*5000" );
			request.getRequestDispatcher("/WEB-INF/home/error.jsp").forward(request,response);
			e.printStackTrace();
		}
	}
}

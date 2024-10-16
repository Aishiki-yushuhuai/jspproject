package com.shelley.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shelley.entity.User;
import com.shelley.service.UserService;
import com.shelley.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("*.user")
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    private UserService userService = new UserServiceImpl();
    private String username577 = null;
    private String password577 = null;
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
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		username577 = request.getParameter("username");
		password577 = request.getParameter("password");
		
		User user = new User(username577,password577);
		User result = userService.login(user);
		if(result == null) {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("login.html").forward(request, response);
		}else if(result.getStatus() == 1 || result.getStatus() == 2){
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("login.html").forward(request, response);
			
		}else if(result.getStatus() == 3){
			HttpSession session = request.getSession();
			session.setAttribute("username", username577);
			session.setAttribute("manager", result.getId());
			response.sendRedirect("index.html");
		}
		
	}

	protected void sign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rep = request.getParameter("repassword");
		String phone = request.getParameter("phone");
		String code = request.getParameter("code");
		
		
		if(password.equals(rep) && "123456".equals(code.trim())) {
			
			long count = userService.getCountWithName(username);
			if(count > 0) {
				request.setAttribute("message", "用户名" + username + "已被占用，请重新填写！");
				request.getRequestDispatcher("/WEB-INF/home/login.jsp").forward(request, response);
				return;
			}
			try {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setPhone(phone);
				userService.save(user);
				request.setAttribute("mess", "注册成功请登录");
				request.getRequestDispatcher("/WEB-INF/home/login.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}else {
			
		}
		
	}
	protected void out(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.html?menuId=0");
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwordPath = "/error.jsp";
        try {
        	Integer id = userService.getId(username577);
            User user = userService.get(id);
            if (user != null){
                forwordPath = "/WEB-INF/info/update.jsp";
                request.setAttribute("user",user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher(forwordPath).forward(request,response);
    }
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String oldName = request.getParameter("oldName");
		String username = request.getParameter("username");
		String repw = request.getParameter("bfpassword");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		//2、验证name是否已被占用
		//3、比较name和oldname是否相同，如果相同，则name可用
		//4、如果不相同，调用service的getCountWithName，获取name在数据库是否存在
		if(!username.equals(oldName)) {
			long count = userService.getCountWithName(username);
			//5、如果返回值>0，则响应updatecustomer.jsp页面，通过请转发的方式响应
			if(count > 0) {
				//6、提示错误信息，用户名xxx已被占用，请重新填写
				request.setAttribute("message", "用户名" + username + "已被占用，请重新填写！");
				//7、结束方法：return
				request.getRequestDispatcher("/WEB-INF/info/update.jsp").forward(request, response);
				return;
			}
		}
		if(!repw.equals(password577)) {
			request.setAttribute("message2", "原密码错误！");
			//7、结束方法：return
			request.getRequestDispatcher("/WEB-INF/info/update.jsp").forward(request, response);
			return;
		}
		//8、如果验证通过，则把表单参数封装成一个Customer对象
		try {
			User user = new User();
			//9、调用service的update()
			user.setId(Integer.parseInt(idStr.trim()));
			user.setUsername(username);
			user.setPassword(password);
			user.setPhone(phone);
			userService.update(user);
			response.sendRedirect("index.html?menuId=0");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}

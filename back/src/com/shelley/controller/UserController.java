package com.shelley.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shelley.dto.UserDTO;
import com.shelley.entity.Menu;
import com.shelley.entity.User;
import com.shelley.service.UserService;
import com.shelley.service.impl.UserServiceImpl;
import com.shelley.util.Commons;
import com.shelley.util.PageHelper;

/**
 * Servlet implementation class UserController
 */
@WebServlet("*.user")
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    private UserService userService = new UserServiceImpl();
    
    private String username = null;
    private String password = null;
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
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		User user = new User(username,password);
		User result = userService.login(user);
		if(result == null) {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("login.html").forward(request, response);
		}else if(result.getStatus() != 3){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("manager", result.getId());
			response.sendRedirect("index.html");
		}else {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("login.html").forward(request, response);
		}
		
	}
	private void esmain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("menuId", 0);
		//查询所有用户
		PageHelper<UserDTO> pageHelper = userService.getAllWithUserDTOSearch(username,1,Commons.PAGE_SIZE);
		request.setAttribute("pageHelper", pageHelper);
		request.getRequestDispatcher("/WEB-INF/user/searchtop.jsp").forward(request, response);
	}
	
	
	
	
	
	
	
	private void editmain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwordPath = "/error.jsp";
        try {
        	Integer id = userService.getId(username);
        	User user = userService.get(id);
        	forwordPath = "/WEB-INF/user/updateUsertop.jsp";
        	request.setAttribute("user",user);
        }catch (Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher(forwordPath).forward(request,response);
    }
	private void updatemain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = userService.getId(username);
		String oldName = request.getParameter("oldName");
		String username = request.getParameter("username");
		String repw = request.getParameter("bfpassword");
		String newpassword = request.getParameter("password");
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
				request.getRequestDispatcher("/WEB-INF/user/updateUsertop.jsp").forward(request, response);
				return;
			}
		}
		if(!repw.equals(password)) {
			request.setAttribute("message2", "原密码错误！");
			//7、结束方法：return
			request.getRequestDispatcher("/WEB-INF/user/updateUsertop.jsp").forward(request, response);
			return;
		}
		//8、如果验证通过，则把表单参数封装成一个Customer对象
		try {
			User user = new User();
			//9、调用service的update()
			user.setId(id);
			user.setUsername(username);
			user.setPassword(newpassword);
			user.setPhone(phone);
			userService.update(user);
			//10、重定向到query.do
			response.sendRedirect("index.html?menuId=8");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("menuId", 0);
		Integer statusId = userService.statusId(username);
		String pageStr = request.getParameter("page");
		Integer page = null;
		if(pageStr == null || "".equals(pageStr)) {
			pageStr = "1";
		}
		try {
			page = Integer.parseInt(pageStr);
		} catch (Exception e) {
		}
		if(statusId == 1) {
			//查询所有用户
			PageHelper<UserDTO> pageHelper = userService.getAllWithUserDTO(2,3,page,Commons.PAGE_SIZE);
			request.setAttribute("pageHelper", pageHelper);
			request.getRequestDispatcher("/WEB-INF/user/user.jsp").forward(request, response);
		}else if(statusId == 2) {
			//查询游客
			PageHelper<UserDTO> pageHelper = userService.getAllWithUserDTO(3,null,page,Commons.PAGE_SIZE);
			request.setAttribute("pageHelper", pageHelper);
			request.getRequestDispatcher("/WEB-INF/user/user.jsp").forward(request, response);
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idStr = request.getParameter("id");
        
        int id = 0;
        int menuId= 0;
        try {

            id = Integer.parseInt(idStr);
            userService.delete(id);
        } catch (NumberFormatException e) {
        }
        response.sendRedirect("list.user?menuId=" + menuId);
    }
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwordPath = "/error.jsp";
        String idStr = request.getParameter("id");
        
        try {
            User user = userService.get(Integer.parseInt(idStr));
            if (user != null){
                forwordPath = "/WEB-INF/user/updateUser.jsp";
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
				request.getRequestDispatcher("/WEB-INF/user/updateUser.jsp").forward(request, response);
				return;
			}
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
			//10、重定向到query.do
			response.sendRedirect("list.user?menuId=0");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
	}
	
	private void addedit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/user/addUser.jsp").forward(request,response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		//2、检验name是否被占用
		//3、调用service的getCountWithName()，获取name在数据库中是否存在
		long count = userService.getCountWithName(name);
		if(count > 0) {
			//4、若返回值为>0，则响应newcustomer.jsp页面
			//通过请求转发
			//在newcustomer.jsp页面显示一个错误信息，用户名xxx已存在，请重新填写
			//newcustomer.jsp的信息可以回显
			request.setAttribute("message", "用户名" + name + "已被占用，请重新填写！");
			request.getRequestDispatcher("/WEB-INF/user/addUser.jsp").forward(request, response);
			//结束方法：return
			return;
		}
		//若验证通过，则把表单参数封装成一个对象
		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		user.setPhone(phone);
		//调用service的save方法，执行保存操作
		userService.save(user);
		//重定向到query.do
		response.sendRedirect("list.user?menuId=0");
	}
	
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchUsername = request.getParameter("username");
		HttpSession session = request.getSession();
		session.setAttribute("menuId", 0);
		String pageStr = request.getParameter("page");
		Integer page = null;
		if(pageStr == null || "".equals(pageStr)) {
			pageStr = "1";
		}
		try {
			page = Integer.parseInt(pageStr);
		} catch (Exception e) {
		}
			PageHelper<UserDTO> pageHelper = userService.getAllWithUserDTOSearch(searchUsername,page,Commons.PAGE_SIZE);
			request.setAttribute("pageHelper", pageHelper);
			request.getRequestDispatcher("/WEB-INF/user/user.jsp").forward(request, response);
		

	}
}

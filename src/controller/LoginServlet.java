package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.pojo.User;
import dao.tools.Md5Function;
import serVice.UserService;
import serVice.UserServiceImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String userName = request.getParameter("name");
		String userPassword = request.getParameter("passWord");
		if(userName==null||userPassword==null) {
			request.setAttribute("mes", "非法操作！请重试");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		userPassword = Md5Function.getMd5String(userPassword);
		
		User user = userService.userLogin(new User(userName,userPassword));
		if(user!=null) {
			request.getSession().setAttribute("user", user);
			request.getSession().setMaxInactiveInterval(30*60);
			response.sendRedirect("/carBooking/home/main.jsp");
			return;
		}else {
			request.setAttribute("mes", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

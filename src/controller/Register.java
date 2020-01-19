package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pojo.User;
import dao.tools.Md5Function;
import serVice.UserServiceImpl;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		pass = Md5Function.getMd5String(pass);
		String email = request.getParameter("email");
		String phonember = request.getParameter("phonember");
		if(name==null||name==""||pass==null||pass==""||email==null||email==""||phonember==null||phonember=="") {
			request.setAttribute("mes", "非法操作，请先登录");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		User user = new User(name, pass, email, phonember);
		
		boolean flag = new UserServiceImpl().userRegister(user);
		if(flag) {
			request.setAttribute("mes", "注册成功，请直接登录");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			response.getWriter().print("<script>alert(\"服务器已暂时关闭注册功能！\");</script>");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

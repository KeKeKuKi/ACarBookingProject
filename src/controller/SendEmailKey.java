package controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao.userDaoImpl;

/**
 * Servlet implementation class SendEmailKey
 */
@WebServlet("/SendEmailKey")
public class SendEmailKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailKey() {
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
		String email = request.getParameter("email");

		if("".equals(email)||email==null) {
			response.getWriter().print("wrron");
			return;
		}
		
		String emailkey = new String("");
		try {
			emailkey = new userDaoImpl().getEmailKey(email);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			response.getWriter().print("wrron");
			System.out.print(emailkey);
		}
		if(emailkey!=null) {
			response.getWriter().print(emailkey);
			System.out.print(emailkey);
		}else {
			response.getWriter().print("wrron");
			return;
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

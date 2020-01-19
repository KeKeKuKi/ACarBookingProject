package controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pojo.Car;
import serVice.CarService;
import serVice.CarServiceImpl;

/**
 * Servlet implementation class deleteCar
 */
@WebServlet("/deleteCar")
public class deleteCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String number = request.getParameter("id");
		int id;
		if(number != null) {
			 id = Integer.parseInt(number);
		}else {
			response.getWriter().print("false");
			return;
		}
		int count =new CarServiceImpl().deleteCar(id);
		if(count > 0) {
			response.getWriter().print("true");
		}else {
			response.getWriter().print("false");
		}
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

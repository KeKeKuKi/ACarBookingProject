package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pojo.Car;
import dao.tools.Page;
import serVice.CarServiceImpl;

/**
 * Servlet implementation class findByPrice
 */
@WebServlet("/findByPrice")
public class findByPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findByPrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		int pageNumber = 1;
		try {
	        pageNumber = Integer.parseInt(request.getParameter("page"));
            Page<Car> carPage = new CarServiceImpl().getCarByPrice(Long.parseLong(min), Long.parseLong(max));
            
            request.setAttribute("allCars",carPage.getPageDatas(pageNumber));
            request.setAttribute("pageBuffer",carPage.getPagMap(pageNumber));
            request.getRequestDispatcher("/home/welcome.jsp").forward(request, response);	
		}catch(Exception e) {
			Page<Car> carPage = new CarServiceImpl().getCarByPrice(0,0);
            
            request.setAttribute("allCars",carPage.getPageDatas(pageNumber));
            request.setAttribute("pageBuffer",carPage.getPagMap(pageNumber));
            request.getRequestDispatcher("/home/welcome.jsp").forward(request, response);	
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

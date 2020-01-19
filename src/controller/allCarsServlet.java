package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pojo.Car;
import dao.tools.Page;
import serVice.CarServiceImpl;

/**
 * Servlet implementation class allCarsServlet
 */
@WebServlet("/allCarsServlet")
public class allCarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

        try {
        	int pageNumber = Integer.parseInt(request.getParameter("page"));
            Page<Car> carPage = new CarServiceImpl().getAllCar();
            request.setAttribute("allCars",carPage.getPageDatas(pageNumber));
            request.setAttribute("pageBuffer",carPage.getPagMap(pageNumber));
        }catch (Exception e){
           e.printStackTrace();
        }
        
        request.getRequestDispatcher("/home/welcome.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

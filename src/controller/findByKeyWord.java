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
 * Servlet implementation class findByKeyWord
 */
@WebServlet("/findByKeyWord")
public class findByKeyWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findByKeyWord() {
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
		// TODO Auto-generated method stub
		String word = request.getParameter("word");
		try {
			if(word!=null&&!"".equals(word)) {
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=UTF-8");
				
		        int pageNumber = Integer.parseInt(request.getParameter("page"));
	            Page<Car> carPage = new CarServiceImpl().getLikeCars(word);
	            request.setAttribute("allCars",carPage.getPageDatas(pageNumber));
	            request.setAttribute("pageBuffer",carPage.getPagMap(pageNumber));
	            request.getRequestDispatcher("/home/welcome.jsp").forward(request, response);
			}else {
				return;
			}
		}catch(Exception e) {
			e.printStackTrace();
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

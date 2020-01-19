package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pojo.Car;
import serVice.CarServiceImpl;

/**
 * Servlet implementation class findById
 */
@WebServlet("/findById")
public class findById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findById() {
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
		
		
		String idNumber = request.getParameter("id");
		int id;
		try {
			id = Integer.parseInt(idNumber);
		}catch(Exception e) {
			id = -1;
		}
		Car car = new CarServiceImpl().getCarById(id);
		List<Car> cars = new ArrayList<Car>();
		if(car!=null) {
			cars.add(car);
			request.setAttribute("allCars", cars);
		}else {
			Map <String,String> pageBuffer = new HashMap<String, String>();
			pageBuffer.put("查询不到有关记录", "");
			request.setAttribute("pageBuffer",pageBuffer);
		}

		
		request.getRequestDispatcher("/home/welcome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

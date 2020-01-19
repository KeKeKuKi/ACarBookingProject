package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pojo.Car;
import serVice.CarService;
import serVice.CarServiceImpl;

/**
 * Servlet implementation class updateCar
 */
@WebServlet("/updateCar")
public class updateCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCar() {
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
		String carId = request.getParameter("carid");
		String carName = request.getParameter("carname");
		String carType = request.getParameter("cartype");
		String carPrice = request.getParameter("carprice");
		
		try {
			int id = Integer.parseInt(carId);
			float price = Float.parseFloat(carPrice);
			
			Car car = new Car();
			car.setCarId(id);
			car.setCarName(carName);
			car.setCarType(carType);
			car.setCarPrice(price);
			int flag = new CarServiceImpl().updateCar(car);
			if(flag<=0) {
				response.getWriter().print("false");
			}else {
				response.getWriter().print("true");
			}
			
		}catch(Exception e) {
			response.getWriter().print("false");
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

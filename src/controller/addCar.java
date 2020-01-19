package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pojo.Car;
import serVice.CarServiceImpl;

/**
 * Servlet implementation class addCar
 */
@WebServlet("/addCar")
public class addCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCar() {
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
		String carName = request.getParameter("acarname");
		String carType = request.getParameter("acartype");
		String carPrice = request.getParameter("acarprice");
		
		try {
			float price = Float.parseFloat(carPrice);
			
			Car car = new Car();

			car.setCarName(carName);
			car.setCarType(carType);
			car.setCarPrice(price);
			car.setCarPhotoAdress("https://image.baidu.com/search/index?tn=baiduimage&word=");
			
			int flag = new CarServiceImpl().addCar(car);
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

package serVice;

import java.util.List;

import dao.carDao.carDao;
import dao.carDao.carDaoImpl;
import dao.pojo.Car;
import dao.tools.Page;

public class CarServiceImpl implements CarService{
	carDao carDao = new carDaoImpl();

	@Override
	public Page<Car> getAllCar() {
		Page<Car> pages = new Page<Car>(carDao.selectAllCar(),"/allCarsServlet","");
        return pages;
	}

	@Override
	public Page<Car> getLikeCars(String word) {
		Page<Car> pages = new Page<Car>(carDao.selectLikeCars(word),"/findByKeyWord","&word="+word);
        return pages;
	}

	@Override
	public Page<Car> getCarByPrice(long min, long max) {
		Page<Car> pages = new Page<Car>(carDao.selectByPrice(min, max),"/findByPrice","&min="+min+"&max="+max);
		return pages;
	}

	@Override
	public Car getCarById(int id) {
		// TODO Auto-generated method stub
		return carDao.selectCarById(id);
	}

	@Override
	public int addCar(Car car) {
		// TODO Auto-generated method stub
		return carDao.addCar(car);
	}

	@Override
	public int deleteCar(int carId) {
		// TODO Auto-generated method stub
		return carDao.deleteCar(carId);
	}

	@Override
	public int updateCar(Car car) {
		// TODO Auto-generated method stub
		return carDao.updateCar(car);
	}

}

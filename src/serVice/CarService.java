package serVice;

import java.util.List;

import dao.pojo.Car;
import dao.tools.Page;

public interface CarService {
	public Page<Car> getAllCar();
	public Page<Car> getLikeCars(String word);
	public Page<Car> getCarByPrice(long min,long max);
	public Car getCarById(int id);
	public int addCar(Car car);
	public int deleteCar(int carId);
	public int updateCar(Car car);
}

package dao.carDao;

import java.util.List;

import dao.pojo.Car;

public interface carDao {
	public List<Car> selectAllCar();
	public List<Car> selectLikeCars(String word);
	public List<Car> selectByPrice(long min,long max);
	public Car selectCarById(int id);
	public int addCar(Car car);
	public int deleteCar(int carId);
	public int updateCar(Car car);
}

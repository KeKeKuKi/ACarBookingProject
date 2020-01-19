package dao.carDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.pojo.Car;
import dao.tools.ConnectionTool;

public class carDaoImpl implements carDao {

	/**
	 * 查询所有汽车信息
	 */
	@Override
	public List<Car> selectAllCar() {
		ArrayList<Car> cars = new ArrayList<Car>();
		PreparedStatement pStatement = null;
		Connection con = null;

		try {

			try {
				con = ConnectionTool.getConnection();
				String sql1 = "select * from car order by carprice";
				PreparedStatement pStatement1 = con.prepareStatement(sql1);
				ResultSet re = pStatement1.executeQuery();
				while (re.next()) {
					Car car = new Car();
					car.setCarId(re.getInt(1));
					car.setCarName(re.getString(2));
					car.setCarType(re.getString(3));
					car.setCarPrice(re.getFloat(4));
					car.setCarPhotoAdress(re.getString(5));

					cars.add(car);
				}
				return cars;
			} catch (Exception sqle) {
				System.out.println("SQL错误！");
				return null;
			} finally {
				con.close();
			}

		} catch (Exception e) {
			System.out.println("找不到驱动类!");
			return null;
		}
	}

	@Override
	public List<Car> selectLikeCars(String word) {
		ArrayList<Car> cars = new ArrayList<Car>();
		PreparedStatement pStatement = null;
		Connection con = null;

		try {

			try {
				con = ConnectionTool.getConnection();
				String sql1 = "select * from car where carname like ?";
				PreparedStatement pStatement1 = con.prepareStatement(sql1);
				pStatement1.setString(1, "%" + word + "%");
				ResultSet re = pStatement1.executeQuery();
				while (re.next()) {
					Car car = new Car();
					car.setCarId(re.getInt(1));
					car.setCarName(re.getString(2));
					car.setCarType(re.getString(3));
					car.setCarPrice(re.getFloat(4));
					car.setCarPhotoAdress(re.getString(5));

					cars.add(car);
				}
				return cars;
			} catch (Exception sqle) {
				System.out.println("SQL错误！");
				return null;
			} finally {
				con.close();
			}

		} catch (Exception e) {
			System.out.println("找不到驱动类!");
			return null;
		}
	}

	@Override
	public List<Car> selectByPrice(long min, long max) {
		ArrayList<Car> cars = new ArrayList<Car>();
		PreparedStatement pStatement = null;
		Connection con = null;

		try {

			try {
				con = ConnectionTool.getConnection();
				String sql1 = "select * from car where carprice between ? and ?";
				PreparedStatement pStatement1 = con.prepareStatement(sql1);
				pStatement1.setLong(1, min);
				pStatement1.setLong(2, max);
				ResultSet re = pStatement1.executeQuery();
				while (re.next()) {
					Car car = new Car();
					car.setCarId(re.getInt(1));
					car.setCarName(re.getString(2));
					car.setCarType(re.getString(3));
					car.setCarPrice(re.getFloat(4));
					car.setCarPhotoAdress(re.getString(5));

					cars.add(car);
				}
				return cars;
			} catch (Exception sqle) {
				System.out.println("SQL错误！");
				return null;
			} finally {
				con.close();
			}

		} catch (Exception e) {
			System.out.println("找不到驱动类!");
			return null;
		}
	}

	@Override
	public Car selectCarById(int id) {
		PreparedStatement pStatement = null;
		Connection con = null;
		

		try {

			try {
				con = ConnectionTool.getConnection();
				String sql1 = "select * from car where carid=?";
				PreparedStatement pStatement1 = con.prepareStatement(sql1);
				pStatement1.setInt(1, id);
				ResultSet re = pStatement1.executeQuery();
				while (re.next()) {
					Car returnCar = new Car();
					returnCar.setCarId(re.getInt(1));
					returnCar.setCarName(re.getString(2));
					returnCar.setCarType(re.getString(3));
					returnCar.setCarPrice(re.getFloat(4));
					returnCar.setCarPhotoAdress(re.getString(5));
					return returnCar;
				}
				return null;
			} catch (Exception sqle) {
				sqle.printStackTrace();
				return null;
			} finally {
				con.close();
			}

		} catch (Exception e) {
			System.out.println("找不到驱动类!");
			return null;
		}
	}

	@Override
	public int addCar(Car car) {
		PreparedStatement pStatement = null;
		Connection con = null;

		try {

			try {
				String carName = car.getCarName();
				String carType = car.getCarType();
				float carPrice = car.getCarPrice();
				String  carPhotoAdress = car.getCarPhotoAdress();

				con = ConnectionTool.getConnection();
				String sql2 = "insert into car(carname,cartype,carprice,carphoto) values(?,?,?,?)";
				pStatement = con.prepareStatement(sql2);// 预编译，提高性能
				pStatement.setString(1, carName);
				pStatement.setString(2, carType);
				pStatement.setFloat(3, carPrice);
				pStatement.setString(4, carPhotoAdress);
				int x = pStatement.executeUpdate();
				if(x>0) return x;
				else return 0;

			} catch (Exception sqle) {
				System.out.println("SQL错误！");
				return 0;
			}finally {
				con.close();
			}

		} catch (Exception e) {
			System.out.println("找不到驱动类!");
			return 0;
		}
	}

	@Override
	public int deleteCar(int carId) {
		PreparedStatement pStatement = null;
		Connection con = null;

		try {

			try {
				con = ConnectionTool.getConnection();
				String sql2 = "delete from car where carid = ?";
				pStatement = con.prepareStatement(sql2);
				pStatement.setInt(1, carId);
				int x = pStatement.executeUpdate();
				if(x>0) return x;
				else return 0;

			} catch (Exception sqle) {
				System.out.println("SQL错误！");
				return 0;
			}finally {
				con.close();
			}

		} catch (Exception e) {
			System.out.println("找不到驱动类!");
			return 0;
		}
	}

	@Override
	public int updateCar(Car car) {
		PreparedStatement pStatement = null;
		Connection con = null;

		try {

			try {
				con = ConnectionTool.getConnection();
				String sql2 = "UPDATE car SET carname=? ,cartype=?,carprice=? WHERE carid=?";
				pStatement = con.prepareStatement(sql2);
				pStatement.setString(1, car.getCarName());
				pStatement.setString(2, car.getCarType());
				pStatement.setFloat(3, car.getCarPrice());
				pStatement.setInt(4, car.getCarId());
				int x = pStatement.executeUpdate();
				if(x>0) return x;
				else return 0;

			} catch (Exception sqle) {
				System.out.println("SQL错误！");
				return 0;
			}finally {
				con.close();
			}

		} catch (Exception e) {
			System.out.println("找不到驱动类!");
			return 0;
		}
	}

}

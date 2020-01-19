package dao.pojo;

public class Car {
	private int carId;
	private String carName;
	private String carType;
	private float carPrice;
	private String carPhotoAdress;
	
	
	public Car() {

	}
	public Car(int carId, String carName, String carType, float carPrice, String carPhotoAdress) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carType = carType;
		this.carPrice = carPrice;
		this.carPhotoAdress = carPhotoAdress;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public float getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(float carPrice) {
		this.carPrice = carPrice;
	}
	public String getCarPhotoAdress() {
		return carPhotoAdress;
	}
	public void setCarPhotoAdress(String carPhotoAdress) {
		this.carPhotoAdress = carPhotoAdress;
	}
	@Override
	public String toString() {
		return carId+","+carName+","+carType+","+carPrice;
	}
	
	
}

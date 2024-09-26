package btvn.entity;

public class Car {
	public int speed;
	public double regularPrice;
	public String color;
	public double salePrice;
	
	public Car(int speed, double regularPrice, String color, double salePrice) {
		this.speed = speed;
		this.regularPrice = regularPrice;
		this.color = color;
		this.salePrice = salePrice;
	}
	public Car() {	
	}
	public double getsalePrice() {
		return getsalePrice();
	}
	public void setsalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getRegularPrice() {
		return regularPrice;
	}
	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	};
	
}

package btvn.entity;

public class Ford extends Car{
	private int year;
	private int manufacturerDiscount;
	
	public Ford(int speed, double regularPrice, String color, double salePrice, int year, int manufacturerDiscount) {
		super(speed, regularPrice, color, salePrice);
		this.year = year;
		this.manufacturerDiscount = manufacturerDiscount;
	}
	public Ford() {
		
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getManufacturerDiscount() {
		return manufacturerDiscount;
	}
	public void setManufacturerDiscount(int manufacturerDiscount) {
		this.manufacturerDiscount = manufacturerDiscount;
	}
	
	
	@Override
	public double getsalePrice() {
		this.salePrice = super.salePrice -this.manufacturerDiscount;
		return this.salePrice;
	}
	@Override
	public String toString() {
		return "Ford [year=" + year + ", manufacturerDiscount=" + manufacturerDiscount + ", speed=" + speed
				+ ", regularPrice=" + regularPrice + ", color=" + color + ", salePrice=" + salePrice
				+ ", getSalePrice()=" + getsalePrice() + "]";
	}
	
	
}

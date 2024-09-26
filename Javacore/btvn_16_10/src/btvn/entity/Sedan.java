package btvn.entity;

public class Sedan extends Car{
	private int length;

	public Sedan() {
		
	}

	public Sedan(int speed, double regularPrice, String color, double salePrice, int length) {
		super(speed, regularPrice, color, salePrice);
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public double getsalePrice() {
		if(this.length>20) {
			this.salePrice = this.regularPrice*5/100;
		}else
			this.salePrice = this.regularPrice*10/100;
		return this.salePrice;
	}
	
}

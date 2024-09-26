package btvn.entity;

public class Truck extends Car{
	private int weight;
	
	
	public Truck(int speed, double regularPrice, String color, double salePrice, int weight) {
		super(speed, regularPrice, color, salePrice);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	
	public Truck() {
		super();
	}
	@Override
	public double getsalePrice() {
		if(this.weight>2000) {
			this.salePrice = this.regularPrice*10/100;
		}else {
			this.salePrice = this.regularPrice*20/100;
		}
		return this.salePrice;
	}


	
}

package btvn.frontend;

import btvn.entity.Car;
import btvn.entity.Ford;
import btvn.entity.Sedan;
import btvn.entity.Truck;

public class MyOwnAutoShop {
	public static void main(String args[]) {
	Truck a = new Truck();
	a.setRegularPrice(3000000);
	a.setWeight(1000);
	System.out.print("Gia sale cua truck:" + a.getsalePrice());
	Car c = new Car();
	c.salePrice = 100000000;
	Ford b = new Ford();
	b.setManufacturerDiscount(500000);
	System.out.print("\ngia sale cua ford:" + b.getsalePrice());
	Sedan d = new Sedan();
	d.setLength(10);
	d.setRegularPrice(2890);
	System.out.print("\ngia sale cua sedan:"+ d.getsalePrice());
	}
}

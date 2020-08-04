package com.revature;

import com.revature.models.Car;
import com.revature.models.SportsCar;

public class Driver {
	
	public static void main(String[] args) {
		
//		Car c = new Car();
//		
//		System.out.println(c.doors);
//		System.out.println(c.model);
//		
		System.out.println("=============================================");
		
		
		Car c2 = new Car(5, 7, "model x", "black");
		
		System.out.println(c2.doors);
		System.out.println(c2.color);
		
		System.out.println("=============================================");
		
		SportsCar s = new SportsCar(); 
		
		s.drive();
		System.out.println(s.color);
		
		SportsCar s2 = new SportsCar(6, 9, "RX-8", "Hot Pink");
		
		
		System.out.println(s2.color);
		
	}

}

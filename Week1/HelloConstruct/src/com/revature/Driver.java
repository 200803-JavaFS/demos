package com.revature;

import com.revature.models.Car;
import com.revature.models.Mustang;
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
		
		System.out.println("=============================================");
		
		Mustang m = new Mustang(2, "gt", "yellow");
		
		//this shows overriding.
		s.drive();
		m.drive();
		
		//Static methods can be called directly from the class. 
		SportsCar.honk();
		Mustang.honk();
		
		System.out.println("=============================================");
		
		//Example of upcasting. 
		SportsCar sc = new Mustang(4, "gt", "Green"); 
		
		sc.drive();
		
		m.showOff();
		
		System.out.println("=============================================");
		//I can not do this because the method does not exist in the declared type: SportsCar
		//sc.showOff();
		

		//This is downcasting
		
		Mustang mu = (Mustang) sc;
		
		mu.showOff();
		
		// this downcast does the same thing it just does not assign it to a variable for later use. 
		((Mustang) sc).showOff();

		
		System.out.println("=============================================");
		
		//This will not work at runtime because sc is not actually a Mustang. It will however compile. 
//		sc = new SportsCar(4, 5, "test", "test");
//				
//		mu = (Mustang) sc;
		
		
	}

}

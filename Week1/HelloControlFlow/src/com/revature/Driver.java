package com.revature;

import com.revature.models.SportsCar;

public class Driver {
	
	static SportsCar myCar = new SportsCar(2, "black", "RX-8, R3", 3, true);
	
	public static void main(String[] args) {

		myCar.move(200);
		
		boolean con = true;
		
//		while(myCar.getHasTurbo() && con) {
//			System.out.println("In first while loop");
//			if (con) {
//				System.out.println("in if statement");
//				con = false;
//				continue;
//			}
//			System.out.println("I am at the end of my while loop");
//		}
		
		//The && means that on the second evaluation the getHasTurbo method is never run because it short curcits when con is false. 
		while(con && myCar.getHasTurbo()) {
			System.out.println("In first while loop");
			if (con) {
				System.out.println("in if statement");
				con = false;
				continue;
			}
			System.out.println("I am at the end of my while loop");
		}
		
		System.out.println("==============================================");
		
		do {
			System.out.println("I will do this once");
			myCar.hasTurbo = !myCar.hasTurbo;
		} while(myCar.getHasTurbo()); 
		
		System.out.println("==============================================");
		
		for (int i=1; i<=myCar.seats; ++i) {
			System.out.println("You have filled "+i+" seats in your car");
		}
		
		System.out.println("==============================================");
		
		//myCar.color = "Green"; 
		
		switch(myCar.color) {
			default: System.out.println("I don't know my car is just blah."); break;
			case "White": System.out.println("My car is the easiest to keep looking clean!"); break;
			case "black": System.out.println("My car is black as night. Like Batman!"); //break; This allows for a fall through
			case "Purple": System.out.println("My car is the best color!"); break;
		}

	}

}

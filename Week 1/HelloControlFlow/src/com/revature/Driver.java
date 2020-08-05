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
		
		while(con & myCar.getHasTurbo()) {
			System.out.println("In first while loop");
			if (con) {
				System.out.println("in if statement");
				con = false;
				continue;
			}
			System.out.println("I am at the end of my while loop");
		}

	}

}

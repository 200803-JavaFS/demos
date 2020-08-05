package com.revature.models;

public class Mustang extends SportsCar {
	
	public Mustang(int doors, String model, String color) {
		super(4, doors, model, color);
	}
	
	@Override
	public void drive() {
		System.out.println("Naaaay...");
	}
	

	public static void honk() {
		System.out.println("HONK HONK! MOVE OVER!");
	}
	
	public void showOff() {
		System.out.println("I'm doing dounuts");
	}

}

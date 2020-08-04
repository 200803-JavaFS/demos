package com.revature.models;


//The extends keyword is used to declare SportsCar as a subclass of Car
public class SportsCar extends Car{

	public SportsCar() {
		super(4, 2, "Jaguar", "red");
	}
	
	public SportsCar(int tires, int doors, String model, String color) {
		super(tires, doors, model, color);
	}
	
	public void drive() {
		System.out.println("Woooooh I can drive fast");
	}
	
}

package com.revature.models;

public class SportsCar extends Car{
	
	public boolean hasTurbo;

	public SportsCar() {
		super();
	}

	public SportsCar(int doors, String color, String model, int seats) {
		super(doors, color, model, seats);
	}


	public SportsCar(int doors, String color, String model, int seats, boolean hasTurbo) {
		super(doors, color, model, seats);
		this.hasTurbo=hasTurbo;
	}

	//notice that when overriding (or overloading) the variable name does not matter. It is only the variable 
	//type that is checked. 
	@Override
	public void move(int miles) {
		System.out.println("Zoom zoom!");
		if(miles <= 250) {
			System.out.println("You are good to continue.");
		} else {
			System.out.println("You need to stop for gas.");
		}
	}
	
	public boolean getHasTurbo() {
		System.out.println("In hasTurbo getter");
		return hasTurbo;
	}
	

}

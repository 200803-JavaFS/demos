package com.revature.models;

public class Car {
	
	public int doors;
	public String color;
	public String model;
	public int seats;
	
	public Car() {
		super();
	}

	public Car(int doors, String color, String model, int seats) {
		super();
		this.doors = doors;
		this.color = color;
		this.model = model;
		this.seats = seats;
	}
	
	
	public void move(int distance) {
		System.out.println("This "+model+" drives "+distance+" miles forward.");
	}
	
	public void reportSpeed(int mph) {
		System.out.println("You are going "+mph+" miles per hour");
	}
	

}

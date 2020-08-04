package com.revature.models;

public class Car {
	
	public int tires;
	public int doors;
	public String model;
	public String color; 
	
	//This is a constructor. It is public, has the name of the class and has NO return type. 
//	public Car() {
//		super();
//		System.out.println("In the no-args constructor");
//		tires = 4;
//		doors = 4;
//		model = "Lumina";
//		color = "white"; 
//	}
	
	public Car(int tires, int doors) {
		super();
		this.tires = tires;
		this.doors = doors;
		System.out.println("In the 2-args constructor");
	}
	
	//This is  constructor chaining. 
	public Car(int tires, int doors, String model, String color) {
		this(tires, doors);
		this.model = model;
		this.color = color;
		System.out.println("In the all-args constructor");
	}
	

}

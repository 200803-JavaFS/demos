package com.revature;

//This is a comment. It is writen for the purposes of other humans to read. The compiler will ignore everything on this lone following the double slash.

/*
 This is a multi-line comment
 everything written between the slash * will be commented out 
*/

//java provides this import by default. 
import java.lang.*;

public class Driver {
	
	//This is a class scoped variable. This variable is initialized with the value 5. 
	static int i = 5;
	
	//This is a class scored variable that has not been initalized. ints as primitives when declared as class or object 
	//scoped will have a default value of 0. Reference variables are default initialized to "null".  
	static int i2;
	
	//this is a reference variable in the class scope. 
	static Driver d;


	//This is an object scoped varaible. Every instance of the Driver class (each Driver object) will have its own copy of this
	//variable it can work with independently. 
	double d2 = 18.95;
	
	public static void main(String[] args) {
		
		System.out.println(i);
		System.out.println(i2);
		System.out.println(d);
		
		//System.out.prinln(d2); we can not do this because d2 is object specific and we are in a static(class) method. 
		
		d = new Driver();
		System.out.println(d.d2);
		
		//Because i2 is class scope I can access it in the static method and change it. 
		i2 = 45;
		System.out.println(i2);
		
		//because d is a Drive object it also has access to i2 and I can access it with the dot operator.
		d.i2= 9;
		
		System.out.println(i2);
		System.out.println(d.i2);
		
		//this is a method scope variable.
		int i3 = 56;
		
		System.out.println(i3);

		Driver.test();
		
		Driver drive2 = new Driver();
		
		drive2.test2();
		
		System.out.println(drive2.d2);
		
		drive2.d2= 123.25;
		
		System.out.println(drive2.d2);
		System.out.println(d.d2);
	}
	
	public static void test() {
		
		//I can not access the i3 variable because it is scoped to the main method. 
		//System.out.println(i3);
		System.out.println("I am in the test method");
		
		if(true) {
			int i4 =4;
			System.out.println(i4);
		}
		
		//System.out.println(i4);

	}
	
	public void test2() {
		System.out.println("I am in test2");
	}

}

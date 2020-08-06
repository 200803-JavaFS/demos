package com.revature;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println(scan);
		
		System.out.println("Hello, please tell me your name");
		String name = scan.nextLine();
		
		System.out.println("Hello "+name+", it is good to meet you.");
		
		System.out.println("What is your age?");
		int age = scan.nextInt();
		
		System.out.println("Wow you look younger than "+age+"!");
		
		//It is best close your input classes. However, System.in's Scanner can only be "opened" once so after it is closed
		//you love access to more input. Meaning you should only close the scanner when you are sure your program is done with it.
		
		scan.close();
	}

}

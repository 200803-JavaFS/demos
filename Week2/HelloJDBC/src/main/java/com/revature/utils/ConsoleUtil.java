package com.revature.utils;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.HomeDAO;
import com.revature.models.Avenger;
import com.revature.models.Home;
import com.revature.services.AvengerService;

public class ConsoleUtil {

	private static final Scanner scan = new Scanner(System.in);
	private AvengerService as = new AvengerService();
	private HomeDAO hd = new HomeDAO(); 
	
	public void beginApp() {
		System.out.println("Welcome to the newest Avengers Information Application built for and by Shield Agents like you! %n"
				+ "What would you like to do: \n"
				+ "See [all] Avengers? \n"
				+ "See [one] Avenger? \n"
				+ "[Add] new Avenger? \n"
				+ "[Update] existing Avenger \n"
				+ "[Delete] existing Avenger \n"
				+ "[Exit]");
		String answer = scan.nextLine(); 
		answerSwitch(answer);
	}

	private void answerSwitch(String answer) {
		answer = answer.toLowerCase();
		
		switch(answer){
			case "all": 
				getAllAvengers();
				break;
			case "exit":
				System.out.println("Thank you for using the application. Reminder, do not play Mario Cart with Bruce Banner. If you do, you will be liable for Hulk related damage.");
				break;
			case "one":
				getOneAvenger();
				break;
			case "add":
				addAvenger();
				break;
			default:
				System.out.println("You have entered an incorrect value. Please try again. ");
				beginApp();
				break;
		}
	}

	private void addAvenger() {
		System.out.println("What is the code name of the Avenger you would like to add?");
		String supName = scan.nextLine();
		System.out.println("What is the super power of the Avenger?");
		String power = scan.nextLine();
		System.out.println("What is the first name of the Avenger?");
		String fName= scan.nextLine();
		System.out.println("What is the last name of the Avenger?");
		String lName= scan.nextLine();
		System.out.println("What is the power level of the Avenger?");
		int pLevel = scan.nextInt();
		scan.nextLine();
		System.out.println("Does the Avenger have a home?");
		Home h = null;
		if(scan.nextLine().toLowerCase().equals("yes")) {
			h = findHome();
		}
		Avenger a = new Avenger(supName, power, fName, lName, pLevel, h);
		
		if(as.insertAvenger(a)) {
			System.out.println("Your avenger was added to the database");
			beginApp();
		} else {
			System.out.println("Something went wrong please try again");
			beginApp(); 
		}
		
			
	}

	private Home findHome() {
		System.out.println("Does your Avenger's home already exist in the Database? \n"
				+ "if so, enter the name of the home. \n"
				+ "if not enter 'no'");
		String res = scan.nextLine();
		Home h = null;
		if(res.toLowerCase().equals("no")) {
			h = buildHome();
		} else {
			h = hd.findByName(res);
		}
		return h;
	}

	private Home buildHome() {
		System.out.println("What is the name of the new home?");
		String name = scan.nextLine();
		System.out.println("What is the home's street address?");
		String addr = scan.nextLine();
		System.out.println("What is your home's city?");
		String city = scan.nextLine();
		System.out.println("What is the home's state?");
		String state = scan.nextLine();
		System.out.println("What is the home's zipcode?");
		String zip = scan.nextLine();
		Home h = new Home(name, addr, city, state, zip);
		return h;
	}

	private void getOneAvenger() {
		System.out.println("What is the id of the avenger you would like to look at?");
		int i = scan.nextInt();
		scan.nextLine();
		Avenger a = as.findById(i);
		System.out.println("Your avaenger is: "+a);
		beginApp();
	}
	
	private void getAllAvengers() {
		List<Avenger> list = as.findAll();
		
		System.out.println("Here are all the Avengers in the database:");
		for(Avenger a:list) {
			System.out.println(a);
		}
		beginApp();
	}
	
	

}

package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {
	
	//This is an example of a Singleton design pattern. Only one logger will ever exist. 
	private static final Logger log = LogManager.getLogger(Driver.class); 

	public static void main(String[] args) {
		log.info("The application has started");
		
		
		try {
			recur();
		} catch (Error e) {
			log.error("Oh no! We encountered an error!");
		}
		
		log.info("The application is ending") ;
		
		
	}
	
	public static void recur() {
		recur(); 
	}
	

}

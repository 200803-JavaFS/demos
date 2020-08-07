package com.revature;

import com.revature.problems.MyError;
import com.revature.problems.MyException;
import com.revature.problems.MyRuntimeException;

public class Driver {

	public static void main(String[] args) {

		System.out.println("The main method has started");

		// Errors are unchecked so this try/catch block is not required to compile, but
		// is required to the application to complete

		try {
			throwError();
			throwMyException();
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("I have caught an error. You should not do this!!!!!!");
		} catch (MyException e) {
			e.printStackTrace();
		}

//		I can not have a more specific catch block under a general block that would catch that error. 
//		catch(MyError e) {
//			
//		}
//		
		// This is a checked exception so it must be handled in order to compile
		try {
			throwMyException();
		} catch (Error e) {
			System.out.println("I have caught a new error");
		} catch (MyException e) {
			System.out.println("I have caught the exception");
		} catch (Exception e) {
			System.out.println("I caught a generic exception");
		} finally {
			System.out.println("I am in the finally block!");
		}

		try {
			throwMyRuntimeException();
		} catch (RuntimeException e) {
			System.out.println("I have caught the runtime exception.");
		}

		System.out.println("I am at the end of the program");

	}

	public static void throwError() throws MyError {
		System.out.println("I'm about to throw and error");
		throw new MyError();
	}

	public static void throwMyException() throws MyException {
		System.out.println("I am about to throw my exception");
		throw new MyException();
	}

	public static void throwMyRuntimeException() throws MyRuntimeException {
		System.out.println("I'm about the throw a runtime exception");
		throw new MyRuntimeException("You have encountered the Runtime exception");
	}

}

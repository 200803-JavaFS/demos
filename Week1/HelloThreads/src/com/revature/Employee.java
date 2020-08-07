package com.revature;

public class Employee extends Thread {

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " is working...");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				/*
				 * InterruptedException is thrown when the Employee's interrupt()
				 * method is called. We will break out if this occurs.
				 */
				e.printStackTrace();
				break;
			}
		}
	}
}


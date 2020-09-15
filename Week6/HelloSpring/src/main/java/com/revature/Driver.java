package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.config.Config;
import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {
		// Created an Application Context Container.
		//ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		
		
		// Asked the Container for a user object.
		User u = (User) ac.getBean("user");
	
		System.out.println(u);
		
		u.setId(1);
		u.setName("CaliforniaMatt");
		u.getAcc().setAmount(90000.56);
		
		System.out.println(u);
		
		User u2 = (User) ac.getBean("user");
		
		u2.setId(2);
		u2.setName("GattieTimE");
		u2.getAcc().setAmount(356.78);
		
		System.out.println(u2);
		System.out.println(u);
		
	}

}

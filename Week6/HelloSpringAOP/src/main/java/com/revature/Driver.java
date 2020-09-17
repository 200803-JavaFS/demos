package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Avenger;
import com.revature.repositories.AvengerDAO;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AvengerDAO dao = ac.getBean(AvengerDAO.class);
		
		Avenger a = dao.getById(1);
		
		Avenger a2 = ac.getBean(Avenger.class);
		a2.setFirstName("Wanda");
		a2.setLastName("Maximoff");
		a2.setSupID(8);
		a2.setPowerLevel(300);
		a2.setSupName("Scarlett Witch");
		a2.setSupPower("Magic Hands");
		
		System.out.println(dao.fight(a2, "an energy blast", 15.0));
		
		System.out.println(dao.fight(a, "Shield punch", 2.5));

	}

}

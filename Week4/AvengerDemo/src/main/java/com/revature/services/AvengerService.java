package com.revature.services;

import java.util.List;

import com.revature.daos.AvengerDAOv2;
import com.revature.daos.HomeDAOv2;
import com.revature.daos.IAvengerDAO;
import com.revature.daos.IHomeDAO;
import com.revature.models.Avenger;
import com.revature.models.AvengerDTO;
import com.revature.models.Home;

public class AvengerService {
	
	private static IAvengerDAO aDao = new AvengerDAOv2();
	private static IHomeDAO hDao = new HomeDAOv2();
	
	public List<Avenger> findAll() {
		return aDao.findAll();
	}
	
	public Avenger findById(int id) {
		return aDao.findById(id);
	}
	
	public boolean addAvenger(AvengerDTO ad) {
		Avenger a;
		if(ad.homeString.equals("")) {
			a = new Avenger(ad.supName, ad.supPower, ad.firstName, ad.lastName, ad.powerLevel, null);
		} else {
			Home h = hDao.findByName(ad.homeString);
			a = new Avenger(ad.supName, ad.supPower, ad.firstName, ad.lastName, ad.powerLevel, h);
		}
		return aDao.addAvenger(a);
	}

}

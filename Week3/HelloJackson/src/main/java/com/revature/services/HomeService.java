package com.revature.services;

import java.util.List;

import com.revature.daos.HomeDAO;
import com.revature.daos.IHomeDAO;
import com.revature.models.Home;

public class HomeService {
	
	private static IHomeDAO hDao = new HomeDAO();
	
	public List<Home> findAll() {
		return hDao.findAll();
	}
	
	public Home findByName(String name) {
		return hDao.findByName(name);
	}
	
	public boolean addHome(Home h) {
		return hDao.addHome(h);
	}

}

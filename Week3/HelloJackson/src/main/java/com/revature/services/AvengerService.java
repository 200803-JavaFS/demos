package com.revature.services;

import java.util.List;

import com.revature.daos.AvengerDAO;
import com.revature.daos.IAvengerDAO;
import com.revature.models.Avenger;

public class AvengerService {
	
	private static IAvengerDAO aDao = new AvengerDAO();
	
	public List<Avenger> findAll() {
		return aDao.findAll();
	}
	
	public Avenger findById(int id) {
		return aDao.findById(id);
	}
	
	public boolean addAvenger(Avenger a) {
		return aDao.addAvenger(a);
	}

}

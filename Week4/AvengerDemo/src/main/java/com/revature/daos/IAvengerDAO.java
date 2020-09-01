package com.revature.daos;

import java.util.List;

import com.revature.models.Avenger;

public interface IAvengerDAO {
	
	public List<Avenger> findAll();
	
	public Avenger findById(int id);
	
	public boolean addAvenger(Avenger a);
	
	public boolean updateAvenger(Avenger a); 
	
	public boolean deleteAvenger(int supId);

	public boolean addAvengerWithHome(Avenger a);

}

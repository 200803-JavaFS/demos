package com.revature.daos;

import java.util.List;

import com.revature.models.Home;

public interface IHomeDAO {
	
	public List<Home> findAll();
	public Home findByName(String name);
	public boolean addHome(Home h); 

}

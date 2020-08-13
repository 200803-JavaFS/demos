package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.AvengerDAO;
import com.revature.daos.HomeDAO;
import com.revature.daos.IAvengerDAO;
import com.revature.daos.IHomeDAO;
import com.revature.models.Avenger;
import com.revature.models.Home;

public class AvengerService {
	
	private static IAvengerDAO dao = new AvengerDAO();
	private static IHomeDAO hDao = new HomeDAO();
	private static final Logger log = LogManager.getLogger(AvengerService.class);
	
	public List<Avenger> findAll() {
		log.info("Retrieving all avengers");
		List<Avenger> list = dao.findAll();
		
		for(Avenger a: list) {
			if(a.getSupName().equals("Black Widow")) {
				a.setFirstName("null");
				a.setLastName("null");
				a.setHomeBase(null); 
			}
		}
		
		return list;
	}
	
	public Avenger findById(int id) {
		log.info("finding a Avenger with id "+id);
		return dao.findById(id);
	}
	
	public boolean updateAvenger(Avenger a) {
		log.info("Updating Avenger: "+a);
		if(dao.updateAvenger(a)) {
			return true;
		}
		return false;
	}
	
	public boolean insertAvenger (Avenger a) {
		
		if(a.getHomeBase()!=null){
			List<Home> list = hDao.findAll();
			boolean b = false;
			for(Home h: list) {
				if(h.equals(a.getHomeBase())) {
					b = true;
				}
			}
			if(b) {
				log.info("Inserting Avenger: "+a);
				if(dao.addAvenger(a)) {
					return true;
				}		
			} else {
				log.info("Inserting Avenger: "+a+" with a new home: "+a.getHomeBase());
				if(dao.addAvengerWithHome(a)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean removeAvenger(int id) {
		log.info("Deleting Avenger with id: "+id);
		if(dao.deleteAvenger(id)) {
			return true;
		}
		return false; 
	}

}

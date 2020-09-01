package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Home;
import com.revature.utils.HibernateUtil;

public class HomeDAOv2 implements IHomeDAO {

	@Override
	public List<Home> findAll() {
		Session ses = HibernateUtil.getSession();
		
		List<Home> list = ses.createQuery("FROM Home").list();
		
		Home h = list.get(0);
		
		return list;

	}

	@Override
	public Home findByName(String name) {
		Session ses = HibernateUtil.getSession();
		
		Home h = ses.get(Home.class, name);
		
		return h;
	}

	@Override
	public boolean addHome(Home h) {
		Session ses = HibernateUtil.getSession();
		
		try {
			ses.save(h);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}

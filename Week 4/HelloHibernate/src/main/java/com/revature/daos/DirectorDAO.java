package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Director;
import com.revature.utils.HibernateUtil;

public class DirectorDAO {
	
	public DirectorDAO() {
		super();
	}
	
	public void insert(Director direct) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(direct);
		
		tx.commit();
	}
	
	public void update(Director direct) {
		Session ses = HibernateUtil.getSession();
		ses.merge(direct);
	}
	
	public Director selectById(int id) {
		Session ses = HibernateUtil.getSession();
		
		Director direct = ses.get(Director.class, id);
		
		return direct;
	}
	
	public List<Director> findAll() {
		Session ses = HibernateUtil.getSession();
		
		List<Director> dirList = ses.createQuery("FROM Director").list();
		
		return dirList;
	}

}

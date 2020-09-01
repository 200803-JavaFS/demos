package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Avenger;
import com.revature.utils.HibernateUtil;

public class AvengerDAOv2 implements IAvengerDAO {

	@Override
	public List<Avenger> findAll() {
		Session ses = HibernateUtil.getSession();

		List<Avenger> list = ses.createQuery("FROM Avenger").list();

		return list;
	}

	@Override
	public Avenger findById(int id) {
		Session ses = HibernateUtil.getSession();

		Avenger a = ses.get(Avenger.class, id);
		return a;
	}

	@Override
	public boolean addAvenger(Avenger a) {
		Session ses = HibernateUtil.getSession();

		try {
			ses.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateAvenger(Avenger a) {
		Session ses = HibernateUtil.getSession();

		try {
			ses.merge(a);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAvenger(int supId) {
		Session ses = HibernateUtil.getSession();

		try {
			ses.createQuery("DELETE FROM Avenger WHERE supId =" + supId);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAvengerWithHome(Avenger a) {
		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		try {
			IHomeDAO hDao = new HomeDAOv2();
			hDao.addHome(a.getHomeBase());
			ses.saveOrUpdate(a);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

}

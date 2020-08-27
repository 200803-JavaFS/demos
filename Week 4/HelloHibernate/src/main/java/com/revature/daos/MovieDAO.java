package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Movie;
import com.revature.utils.HibernateUtil;

public class MovieDAO {

	public MovieDAO() {
		super();
	}
	
	public void insert(Movie movie) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(movie);
		
		tx.commit();
	}
	
	public void update(Movie movie) {
		Session ses = HibernateUtil.getSession();
		ses.merge(movie);
	}
	
	public Movie selectById(int id) {
		Session ses = HibernateUtil.getSession();
		
		Movie movie = ses.get(Movie.class, id);
		
		return movie;
	}
	
	public List<Movie> findAll() {
		Session ses = HibernateUtil.getSession();
		
		List<Movie> dirList = ses.createQuery("FROM Movie").list();
		
		return dirList;
	}
}

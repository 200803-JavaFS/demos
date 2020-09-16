package com.revature.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository
@Transactional
public class UserDAO implements IUserDAO {
	
	private SessionFactory sf;
	
	@Autowired
	public UserDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	
	public List<User> findAll() {
		Session s = sf.getCurrentSession();
		CriteriaQuery<User> cq = s.getCriteriaBuilder().createQuery(User.class);
		cq.from(User.class);
		return s.createQuery(cq).getResultList();
	}

	public User findById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(User.class, id);
	}

	public void save(User u) {
		Session s = sf.getCurrentSession();
		s.save(u);
	}

	public void update(User u) {
		Session s = sf.getCurrentSession();
		s.update(u);
	}

}

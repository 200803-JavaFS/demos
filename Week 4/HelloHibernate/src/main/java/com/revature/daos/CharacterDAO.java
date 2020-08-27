package com.revature.daos;

import java.util.List;

import com.revature.models.Character;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.utils.HibernateUtil;

public class CharacterDAO {
	
	public CharacterDAO() {
		super();
	}
	
	public void insert(Character chara) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(chara);
		
		tx.commit();
	}
	
	public void update(Character chara) {
		Session ses = HibernateUtil.getSession();
		ses.merge(chara);
	}
	
	public Character selectById(int id) {
		Session ses = HibernateUtil.getSession();
		
		Character chara = ses.get(Character.class, id);
		
		return chara;
	}
	
	public Character selectByName(String name) {
		Session ses = HibernateUtil.getSession();
		
		List<Character> charList = ses.createQuery("FROM Character WHERE name ="+name, Character.class).list();
		
		Character chara = charList.get(0);
		
		return chara;
	}
	
	
	public List<Character> selectAll() {
		Session ses = HibernateUtil.getSession();
		
		//List<Character> charList = ses.createCriteria(Character.class).list();
		
		CriteriaBuilder build = ses.getCriteriaBuilder();
		
		CriteriaQuery<Character> query = build.createQuery(Character.class);
		
		List<Character> charList = ses.createQuery(query).list();
		
		return charList;
	}
	
	

}

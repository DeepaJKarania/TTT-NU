package com.shoes.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoes.model.UserCredential;
import com.shoes.model.UserDetail;

@Repository
public class UserDetailDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void insert(UserDetail userDetail) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		session.save(userDetail);
//		
//		session.flush();
		tx.commit();
		session.close();
	}

	public void insertcredent(UserCredential userCredential) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		session.save(userCredential);
//		
//		session.flush();
		tx.commit();
		session.close();
	}
}
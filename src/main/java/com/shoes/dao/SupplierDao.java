package com.shoes.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ietf.jgss.GSSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.shoes.model.Category;
import com.shoes.model.Product;
import com.shoes.model.Supplier;

@Repository
public class SupplierDao {

	@Autowired
	SessionFactory sessionFactory;

	// @Transactional
	public void addSupplier(Supplier sup) {
		Session ses = sessionFactory.openSession();
		ses.beginTransaction();
		ses.save(sup);
		System.out.println("saved supplier data");
		ses.getTransaction().commit();
		ses.close();
	}

	public String listSupplier() 
	{
		System.out.println("inside listsupplier");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("inside  listsupplier after transaction");		
		List<Supplier> supList = session.createQuery("from Supplier").list();
		System.out.println("inside  listsupplier after calling list method");		
		
		Gson jsonObj = new Gson();
	
		System.out.println("gson creation done");
		String data = jsonObj.toJson(supList);
		System.out.println(data);
		session.getTransaction().commit();
		session.close();
		return data;
	}

	public void removeSup(int id) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		Supplier p = (Supplier) session.get(Supplier.class, id);
		session.delete(p);
		session.getTransaction().commit();
		session.close();

		System.out.println("Supplier deleted successfully,=" + p);
	}

	public int updateRow(Supplier supplier) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(supplier);
		session.getTransaction().commit();
		Serializable id = session.getIdentifier(supplier);
		session.close();
		return (Integer) id;
	}

	// -----------------------------display data by ID

	public Supplier getRowById(int id) {
		Session session = sessionFactory.openSession();
		Supplier supplier = (Supplier) session.load(Supplier.class, id);
		return supplier;
	}

}

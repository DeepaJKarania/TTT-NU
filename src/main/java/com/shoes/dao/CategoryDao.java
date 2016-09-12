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

@Repository
public class CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	// @Transactional
	public void addCategory(Category cat) {
		Session ses = sessionFactory.openSession();
		ses.beginTransaction();
		ses.save(cat);
		System.out.println("saved category data");
		ses.getTransaction().commit();
		ses.close();
	}

	public String listCategory() 
	{
		System.out.println("inside listcategory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("inside  listcategory after transaction");		
		List<Category> catList = session.createQuery("from Category").list();
		System.out.println("inside  listcategory after calling list method");		
		
		Gson jsonObj = new Gson();
	
		System.out.println("gson creation done");
		String data = jsonObj.toJson(catList);
		System.out.println(data);
		session.getTransaction().commit();
		session.close();
		return data;
	}

	public void removeCat(int id) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		Category p = (Category) session.get(Category.class, id);
		session.delete(p);
		session.getTransaction().commit();
		session.close();

		System.out.println("Category deleted successfully,=" + p);
	}

	public int updateRow(Category category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(category);
		session.getTransaction().commit();
		Serializable id = session.getIdentifier(category);
		session.close();
		return (Integer) id;
	}

	// -----------------------------display data by ID

	public Category getRowById(int id) {
		Session session = sessionFactory.openSession();
		Category category = (Category) session.load(Category.class, id);
		return category;
	}

}

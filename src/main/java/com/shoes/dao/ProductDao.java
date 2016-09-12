package com.shoes.dao;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.shoes.model.Product;

@Repository
public class ProductDao {
	
	@Autowired
	SessionFactory  sessionFactory;
	
	
	@Transactional
	public void addProduct(Product pro) {
		Session ses=sessionFactory.openSession();
		ses.beginTransaction();
		ses.save(pro);
		System.out.println("Saveddddd data");
		ses.getTransaction().commit();
		//SessionsessionFactory.getCurrentSession().save(pro);
		
		
	}

	public String getAllProduct() 
	{
		
		Session s=sessionFactory.openSession();
		List spList=s.createQuery("from Product").list();
		Gson g=new Gson();
		String data=g.toJson(spList);
				
		return data;
	}
	
	
	public void updateProduct(Product pObj,int pId)
	{
		Session ses=sessionFactory.openSession();
		ses.beginTransaction();
		
		Product prObj=(Product)ses.get(Product.class,pId);
		prObj.setItemName(prObj.getItemName());
		prObj.setDescription(prObj.getDescription());
		prObj.setQty(prObj.getQty());
		prObj.setCategoryId(prObj.getCategoryId());
		prObj.setSupplierId(prObj.getSupplierId());
		
		ses.update(prObj);
		
		ses.getTransaction().commit();
		
	}
	
	public Product getRowById(int id)
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.load(Product.class,id);
		return product;
	}
	

	public void removePro(int pId) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		Product prObj1 = (Product) session.get(Product.class, pId);
		session.delete(prObj1);
		session.getTransaction().commit();
		session.close();

		System.out.println("Prod deleted successfully"+pId);
		
	}
	
	public int updateRow(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
		Serializable id = session.getIdentifier(product);
		session.close();
		return (Integer) id;
	}

	

}

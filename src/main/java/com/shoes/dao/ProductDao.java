package com.shoes.dao;
import com.google.gson.Gson;
import com.shoes.model.Product;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

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

	public String getAllProduct() {
		
		
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
	

	public void deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		
	}
	

}

package com.shoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shoes.dao.*;
import com.shoes.model.Product;
import com.shoes.model.Supplier;

@Controller

public class ProductController
{
	@Autowired
	ProductDao proDao;
	
	@Autowired
	CategoryDao catDao;
	
	@Autowired
	SupplierDao supDao;
	
	@RequestMapping(value="/Product",method=RequestMethod.GET)
	public ModelAndView displayProduct()
	{
		System.out.println("Inside GET");
		String data=proDao.getAllProduct();
		ModelAndView m=new ModelAndView("AddProduct","product",new Product());
		m.addObject("prodList",data);
		System.out.println(data);
		
		String supData=supDao.listSupplier();
		System.out.println(supData);
		
		String catData=catDao.listCategory();
		System.out.println(catData);
		
		m.addObject("supList", supData);
		m.addObject("catList",catData);
		m.addObject("checked",true);
		
		return m;
		
	}
	
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public ModelAndView addProduct(Product product)
	{
		System.out.println("inside post");
		proDao.addProduct(product);
		ModelAndView m=new ModelAndView("AddProduct","product",new Product());
		String data=proDao.getAllProduct();
		
		System.out.println(data);
		
		m.addObject("checked", true);
		m.addObject("proList",data);
		
		return m;
	}
	
	
	//-----update link-------
	
	@RequestMapping(value="/editProduct",method=RequestMethod.GET)
	public ModelAndView updateSupplier(@RequestParam("pId")int sp)
	{
		System.out.println("Inside GET");
		Product product=proDao.getRowById(sp);
		ModelAndView m=new ModelAndView("AddProduct","product",new Product());
		m.addObject("proObject",product);
		m.addObject("checked",false);
		System.out.println(sp+"inside DispUpdateProduct");
		
		return m;		
	}
	
	//------Update button------
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView updateProduct(Product pObj)
	{
		int id=pObj.getItemID();
		System.out.println(id);
		proDao.updateProduct(pObj,id);
		ModelAndView m=new ModelAndView("AddSupplier","supplier",new Supplier());
		String data=proDao.getAllProduct();
						
		m.addObject("proList",data);
		m.addObject("checked", false);
		
		return m;	
	}
	
	
}
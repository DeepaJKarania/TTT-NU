package com.shoes.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		//System.out.println("inside post");
		proDao.addProduct(product);
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
	
	//---this method for taking data on the click of edit and retrieve data on the behalf of that id --------------------
	
	@RequestMapping("UpdateProduct")
	public ModelAndView updateUser(@ModelAttribute Product proObject) {
		System.out.println("Inside update ");
		proDao.updateRow(proObject);
		String data = proDao.getAllProduct();
		ModelAndView m = new ModelAndView("AddProduct", "product", new Product());
		m.addObject("prodList", data);

		String supData=supDao.listSupplier();
		System.out.println(supData);
		
		String catData=catDao.listCategory();
		System.out.println(catData);
		
		m.addObject("supList", supData);
		m.addObject("catList",catData);
		m.addObject("checked",true);
		
		return m;
	}

	//---this method for taking data on the click of edit and retrieve data on the behalf of that id --------------------
	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView dispUpdateProduct(@RequestParam("pId") int pro) {
		System.out.print("Iside GET");
		Product proObject = proDao.getRowById(pro); // retrieve data
		ModelAndView m = new ModelAndView("UpdateProduct", "product",proObject);
		m.addObject("proObject", proObject);
		System.out.println(pro + "inside dispUpdateProduct ");

		String supData=supDao.listSupplier();
		System.out.println(supData);
		
		String catData=catDao.listCategory();
		System.out.println(catData);
		
		m.addObject("supList", supData);
		m.addObject("catList",catData);
		m.addObject("checked",true);
		
		return m;
	}

	
	//---------Deleting data--------
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView delProduct(@RequestParam("pId") int pro) {
		
		System.out.println(pro);
		proDao.removePro(pro);
		String data = proDao.getAllProduct();
		ModelAndView m = new ModelAndView("AddProduct", "product", new Product());
		m.addObject("prodList", data);
		
		
		String supData=supDao.listSupplier();
		System.out.println(supData);
		
		String catData=catDao.listCategory();
		System.out.println(catData);
		
		m.addObject("supList", supData);
		m.addObject("catList",catData);
		m.addObject("checked",true);
		
		
		return m;

	}

}
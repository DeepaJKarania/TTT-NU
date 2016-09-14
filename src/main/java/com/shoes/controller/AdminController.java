package com.shoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/AdminHome")
	public String showAdminHome() 
	{
		//System.out.println("at Log");
	return "AdminHome";
	}
	
	@RequestMapping("/AboutUs")
	public String showAboutUs() 
	{
		return "AboutUs";
	}

	
//	@RequestMapping("/AddProduct")
//	public String addProducts() 
//	{
//		//System.out.println("at Loggggggggggg");
//	return "AddProduct";
//	}
}

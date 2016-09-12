package com.shoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoes.model.Login;
import com.shoes.model.User;

@Controller
public class LoginController {
	
	LoginController()
	{
		//System.out.println("log consssssss");
	}
	@RequestMapping("/AboutUs")
	public String showAboutUs() 
	{
		//System.out.println("at Loggggggggggg");
	return "AboutUs";
	}
//	@RequestMapping("/ContactUs")
//	public String showContactUs() 
//	{
//	return "Contact";
//	}
//	
//	@RequestMapping("/Login")
//	public String showLogin() 
//	{
//	return "Login";
//	}
	//-----------------------------------------
//	@RequestMapping("/Product")
//	public String showProduct() 
//	{
//	return "Product";
//	}

//	@RequestMapping("/Register")
//	public String showRegister() 
//	{
//	
//	return "Register";
//	}
//	
	
	@RequestMapping(value="/Login", method = RequestMethod.GET) 
	public String displayLogin(@ModelAttribute("login")Login login) { 
	    return "Login"; 
	}

	
	
	@RequestMapping( value="/Login" ,method = RequestMethod.POST)
	   public String addUser(@ModelAttribute("SpringWeb")Login login, 
	   ModelMap model) {
			model.addAttribute("first_name",login.getEmail());
			
			model.addAttribute("last_name",login.getPassword());
			
	   return "Thanks";
	   }
	
	@RequestMapping("/Home")
	public String showHome() 
	{
		System.out.println("at Loggggggggggg");
	return "Home";
	}
	

}

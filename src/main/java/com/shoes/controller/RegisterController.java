package com.shoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoes.model.Login;
import com.shoes.model.UserDetail;

@Controller

public class RegisterController {

//
//	RegisterController()
//	{
//		
//	}
////	
	@RequestMapping(value="/Login", method = RequestMethod.GET) 
	public String displayLogin(@ModelAttribute("login")Login login) { 
	    return "Login"; 
	}
//
////	
//	
//	
//	
//	
//	@RequestMapping( value="/UserDetail" ,method = RequestMethod.POST)
//	   public String addUser(@ModelAttribute("SpringWeb")UserDetail userDetail, 
//	   ModelMap model) {
//			
//		model.addAttribute("User_ID",userDetail.getUserId());
//		
//		model.addAttribute("Customer_Name",userDetail.getCustName());
//		
//		model.addAttribute("Phone_No",userDetail.getPhone());
//		
//			model.addAttribute("Address",userDetail.getAddress());
//			
//			model.addAttribute("Password",userDetail.getPass());
//			
//	   return "Home";
//	   }
//	
//	@RequestMapping("/Login")
//	public String showLogin() 
//	{
//		System.out.println("done");
//	return "Login";
//	}
//	
//





}

package com.shoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoes.model.UserDetail;

@Controller

public class RegisterController {

//	@RequestMapping(method = RequestMethod.GET)  error
//	   public ModelAndView UserDetail() {
//	      return new ModelAndView("UserDetail", "command", new UserDetail());
//	   }
//	   

	@RequestMapping(value = "/Register", method = RequestMethod.GET)  
	public String displayRegister(@ModelAttribute("register")UserDetail UserDetail) { 
    return "Register"; 
	}
	
	
		@RequestMapping( value="/Register" ,method = RequestMethod.POST)
	   public String addUserDetail(@ModelAttribute("SpringWeb")UserDetail userDetail, 
	   ModelMap model) {
			model.addAttribute("first_name",userDetail.getFirst_name());
			
			model.addAttribute("last_name",userDetail.getLast_name());
			
			model.addAttribute("password",userDetail.getPassword());
			
			model.addAttribute("password_confirmation",userDetail.getPassword_confirmation());
			
			model.addAttribute("phone",userDetail.getPhone());
			
			model.addAttribute("address",userDetail.getAddress());
			
	      return "Thanks";
	   }
		






}

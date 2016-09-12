package com.shoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shoes.model.User;

@Controller

public class RegisterController {

//	@RequestMapping(method = RequestMethod.GET)  error
//	   public ModelAndView user() {
//	      return new ModelAndView("user", "command", new User());
//	   }
//	   

	@RequestMapping(value = "/Register", method = RequestMethod.GET)  
	public String displayRegister(@ModelAttribute("register")User user) { 
    return "Register"; 
	}
	
	
		@RequestMapping( value="/Register" ,method = RequestMethod.POST)
	   public String addUser(@ModelAttribute("SpringWeb")User user, 
	   ModelMap model) {
			model.addAttribute("first_name",user.getFirst_name());
			
			model.addAttribute("last_name",user.getLast_name());
			
			model.addAttribute("password",user.getPassword());
			
			model.addAttribute("password_confirmation",user.getPassword_confirmation());
			
			model.addAttribute("phon",user.getPhon());
			
			model.addAttribute("address",user.getAddress());
			
	      return "Thanks";
	   }
		






}

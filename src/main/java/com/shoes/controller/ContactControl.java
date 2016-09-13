package com.shoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoes.model.Contact;
import com.shoes.model.UserDetail;

@Controller
public class ContactControl {

	@RequestMapping(value = "/Contact", method = RequestMethod.GET)  
	public String displayRegister(@ModelAttribute("Contact")Contact contact) { 
    return "Contact"; 
	}
	
	
		@RequestMapping( value="/Contact" ,method = RequestMethod.POST)
	   public String addUser(@ModelAttribute("SpringWeb")Contact contact, 
	   ModelMap model) {
			model.addAttribute("name",contact.getName());
			
			model.addAttribute("email",contact.getEmail());
			
			model.addAttribute("message",contact.getMessage());
			
			
	      return "Thanks";
	   }
	
}

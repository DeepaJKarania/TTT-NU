package com.shoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shoes.dao.UserDetailDao;
import com.shoes.model.UserCredential;
import com.shoes.model.UserDetail;

@Controller
public class Perform_LoginController {

	@Autowired
	UserDetailDao logDao;
	
	
	@RequestMapping(value="/UserDetail",method=RequestMethod.GET)
	public ModelAndView showUserDetails()
	{	
		ModelAndView m = new ModelAndView("UserDetail", "userDetail", new UserDetail());
		return m;	
	}
	
	@RequestMapping(value="/UserDetail",method=RequestMethod.POST)
	public void login(UserDetail userDetail)
	{
		UserCredential userCredential=new UserCredential();
		userCredential.setUserId(userCredential.getUserId());
		userCredential.setPass(userDetail.getPass());
		userCredential.setCustName(userDetail.getCustName());
		userCredential.setEnabled(true);
		userCredential.setRole("USER_ROLE");
		
		logDao.insert(userDetail);
		logDao.insertcredent(userCredential);
						
	}
	}
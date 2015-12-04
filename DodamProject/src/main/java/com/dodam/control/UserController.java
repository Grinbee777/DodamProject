package com.dodam.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.dodam.service.UserService;
import com.dodam.service.domain.User;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userservice;
	
	public UserController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	@RequestMapping(value="/json/insertUser")
    	public void insertJsonUser(@RequestBody User user,Model model)throws Exception{
		
		System.out.println("::insertJsonUser::");
		userservice.insertUser(user);
	}
		
	@RequestMapping(value="/json/getUser")
	public void getJsonUser(@RequestBody User user,Model model)throws Exception{
		System.out.println("::getJsonUser::");
		User getUser=userservice.getUser(user.getuNo());
		model.addAttribute("user",getUser);		
	}	
	
	@RequestMapping( value="/json/updateUser")
	public void updateJsonUser( @RequestBody User user , Model model) throws Exception{

		System.out.println("::updateJsonUser::");
		//Business Logic
		userservice.updateUser(user);
		
		model.addAttribute("user",user);
	}
	
	
	@RequestMapping( value="/json/deleteUser")
	public void deleteJsonUser(@RequestBody User user,Model model)throws Exception{
		
		System.out.println("::deleteJsonUser::");
		userservice.deleteUser(user.getuNo());
		//model.addAttribute("user",user);		
	}

}

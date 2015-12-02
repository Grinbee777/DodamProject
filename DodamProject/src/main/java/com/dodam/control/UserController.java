package com.dodam.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dodam.service.UserService;
import com.dodam.service.domain.User;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userservice;
	
	
	/*public UserController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	@RequestMapping(value="insertUser", method=RequestMethod.POST)
    	public int insertUser(@ModelAttribute("user") User user)throws Exception{
		
		System.out.println("/user/insertUser : POST");
		userservice.insertUser(user);
		
		return;
		
	}*/
	
	@RequestMapping(value="checkDuplication",method=RequestMethod.POST)
	public String checkDuplication(@RequestParam("mail")String mail, Model model )throws Exception{
		System.out.println("/user/checkDuplication : POST");
		boolean result=userservice.checkDuplication(mail);
		
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("mail",mail);
		
		
		return mail ;
		
	}
	
/*	@RequestMapping(value="getUser",method=RequestMethod.GET)
	public String getUser(@RequestParam("uNo")int uNo,Model model)throws Exception{
		System.out.println("/user/getUser : GET");
		User user = userservice.getUser(uNo);
		model.addAttribute("user",user);
		return ;
	}*/
	
	
		
	
	
	

}

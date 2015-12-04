package com.dodam.control;

import java.util.List;

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
		System.out.println(":: requestJSON :"+user);
		System.out.println("::result :"+userservice.insertUser(user));
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
	
	@RequestMapping( value="/json/checkDuplication")
	public void checkJsonDuplication(@RequestBody User user, Model model) throws Exception{
		System.out.println("::checkJsonDuplication");
		System.out.println("::requestData :"+user);
		
		List<User> list =userservice.getUserList();
		if (user.getMail() != null) {
			System.out.println("::CheckEmail");
			String requestMail = user.getMail();	
			boolean check = true;
			
			for(User temp : list){
				if (temp.getMail().equals(requestMail)) {
					System.out.println("Duplication email!!!");	
					check = false;					
				}				
			}//end of for			
			model.addAttribute("result", check);
			
		}else if(user.getNickname() !=null){
			System.out.println("::CheckNickname");
			String requestNickname = user.getNickname();
			boolean check = true;
			
			while (list.size()!=0) {		
				System.out.println("while of CheckNickname");
				if ( list.get(list.size()-1).getNickname().equals(requestNickname) ) {
					check = false;
					System.out.println("Duplication nickname!!!!");
					break;
				}	
				list.remove(list.size()-1);
			}// end of while
			model.addAttribute("result", check);
		}//end of outter if
		
		//end of outter if	
		
		
	}//end of checkJsonDuplication
}

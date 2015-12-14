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
	
	@RequestMapping(value="/json/loginUser")
	public void loginJsonUser(@RequestBody User user, Model model) throws Exception{
		System.out.println("::loginJsonUser::");
		System.out.println("::requestJSON :"+user);
				
		int result = userservice.loginUser(user);		
		
		System.out.println("::result(0:로그인 정보틀림, 1:이메일인증안됨, 2:로그인 완료) :"+result);
		model.addAttribute("result", result);
	}
	
	@RequestMapping(value="/json/insertUser")
    	public void insertJsonUser(@RequestBody User user,Model model)throws Exception{
		
		
		System.out.println("::insertJsonUser::");		
		// SNS 로그인 회원은 SocialNo,   Facebook 에서 발행한 ID 넘버를 DB 이메일 컴럼에 인서트한다.
		user.setMail(user.getSocialNo());
		System.out.println(":: requestJSON :"+user);
		int result = userservice.insertUser(user);
		System.out.println("::result :"+result);
		model.addAttribute("result", result);
		if ( result == 1 && user.getSocialNo() != null) {
			System.out.println(":: Cookie for Social Login User :: user.getSocialNo() :"+user.getSocialNo());
			model.addAttribute("user", user);
		}		
	}
		
	@RequestMapping(value="/json/getUser")
	public void getJsonUser(@RequestBody User user,Model model)throws Exception{
		System.out.println("::getJsonUser::");
		User getUser=userservice.getUser(user.getuNo());
		model.addAttribute("user",getUser);		
	}
	
	@RequestMapping(value="/json/getMailUser")
	public void getJsonMailUser(@RequestBody User user,Model model)throws Exception{
		
		System.out.println("::getJsonMailUser::");
		User getUser=userservice.getMailUser(user.getMail());
		model.addAttribute("user",getUser);		
	}
	
	@RequestMapping(value="/json/getNickUser")
	public void getJsonNickUser(@RequestBody User user,Model model)throws Exception{
		
		System.out.println("::getJsonNickUser::");
		User getUser=userservice.getNickUser(user.getNickname());
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
					break;
				}	
				list.remove(list.size()-1);
			}// end of while
			model.addAttribute("result", check);
		}//end of outter if
		
		
	}//end of checkJsonDuplication
}

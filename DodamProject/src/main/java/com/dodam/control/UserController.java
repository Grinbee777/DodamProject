package com.dodam.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
	private SqlSession sqlSession;
	
	
	public UserController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	@RequestMapping(value="/json/addUser")
    	public void insertJsonUser(@RequestBody User user,Model model)throws Exception{
		
		System.out.println("insertUser 들어오나요?? ");
		userservice.insertUser(user);
		
		model.addAttribute("user",user);
		
	}
	
	@RequestMapping(value="/json/checkDuplication") 
	public void checkDuplication(@RequestBody User user, Model model )throws Exception{
		System.out.println("checkDuplication 들어오나여?");
		/*boolean result=userservice.checkDuplication(mail);
		
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("mail",mail);*/
		
	
		
	}
	
	@RequestMapping(value="/jsom/getUser")
	public void getJsonUser(@RequestBody User user,Model model)throws Exception{
		System.out.println("getUser 들어오나요??");
		User getUser=userservice.getUser(user.getuNo());
		model.addAttribute("user",getUser);
		
	}
	
	@RequestMapping(value="getUserList")
	public List<User>getUserList()throws Exception{	
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("getUserList 들어오나요??");
		return sqlSession.selectList(null, map);
		
		
	}
	
	@RequestMapping( value="/json/updateUser")
	public void updateJsonUser( @RequestBody User user , Model model , HttpSession session) throws Exception{

		System.out.println("updateUser 들어오낭??? ");
		//Business Logic
		userservice.updateUser(user);
		
		model.addAttribute("user",user);
	}
	
	
	@RequestMapping( value="/json/deleteUser")
	public void deleteUser(@RequestBody User user,Model model)throws Exception{
		
		System.out.println("delete 되나용??");
		userservice.deleteUser(user.getuNo());
		model.addAttribute("user",user);
		
	}
	

	
	
	
	
	
	
		
	
	
	

}

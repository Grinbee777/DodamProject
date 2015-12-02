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
		System.out.println(":::::"+getClass().getName()+" ��!");
	}
	
	@RequestMapping(value="insertUser", method=RequestMethod.POST)
    	public int insertUser(@ModelAttribute("user") User user)throws Exception{
		
		System.out.println("insertUser ����?? ");
		userservice.insertUser(user);
		
		return 0;
		
	}
	
	@RequestMapping(value="checkDuplication",method=RequestMethod.POST)
	public String checkDuplication(@RequestParam("mail")String mail, Model model )throws Exception{
		System.out.println("checkDuplication 들어오나여?");
		boolean result=userservice.checkDuplication(mail);
		
		model.addAttribute("result", new Boolean(result));
		model.addAttribute("mail",mail);
		
		
		return mail ;
		
	}
	
	@RequestMapping(value="getUser",method=RequestMethod.GET)
	public String getUser(@RequestParam("uNo")int uNo,Model model)throws Exception{
		System.out.println("getUser 들어오나요??");
		User user = userservice.getUser(uNo);
		model.addAttribute("user",user);
		return null ;
	}
	
	@RequestMapping(value="getUserList")
	public List<User>getUserList()throws Exception{	
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("getUserList 들어오나요??");
		return sqlSession.selectList(null, map);
		
		
	}
	
	@RequestMapping( value="updateUser", method=RequestMethod.POST )
	public int updateUser( @ModelAttribute("user") User user , Model model , HttpSession session) throws Exception{

		System.out.println("updateUser 들어오낭??? ");
		//Business Logic
		userservice.updateUser(user);
		
		int sessionId=((User)session.getAttribute("user")).getuNo();
		
		
		return sessionId ;
	}
	
	
	
	
	
	
	
	
	
		
	
	
	

}

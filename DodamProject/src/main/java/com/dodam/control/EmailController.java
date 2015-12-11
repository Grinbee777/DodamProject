package com.dodam.control;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dodam.dao.UserDao;
import com.dodam.service.EmailService;
import com.dodam.service.UserService;
import com.dodam.service.domain.User;

@Controller
@RequestMapping("/email/*")
public class EmailController {

	@Autowired
	@Qualifier("emailServiceImpl")
	private EmailService emailService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	public EmailController() {
	}
	
	@RequestMapping(value="/json/insertEmail")
	public void addJsonEmail(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		System.out.println("::addJsonEmail for authentication Email");
		//emailService.insertEmail(email)
		
		String mailAddress=request.getParameter("mail");
		String code=request.getParameter("code");
		int uNo=Integer.parseInt(request.getParameter("uNo"));
		
		User dbUser=userService.getUser(uNo);		
		
		System.out.println(dbUser.getMail()+"?"+mailAddress+"?"+dbUser.getAuthnum()+" "+code);
		
		if(dbUser.getMail().equals(mailAddress.trim()) && dbUser.getAuthnum().equals(code.trim())) {
			System.out.println("email and authnum matching success");
			int result=userService.uCodeUpdate(uNo);
			System.out.println(result);
		}
		
		request.getRequestDispatcher("/emali/welcome.html").forward(request, response);
	}
}
		

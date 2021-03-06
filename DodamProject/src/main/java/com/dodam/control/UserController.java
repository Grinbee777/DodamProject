package com.dodam.control;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dodam.service.UserService;
import com.dodam.service.domain.User;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@Autowired ServletContext servletCtx;	
	
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
		System.out.println("::request User :"+user);
		int result = 1;
		if (user.getSocialNo() != null) {
			
			System.out.println("::facebook Login 회원:: 최초 로그인 or 이미 가입된 회원 인지 판단 로직::");
			user.setMail(user.getSocialNo());
			User dbUser = userservice.getMailUser(user.getMail());
			
			if (dbUser != null) {
				System.out.println("::::이미 가입된 Facebook 회원::");
				model.addAttribute("user", dbUser);
				model.addAttribute("result", result);
			}else{
					System.out.println("::::최초  Facebook 로그인 회원::");
					result = userservice.insertUser(user);
					model.addAttribute("result", result);
					if (result == 1) {
						model.addAttribute("user", user);
					}
			}			
		}else{
			System.out.println("::::email 회원 가입::");
			result = userservice.insertUser(user);
			model.addAttribute("result", result);
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

		User beforeUser=userservice.getUser(user.getuNo());
		
		System.out.println(user.getuPic());
		System.out.println(beforeUser.getuPic());
		
		if(user.getuPic()=="undefined" || user.getuPic()=="" || user.getuPic()==null) {
			System.out.println("여기는 들어오나??");
			user.setuPic(beforeUser.getuPic());
		}
		
		System.out.println("::updateJsonUser::");
		System.out.println(user);
		if(user.getuPic()==null || user.getuPic()=="") {
			user.setuPic("default.jpg");
		}
		//Business Logic
		int result1=userservice.updateUser(user);
		
		if(result1==1){
			model.addAttribute("result", true);
		}
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
	
	  @RequestMapping(value="/json/uploadImg", method=RequestMethod.POST)
	  public void upload(MultipartHttpServletRequest request) throws Exception{
	      
		 System.out.println("uploadImg 들어옴");
		      
	      MultipartFile mpf = null;
	      
	      Iterator<String> itr = request.getFileNames(); 
	      
	      String filePath=servletCtx.getRealPath("/dodam_upload")+"/";
	      
	      while(itr.hasNext()){
	         mpf = request.getFile(itr.next());         
	            
	         try{
//	            fileMeta.setBytes(mpf.getBytes());
	            FileCopyUtils.copy(mpf.getBytes(), 
	                  new FileOutputStream(filePath+"user/"+mpf.getOriginalFilename()));   
	         }catch(IOException e){
	            e.printStackTrace();
	         }
	      }
	  }
}

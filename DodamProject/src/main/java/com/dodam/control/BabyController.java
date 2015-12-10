package com.dodam.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dodam.service.BabyService;
import com.dodam.service.SBabyService;
import com.dodam.service.domain.Baby;
import com.dodam.service.domain.SBaby;
import com.dodam.service.domain.User;

@Controller
@RequestMapping("/baby/*")
public class BabyController {
	
	@Autowired
	@Qualifier("babyServiceImpl")
	private BabyService babyService;
	
	@Autowired
	@Qualifier("sBabyServiceImpl")
	private SBabyService sBabyService;
	
	public BabyController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	@RequestMapping(value="/json/addBaby")
	public void addJsonBaby(@RequestBody Baby baby) throws Exception{
		
		SBaby sBaby=new SBaby();
		User user=new User();
		user.setuNo(baby.getuNo());
		System.out.println("addBaby Controller 들어옴");
		
		baby.setMom(user);
		System.out.println("user no??"+user.getuNo());
		System.out.println(baby);
		babyService.insertBaby(baby);
		
		System.out.println(baby.getbNo());
		sBaby.setbNo(baby.getbNo());
		sBaby.setHeight(baby.getHeight());
		sBaby.setWeight(baby.getWeight());
		sBabyService.insertSBaby(sBaby);
			
	}
	

	
	
	
	   @RequestMapping(value="/json/uploadImg", method=RequestMethod.POST)
	   public void upload(MultipartHttpServletRequest request) throws Exception{
	      
	      System.out.println("baby image 들어옴");
	      
	      MultipartFile mpf = null;
	      
	      Iterator<String> itr = request.getFileNames(); 
	      
	      
	      while(itr.hasNext()){
	         mpf = request.getFile(itr.next());         
          
	         try{
	            FileCopyUtils.copy(mpf.getBytes(), 
	                  new FileOutputStream("C:/Users/user/git/DodamProject/DodamProject/src/main/webapp/resources/img/baby/"+mpf.getOriginalFilename()));   
	         }catch(IOException e){
	            e.printStackTrace();
	         }
	      }
	   }
	
	@RequestMapping(value="/json/updateBaby")
	public void updateJsonBaby(@RequestBody Baby baby) throws Exception{
		SBaby sBaby=new SBaby();
		System.out.println("updateBaby Controller 들어옴");
		System.out.println(baby);
		
		babyService.updateBaby(baby);
		sBaby.setbNo(baby.getbNo());
		sBaby.setHeight(baby.getHeight());
		sBaby.setWeight(baby.getWeight());
		
		sBabyService.updateSBaby(sBaby);
		
	}
	
	@RequestMapping(value="/json/getBaby")
	public void getJsonBaby(@RequestBody Baby baby, Model model ) throws Exception{
		
		System.out.println("getBaby controller 들어옴");
		System.out.println(baby);
		
		Baby getBaby=babyService.getBaby(baby.getbNo());
		
		System.out.println(getBaby);
		model.addAttribute("baby",getBaby);
	}
	
	@RequestMapping(value="/json/deleteBaby")
	public void deleteJsonBaby(@RequestBody Baby baby) throws Exception{
		
		System.out.println("deleteBaby Controller 들어옴");
		System.out.println(baby);
		
		sBabyService.deleteSBaby(baby.getbNo());
		babyService.deleteBaby(baby.getbNo());

	}
	
	

}

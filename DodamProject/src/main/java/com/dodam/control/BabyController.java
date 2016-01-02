package com.dodam.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

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
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor.GetterOnlyReflection;

@Controller
@RequestMapping("/baby/*")
public class BabyController {
	
	@Autowired ServletContext servletCtx;
	
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
	public void addJsonBaby(@RequestBody Baby baby,Model model) throws Exception{
		
		SBaby sBaby=new SBaby();
		User user=new User();
		user.setuNo(baby.getuNo());
		System.out.println("addBaby Controller 들어옴");
		
		String birth=baby.getbBirth().substring(0, 4)+"-"+baby.getbBirth().substring(4, 6)+"-"+
		baby.getbBirth().substring(6, 8);
		
		baby.setbBirth(birth);
		
		baby.setMom(user);
		System.out.println("user no??"+user.getuNo());
		System.out.println(baby);
		int babyResult=babyService.insertBaby(baby);
		
		System.out.println(baby.getbNo());
		sBaby.setbNo(baby.getbNo());
		sBaby.setHeight(baby.getHeight());
		sBaby.setWeight(baby.getWeight());
		int sBabyResult=sBabyService.insertSBaby(sBaby);
		
		if(babyResult==1 && sBabyResult==1) {
			model.addAttribute("result", true);
		}
			
	}
	

	
	
	
	   @RequestMapping(value="/json/uploadImg", method=RequestMethod.POST)
	   public void upload(MultipartHttpServletRequest request) throws Exception{
	      
		   System.out.println("uploadImg 들어옴");
		      
//	      FileMeta fileMeta = null;
	      MultipartFile mpf = null;
	      
	      Iterator<String> itr = request.getFileNames(); 
	      
	      String filePath=servletCtx.getRealPath("/dodam_upload")+"/";
	      
	      while(itr.hasNext()){
	         mpf = request.getFile(itr.next());         
	            
	         try{
//	            fileMeta.setBytes(mpf.getBytes());
	            FileCopyUtils.copy(mpf.getBytes(), 
	                  new FileOutputStream(filePath+"baby/"+mpf.getOriginalFilename()));   
	         }catch(IOException e){
	            e.printStackTrace();
	         }
	      }
	   }
	
	@RequestMapping(value="/json/updateBaby")
	public void updateJsonBaby(@RequestBody Baby baby,Model model) throws Exception{
		SBaby sBaby=new SBaby();
		System.out.println("updateBaby Controller 들어옴");
		System.out.println(baby);
		
		String birth=baby.getbBirth().substring(0, 4)+"-"+baby.getbBirth().substring(4, 6)+"-"+
		baby.getbBirth().substring(6, 8);
		
		baby.setbBirth(birth);
		
		int babyResult=babyService.updateBaby(baby);
		sBaby.setbNo(baby.getbNo());
		sBaby.setHeight(baby.getHeight());
		sBaby.setWeight(baby.getWeight());
		
		int sBabyResult=sBabyService.updateSBaby(sBaby);
		
		System.out.println(babyResult);
		System.out.println(sBabyResult);
		
		if(babyResult==1 && sBabyResult==1) {
			System.out.println("둘다 true");
			model.addAttribute("result", true);
		}
		
	}
	
	@RequestMapping(value="/json/getBaby")
	public void getJsonBaby(@RequestBody Baby baby, Model model ) throws Exception{
		
		System.out.println("getBaby controller 들어옴");
		System.out.println(baby);
		
		Baby getBaby=babyService.getBaby(baby.getbNo());
		
		System.out.println(getBaby);
		model.addAttribute("baby",getBaby);
	}
	
	@RequestMapping(value="/json/getUNoBaby")
	public void getJsonUNoBaby(@RequestBody Baby baby, Model model ) throws Exception{
		
		System.out.println("getBaby controller 들어옴");
		System.out.println(baby);
		
		Baby getBaby=babyService.getUNoBaby(baby.getuNo());
		
		System.out.println(getBaby);
		
		if(getBaby==null){
			model.addAttribute("resultCode", 0);
		}
		else{
			model.addAttribute("resultCode", 1);
			model.addAttribute("baby",getBaby);
		}
	}
	
	@RequestMapping(value="/json/deleteBaby")
	public void deleteJsonBaby(@RequestBody Baby baby) throws Exception{
		
		System.out.println("deleteBaby Controller 들어옴");
		System.out.println(baby);
		
		sBabyService.deleteSBaby(baby.getbNo());
		babyService.deleteBaby(baby.getbNo());

	}
	
	

}

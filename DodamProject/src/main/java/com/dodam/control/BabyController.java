package com.dodam.control;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public void addJsonBaby(@RequestBody Baby baby,@RequestBody SBaby sBaby, Model model) throws Exception{
		
		System.out.println("addBaby Controller 들어옴");
		System.out.println(baby);
		System.out.println(sBaby);
		
		
		
	}
	
	@RequestMapping(value="/json/updateBaby")
	public void updateJsonBaby(@RequestBody Baby baby, Model model) throws Exception{
		
		System.out.println("updateBaby Controller 들어옴");
		System.out.println(baby);
		
		babyService.updateBaby(baby);
		
		model.addAttribute("baby",baby);
	}
	
	@RequestMapping(value="/json/getBaby")
	public void getJsonBaby(@RequestBody Baby baby, Model model ) throws Exception{
		
		System.out.println("getBaby controller 들어옴");
		System.out.println(baby);
		
		Baby getBaby=babyService.getBaby(baby.getbNo());
		
		model.addAttribute("baby",getBaby);
	}
	
	@RequestMapping(value="/json/deleteBaby")
	public void deleteJsonBaby(@RequestBody Baby baby,Model model) throws Exception{
		
		System.out.println("deleteBaby Controller 들어옴");
		System.out.println(baby);
		
		babyService.deleteBaby(baby.getbNo());
		
		model.addAttribute("baby",baby);
	}
	
	

}

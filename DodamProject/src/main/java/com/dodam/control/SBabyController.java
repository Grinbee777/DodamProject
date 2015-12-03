package com.dodam.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.SBabyService;
import com.dodam.service.domain.SBaby;

@Controller
@RequestMapping("/sbaby/*")
public class SBabyController {
	
	@Autowired
	@Qualifier("sBabyServiceImpl")
	private SBabyService sBabyService;
	
	public SBabyController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	@RequestMapping(value="/json/addSBaby")
	public void addJsonSBaby(@RequestBody SBaby sBaby, Model model) throws Exception {
		System.out.println("addJsonSBaby Controller 들어옴");
		System.out.println(sBaby);
		
		sBabyService.insertSBaby(sBaby);
	}
	
	@RequestMapping(value="/json/updateSBaby")
	public void updateJsnoSBaby(@RequestBody SBaby sBaby, Model model) throws Exception {
		System.out.println("updateJsonSBaby Controller 들어옴");
		System.out.println(sBaby);
		
		sBabyService.updateSBaby(sBaby);
	}

	@RequestMapping(value="/json/deleteSBaby")
	public void deleteJsonSBaby(@RequestBody SBaby sBaby,Model model) throws Exception{
		System.out.println("deleteSBaby Controller 들어옴");
		System.out.println(sBaby);
		
		sBabyService.deleteSBaby(sBaby.getSbNo());
	}
}

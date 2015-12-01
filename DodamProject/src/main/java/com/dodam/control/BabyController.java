package com.dodam.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.BabyService;

@Controller
@RequestMapping("/baby/*")
public class BabyController {
	
	@Autowired
	@Qualifier("babyServiceImpl")
	private BabyService babyService;
	
	public BabyController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	

}

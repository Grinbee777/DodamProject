package com.dodam.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.SBabyService;

@Controller
@RequestMapping("/sbaby/*")
public class SBabyController {
	
	@Autowired
	@Qualifier("sBabyServiceImpl")
	private SBabyService sBabyService;
	
	public SBabyController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

}

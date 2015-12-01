package com.dodam.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.NapService;

@Controller
@RequestMapping("/nap/*")
public class NapController {
	
	@Autowired
	@Qualifier("napServiceImpl")
	private NapService napService;
	
	public NapController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

}

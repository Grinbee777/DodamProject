package com.dodam.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.PooService;

@Controller
@RequestMapping("/poo/*")
public class PooController {
	
	@Autowired
	@Qualifier("pooServiceImpl")
	private PooService pooService;
	
	public PooController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

}

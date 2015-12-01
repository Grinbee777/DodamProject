package com.dodam.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.RepliesService;

@Controller
@RequestMapping("/replies/*")
public class RepliesController {
	
	@Autowired
	@Qualifier("repliesServiceImpl")
	private RepliesService repliesService;
	
	public RepliesController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

}

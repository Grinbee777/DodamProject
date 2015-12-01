package com.dodam.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.FeedService;

@Controller
@RequestMapping("/feed/*")
public class FeedController {
	
	@Autowired
	@Qualifier("feedServiceImpl")
	private FeedService feedService;
	
	public FeedController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

}

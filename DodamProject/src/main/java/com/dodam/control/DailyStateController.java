package com.dodam.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.DailyStateService;

@Controller
@RequestMapping("/dailyState/*")
public class DailyStateController {
	
	@Autowired
	@Qualifier("dailyStateServiceImpl")
	private DailyStateService dailyStateService;
	
	public DailyStateController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

}

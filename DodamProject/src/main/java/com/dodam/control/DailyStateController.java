package com.dodam.control;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.DailyStateService;
import com.dodam.service.domain.DailyState;

@Controller
@RequestMapping("/dailyState/*")
public class DailyStateController {
	
	@Autowired
	@Qualifier("dailyStateServiceImpl")
	private DailyStateService dailyStateService;
	
	public DailyStateController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	@RequestMapping( value="/json/getDailyState")
	public void getJsonDailyState(@RequestBody DailyState dailyState, Model model) throws Exception {
		dailyState.setbNO(100011);
		Date d = new Date(2015, 12, 02);
		dailyState.setDsDate(d);
		
		dailyState = dailyStateService.getDailyState(dailyState);
		
		System.out.println("####"+dailyState);
		
		model.addAttribute(dailyState);
	}

}

package com.dodam.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.DailyStateService;
import com.dodam.service.FeedService;
import com.dodam.service.NapService;
import com.dodam.service.PooService;
import com.dodam.service.domain.DailyState;
import com.dodam.service.domain.Feed;
import com.dodam.service.domain.Nap;
import com.dodam.service.domain.Poo;

@Controller
@RequestMapping("/dailyState/*")
public class DailyStateController {
	
	@Autowired
	@Qualifier("dailyStateServiceImpl")
	private DailyStateService dailyStateService;
	
	@Autowired
	@Qualifier("napServiceImpl")
	private NapService napService;
	
	@Autowired
	@Qualifier("feedServiceImpl")
	private FeedService feedService;
	
	@Autowired
	@Qualifier("pooServiceImpl")
	private PooService pooService;
	
	public DailyStateController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	
	@RequestMapping(value="/json/addNap")
	public void addJsonNap(@RequestBody DailyState dailyState, @RequestBody Nap nap) throws Exception {
		
		if(dailyState.getDsNo()==0){
			dailyStateService.insertDState(dailyState);
		}else{
			
		}
		napService.insertNap(nap);
	}
	
	/*
	@RequestMapping(value="/json/updateNap")
	public void updateJsonNap(@RequestBody Nap nap) throws Exception{
	}
	*/
	
	@RequestMapping(value="/json/")
	public void n2() throws Exception{
		
	}
	
	@RequestMapping(value="/json/")
	public void n3() throws Exception{
		
	}
	
	
	
	@RequestMapping(value="/json/addFeed")
	public void addJsonFeed(@RequestBody DailyState dailyState, @RequestBody Feed feed) throws Exception {
		//check 로직 추가 - DS 도메인 or dsNo
		feedService.insertFeed(feed);
	}
	
	@RequestMapping(value="/json/")
	public void f1() throws Exception{
		
	}
	
	@RequestMapping(value="/json/")
	public void f2() throws Exception{
		
	}
	
	@RequestMapping(value="/json/")
	public void f3() throws Exception{
		
	}
	
	@RequestMapping(value="/json/addPoo")
	public void addJsonPoo(@RequestBody DailyState dailyState, @RequestBody Poo poo) throws Exception {
		//check 로직 추가 - DS 도메인 or dsNo
		pooService.insertPoo(poo);
	}
	
	@RequestMapping(value="/json/")
	public void p1() throws Exception{
		
	}
	
	@RequestMapping(value="/json/")
	public void p2() throws Exception{
		
	}
	
	@RequestMapping(value="/json/")
	public void p3() throws Exception{
		
	}
	
	@RequestMapping(value="/json/getDailyState")
	public void getJsonDailyState(@RequestBody DailyState dailyState, Model model) throws Exception {
		System.out.println("@@ "+dailyState);
		//model.addAttribute(dailyStateService.getDailyState(dailyState));
	}
	
	@RequestMapping(value="/json/")
	public void d1() throws Exception{
		
	}
	
	@RequestMapping(value="/json/")
	public void d2() throws Exception{
		
	}
	
	@RequestMapping(value="/json/")
	public void d3() throws Exception{
		
	}

}

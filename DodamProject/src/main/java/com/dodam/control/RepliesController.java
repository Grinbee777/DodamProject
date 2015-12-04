package com.dodam.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.RepliesService;
import com.dodam.service.domain.Diary;
import com.dodam.service.domain.Replies;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@Controller
@RequestMapping("/replies/*")
public class RepliesController {
	
	@Autowired
	@Qualifier("repliesServiceImpl")
	private RepliesService repliesService;
	
	public RepliesController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	@RequestMapping(value="/json/addReplies")
	public void addJsonReplies(@RequestBody Replies replies) throws Exception{
		System.out.println(":: addJsonReplies ::");
		System.out.println(":: 전달받은 replies 인스턴스 :"+replies);
		System.out.println(":: result :"+repliesService.insertReplies(replies));
		//
	}
	
	@RequestMapping(value="/json/getReplies")
	public void  getJsonReplies(@RequestBody Replies replies, Model model) throws Exception{
		System.out.println(":: getJsonReplies ::");
		System.out.println("::rNo::"+replies.getrNo());
		
		replies = repliesService.getReplies(replies.getrNo());
		System.out.println("::result :"+replies);
		model.addAttribute("replies", replies);
	}
	
	@RequestMapping(value="/json/getRepliesList")
	public void getJsonRepliesList(@RequestBody Diary diary, Model model ) throws Exception{
		System.out.println(":: getJsonRepliesList ::");
		System.out.println(":: dNo :"+diary.getdNo());
		
		System.out.println(":: result :"+repliesService.getRepliesList(diary.getdNo()));
//		System.out.println(":: result :"+list.toString() );
//		model.addAttribute("list", list);		
	}
	
	@RequestMapping(value="/json/updateReplies")
	public void updateJsonReplies(@RequestBody Replies replies) throws Exception{
		System.out.println(":: updateJsonReplies ::");
		System.out.println(":: replies :"+replies);
		System.out.println(":: result :"+repliesService.updateReplies(replies));
	}
	
	@RequestMapping(value="/json/deleteReplies")
	public void deleteJsonReplies(@RequestBody Replies replies) throws Exception{
		System.out.println(":: deleteJsonReplies ::");
		System.out.println(":: rNo :"+replies.getrNo());
		System.out.println(":: result :"+repliesService.deleteReplies(replies.getrNo()));		
	}
	

}

package com.dodam.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.DiaryService;
import com.dodam.service.RepliesService;
import com.dodam.service.UserService;
import com.dodam.service.domain.Diary;
import com.dodam.service.domain.Replies;

@Controller
@RequestMapping("/replies/**")
public class RepliesController {
	
	@Autowired
	@Qualifier("repliesServiceImpl")
	private RepliesService repliesService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("diaryServiceImpl")
	private DiaryService diaryService;
	
	public RepliesController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}

	
	@RequestMapping(value="/json/addReplies")
	public void addJsonReplies(@RequestBody Replies replies, Model model) throws Exception{
		System.out.println(":: addJsonReplies ::");
		System.out.println(":: 전달받은 replies 인스턴스 :"+replies);
		replies.setrUser(userService.getUser(replies.getrUNo()));
		
		System.out.println(":: result :"+repliesService.insertReplies(replies));
		model.addAttribute("result", true);
		
	}
	

	
	@RequestMapping(value="/json/getReplies")
	public void  getJsonReplies(@RequestBody Replies replies, Model model) throws Exception{
		System.out.println(":: getJsonReplies ::");
		System.out.println("::rNo::"+replies.getrNo());
		
		replies = repliesService.getReplies(replies.getrNo());
		System.out.println("::result aaa:"+replies);
		model.addAttribute("replies", replies);
	}
	
	@RequestMapping(value="/json/getRepliesList")
	public void getJsonRepliesList(@RequestBody Diary diary, Model model ) throws Exception{
		System.out.println(":: getJsonRepliesList ::");
		System.out.println(":: dNo :"+diary.getdNo());
		List<Replies> replyList = repliesService.getRepliesList(diary.getdNo());
		for(int i=0; i< replyList.size(); i++){
			replyList.get(i).setrUser(userService.getNickUser(replyList.get(i).getrUser().getNickname()));
			System.out.println(replyList.get(i));
		}
		
		model.addAttribute("replyList", replyList);		
	}
	
	@RequestMapping(value="/json/getReplyCount")
	public void getJsonReplyCount(@RequestBody Diary diary, Model model ) throws Exception{
		System.out.println(":: getJsonReplyCount ::");
		System.out.println(":: dNo :"+diary.getdNo());
		List<Replies> replyList = new ArrayList<>();
		replyList = repliesService.getRepliesList(diary.getdNo());
		int replyCount = replyList.size();
		System.out.println(replyCount);
		model.addAttribute("replyCount", replyCount);		
	}
	
	@RequestMapping(value="/json/updateReplies")
	public void updateJsonReplies(@RequestBody Replies replies, Model model) throws Exception{
		System.out.println(":: updateJsonReplies ::");
		System.out.println(":: replies :"+replies);
		if(repliesService.updateReplies(replies)==1){
			System.out.println(":: result == true");
			model.addAttribute("result", repliesService.getReplies(replies.getrNo()));
		}else{
			System.out.println(":: result == false");
			model.addAttribute("result", false);
		}
	}
	
	@RequestMapping(value="/json/deleteReplies")
	public void deleteJsonReplies(@RequestBody Replies replies, Model model) throws Exception{
		System.out.println(":: deleteJsonReplies ::");
		System.out.println(":: rNo :"+replies.getrNo());
		//System.out.println(":: result :"+repliesService.deleteReplies(replies.getrNo()));
		if(repliesService.deleteReplies(replies.getrNo())==1){
			model.addAttribute("result", true);
		}else{
			model.addAttribute("result", false);
		}
	}
	
	
	@RequestMapping(value="/json/deleteDiaryReply")
	public void deleteJsonDiaryReply(@RequestBody Replies replies, Model model) throws Exception{
		System.out.println(":: deleteJsonDiaryReply ::");
		System.out.println(":: dNo :"+replies.getdNo());
		//System.out.println(":: result :"+repliesService.deleteReplies(replies.getrNo()));
		if(repliesService.deleteDiaryReply(replies.getdNo())==1){
			model.addAttribute("result", true);
		}else{
			model.addAttribute("result", false);
		}
	}
	

}

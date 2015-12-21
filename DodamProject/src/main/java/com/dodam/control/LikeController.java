package com.dodam.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.DiaryService;
import com.dodam.service.LikeService;
import com.dodam.service.UserService;
import com.dodam.service.domain.Like;

@Controller
@RequestMapping("/like/**")
public class LikeController {
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("diaryServiceImpl")
	private DiaryService diaryService;
	
	@Autowired
	@Qualifier("likeServiceImpl")
	private LikeService likeService;
	
	public LikeController(){
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	@RequestMapping(value="/json/insertLike")
	public void insertJsonLike(@RequestBody Like like, Model model) throws Exception{
		
		System.out.println(":: insertJsonLike ::");
		System.out.println("전달받은 Like :: "+like);
		
		int result = likeService.insertLike(like);
		if(result == 1){
			model.addAttribute("result", true);
		}else{
			model.addAttribute("result", false);
		}
		
	}
	
	@RequestMapping(value="/json/countLike")
	public void countJsonLike(@RequestBody Like like, Model model) throws Exception{
		
		System.out.println(":: countJsonLike ::");
		System.out.println("전달받은 Like :: "+like);
		
		List<Like> list = likeService.getLikeList(like.getdNo());
		
		int result = list.size();
		
		model.addAttribute("likeCount", new Integer(result));
		
	}
	
	@RequestMapping(value="/json/deleteLike")
	public void updateJsonLike(@RequestBody Like like, Model model) throws Exception{
		
		System.out.println(":: deleteJsonLike ::");
		System.out.println("전달받은 Like :: "+like);
		
				
		int result = likeService.deleteLike(like);
		if(result == 1){
			model.addAttribute("result", true);
		}else{
			model.addAttribute("result", false);
		}
		
		
	}

}

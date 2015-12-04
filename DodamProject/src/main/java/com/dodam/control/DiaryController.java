package com.dodam.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dodam.service.DiaryService;
import com.dodam.service.RepliesService;
import com.dodam.service.domain.Diary;
import com.dodam.service.domain.Replies;

@Controller
@RequestMapping("/diary/*")
public class DiaryController {
	
	@Autowired
	@Qualifier("diaryServiceImpl")
	private DiaryService diaryService;
	
	@Autowired
	@Qualifier("repliesServiceImpl")
	private RepliesService repliesService;
	
	public DiaryController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	@RequestMapping(value="/json/addDiary", method=RequestMethod.POST)
	public void addJsonDiary(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: addJsonDiary ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
		diaryService.insertDiary(diary);
		
	}
	
	@RequestMapping(value="/json/updateDiary", method=RequestMethod.POST)
	public void updateJsonDiary(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: updateJsonDiary ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
		diaryService.updateDiary(diary);
		
	}
	
	@RequestMapping(value="/json/deleteDiary", method=RequestMethod.POST)
	public void deleteJsonDiary(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: updateJsonDiary ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
		diaryService.deleteDiary(diary.getdNo());
		
	}
	
	/*@RequestMapping(value="/json/getDiary", method=RequestMethod.POST)
	public void getJsonDiary(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: getJsonDiary ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
		Diary returnDiary = diaryService.getDiary(diary.getdNo());
		System.out.println("리턴될 diary : "+returnDiary);
		model.addAttribute("diary", returnDiary);
		
	}*/
	@RequestMapping(value="/json/getDiary")
	public void getJsonDiary(Model model) throws Exception{
		
		System.out.println(":: getJsonDiary ::");
		//System.out.println("전달받은 diary 인스턴스 == "+diary);
		//Diary returnDiary = diaryService.getDiary(diary.getdNo());
		//System.out.println("리턴될 diary : "+returnDiary);
		model.addAttribute("diary", diaryService.getDiary(100000));
		
	}
	
	/*@RequestMapping(value="/json/getUserDiaryList", method=RequestMethod.POST)
	public void getJsonUserDiaryList(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: getJsonUserDiaryList ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
		diaryService.getDiaryList(diary.getDiaryUser().getuNo());
		
	}*/
	
	@RequestMapping(value="/json/getUserDiaryList")
	public void getJsonUserDiaryList(Model model) throws Exception{
		
		System.out.println(":: getJsonUserDiaryList ::");
//		System.out.println("전달받은 diary 인스턴스 == "+diary);
//		diaryService.getDiaryList(diary.getDiaryUser().getuNo());
		List<Diary> list = diaryService.getDiaryList(100015);
		for(int i = 0; i<list.size(); i++){
			List<Replies> temp = repliesService.getRepliesList(list.get(i).getdNo());
			list.get(i).setReplyList(temp);
			list.get(i).setReplyCount(temp.size());
		}
		model.addAttribute("diaries", list);
		
	}
	
	
}

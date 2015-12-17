package com.dodam.control;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dodam.service.BabyService;
import com.dodam.service.DiaryService;
import com.dodam.service.FriendService;
import com.dodam.service.RepliesService;
import com.dodam.service.UserService;
import com.dodam.service.domain.Diary;
import com.dodam.service.domain.Friend;
import com.dodam.service.domain.Replies;
import com.dodam.service.domain.User;
import com.dodam.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/diary/*")
public class DiaryController {
	
	@Autowired
	@Qualifier("diaryServiceImpl")
	private DiaryService diaryService;
	
	@Autowired
	@Qualifier("repliesServiceImpl")
	private RepliesService repliesService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("babyServiceImpl")
	private BabyService babyService;
	
	@Autowired
	@Qualifier("friendServiceImpl")
	private FriendService friendService;
	
	public DiaryController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	@RequestMapping(value="/json/addDiary")
	public void addJsonDiary(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: addJsonDiary ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
		diary.setDiaryUser(userService.getUser(diary.getuNo()));
		diary.setDiaryBaby(babyService.getBaby(diary.getuNo()));
		System.out.println("user, baby 추가된 인스턴스 =="+diary);
		if(diary.getdContent().indexOf("#") == -1){
			diary.setdTag("오늘의 일기");
		}else{
			diary.setdTags(diary.getdTag().split("#"));
		}
		
		
		diaryService.insertDiary(diary);
		
		//HashMap<String,Object> resultMap = new HashMap<>();
		//resultMap.put("status", "success");
		//return resultMap;
		model.addAttribute("result", true);
	}
	@RequestMapping(value="/json/uploadImg", method=RequestMethod.POST)
	public void addDiaryImg(MultipartHttpServletRequest request) throws Exception{
		
		System.out.println(":: uploadDiaryImg ::");
		MultipartFile mpf = null;
		Iterator<String> itr = request.getFileNames(); 
		 while(itr.hasNext()){
	         mpf = request.getFile(itr.next());         
//	         fileMeta = new FileMeta();
//	         fileMeta.setFileName(mpf.getOriginalFilename());
//	         fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
//	         fileMeta.setFileType(mpf.getContentType());
	            
	         try{
//	            fileMeta.setBytes(mpf.getBytes());
	            FileCopyUtils.copy(mpf.getBytes(), 
	                  new FileOutputStream("C:\\Users\\BitCamp\\git\\DodamProject\\DodamProject\\src\\main\\webapp\\resources\\img\\diary\\"+mpf.getOriginalFilename()));
	            
	            File originalFileNm = new File("C:\\Users\\BitCamp\\git\\DodamProject\\DodamProject\\src\\main\\webapp\\resources\\img\\diary\\"+mpf.getOriginalFilename());
	            File thumbnailFileNm = new File("C:\\Users\\BitCamp\\git\\DodamProject\\DodamProject\\src\\main\\webapp\\resources\\thumbnail\\diary\\"+mpf.getOriginalFilename());
	            int width = 400;
	            int height = 400;
	            // 썸네일 이미지 생성
	            BufferedImage originalImg = ImageIO.read(originalFileNm);
	            BufferedImage thumbnailImg = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
	            // 썸네일 그리기 
	            Graphics2D g = thumbnailImg.createGraphics();
	            g.drawImage(originalImg, 0, 0, width, height, null);
	            // 파일생성
	            ImageIO.write(thumbnailImg, "jpg", thumbnailFileNm);   
	            
	         }catch(IOException e){
	            e.printStackTrace();
	         }
	      }
	}
	
	@RequestMapping(value="/json/updateDiary", method=RequestMethod.POST)
	public void updateJsonDiary(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: updateJsonDiary ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
		
				
		if(diaryService.updateDiary(diary) == 1){
			model.addAttribute("result", true);
		}else{
			model.addAttribute("result", false);
		}
		
	}
	
	@RequestMapping(value="/json/deleteDiary", method=RequestMethod.POST)
	public void deleteJsonDiary(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: deleteJsonDiary ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
		
		if(repliesService.getRepliesList(diary.getdNo()).size() >= 1){
			repliesService.deleteDiaryReply(diary.getdNo());
		}
		
		if(diaryService.deleteDiary(diary.getdNo()) == 1){
			model.addAttribute("result", true);
		}else{
			model.addAttribute("result", false);
		}
		
	}
	
	@RequestMapping(value="/json/getDiary", method=RequestMethod.POST)
	public void getJsonDiary(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: getJsonDiary ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
		//Diary returnDiary = diaryService.getDiary(diary.getdNo());
		diary = diaryService.getDiary(diary.getdNo());
		System.out.println("리턴될 diary : "+diary);
		model.addAttribute("diary", diary);
		
	}
	
	
	/*@RequestMapping(value="/json/getUserDiaryList", method=RequestMethod.POST)
	public void getJsonUserDiaryList(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: getJsonUserDiaryList ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
		diaryService.getDiaryList(diary.getDiaryUser().getuNo());
		
	}*/
	
	@RequestMapping(value="/json/getUserDiaryList")
	public void getJsonUserDiaryList(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: getJsonUserDiaryList ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
				
		diary.setDiaryUser(userService.getUser(diary.getuNo()));
		System.out.println("전달받은 uNo로 찾은 user 인스턴스 == "+diary.getDiaryUser());
		
		List<Diary> list = diaryService.getDiaryList(diary.getDiaryUser().getuNo());
		System.out.println("check");
		for(int i = 0; i<list.size(); i++){
			List<Replies> replyList = repliesService.getRepliesList(list.get(i).getdNo());
			for(int j = 0; j<replyList.size(); j++){
				replyList.get(j).setrUser(userService.getNickUser(replyList.get(j).getrUser().getNickname()));
			}
			list.get(i).setReplyList(replyList);
			list.get(i).setReplyCount(replyList.size());
			list.get(i).setdPics(list.get(i).getdPic().split(","));
			list.get(i).setDiaryUser(userService.getUser(list.get(i).getDiaryUser().getuNo()));
			System.out.println(userService.getUser(list.get(i).getDiaryUser().getuNo()));
		}
		
		model.addAttribute("diaries", list);
		
	}
	
	@RequestMapping(value="/json/getFriendDiaryList")
	public void getJsonFriendDiaryList(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: getJsonFriendDiaryList ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
				
		diary.setDiaryUser(userService.getUser(diary.getuNo()));
		System.out.println("전달받은 uNo로 찾은 user 인스턴스 == "+diary.getDiaryUser());
		
		List<Friend> fList = friendService.getFriendList(diary.getDiaryUser().getuNo());
		
		List<Integer> friendNo = new ArrayList<Integer>();
		for(int i = 0; i<fList.size(); i++){
			System.out.println("친구목록 "+(i+1)+" :: "+fList.get(i));
			friendNo.add(i, fList.get(i).getFrMate());
		}
		
		friendNo.add(fList.size(), diary.getDiaryUser().getuNo());
		for(int i=0; i<friendNo.size(); i++){
			System.out.println("다이어리 검색할 uNo :: " + friendNo.get(i));
		}
		
		
		List<Diary> list = diaryService.getFriendDiaryList(friendNo);
		//System.out.println("check");
		for(int i = 0; i<list.size(); i++){
			List<Replies> replyList = repliesService.getRepliesList(list.get(i).getdNo());
			for(int j = 0; j<replyList.size(); j++){
				replyList.get(j).setrUser(userService.getNickUser(replyList.get(j).getrUser().getNickname()));
			}
			list.get(i).setReplyList(replyList);
			list.get(i).setReplyCount(replyList.size());
			list.get(i).setdPics(list.get(i).getdPic().split(","));
			list.get(i).setDiaryUser(userService.getUser(list.get(i).getDiaryUser().getuNo()));
			System.out.println(userService.getUser(list.get(i).getDiaryUser().getuNo()));
		}
		
		model.addAttribute("diaries", list);
		
	}
	
	@RequestMapping(value="/json/getDiaryListForCalender")
	public void getJsonDiaryListForCalender(@RequestBody Diary diary, Model model) throws Exception{
		System.out.println("::getJsonDiaryListForCalender::");
		
		List<Diary> list = diaryService.getDiaryListForCalender(diary);
	
		model.addAttribute("list", list);				
	}
	
}

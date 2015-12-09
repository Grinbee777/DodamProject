package com.dodam.control;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.dodam.service.RepliesService;
import com.dodam.service.UserService;
import com.dodam.service.domain.Diary;
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
	public void getJsonUserDiaryList(@RequestBody Diary diary, Model model) throws Exception{
		
		System.out.println(":: getJsonUserDiaryList ::");
		System.out.println("전달받은 diary 인스턴스 == "+diary);
				
		diary.setDiaryUser(userService.getUser(diary.getuNo()));
		System.out.println("전달받은 uNo로 찾은 user 인스턴스 == "+diary.getDiaryUser());
		
		List<Diary> list = diaryService.getDiaryList(diary.getDiaryUser().getuNo());
		
		for(int i = 0; i<list.size(); i++){
			List<Replies> temp = repliesService.getRepliesList(list.get(i).getdNo());
			list.get(i).setReplyList(temp);
			list.get(i).setReplyCount(temp.size());
			list.get(i).setdPics(list.get(i).getdPic().split(","));
		}
		
		model.addAttribute("diaries", list);
		
	}
	
	
}

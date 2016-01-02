package com.dodam.control;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;

import java.sql.Date;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Iterator;

import java.util.List;

import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.util.FileCopyUtils;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dodam.service.BabyService;

import com.dodam.service.DiaryService;

import com.dodam.service.FriendService;
import com.dodam.service.LikeService;
import com.dodam.service.RepliesService;

import com.dodam.service.UserService;

import com.dodam.service.domain.Diary;

import com.dodam.service.domain.Friend;
import com.dodam.service.domain.Like;
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
	
	@Autowired
	@Qualifier("likeServiceImpl")
	private LikeService likeService;
	
	@Autowired
	private ServletContext servletCtx;

	public DiaryController() {

		System.out.println(":::::" + getClass().getName() + " 생성!");

	}

	@RequestMapping(value = "/json/addDiary")

	public void addJsonDiary(@RequestBody Diary diary, Model model) throws Exception {

		System.out.println(":: addJsonDiary ::");

		System.out.println("전달받은 diary 인스턴스 == " + diary);

		diary.setDiaryUser(userService.getUser(diary.getuNo()));

		diary.setDiaryBaby(babyService.getBaby(diary.getuNo()));

		System.out.println("user, baby 추가된 인스턴스 ==" + diary);
		System.out.println("HashTag :"+diary.getdTag());
//		if (diary.getdContent().indexOf("#") == -1) {
//
//			diary.setdTag("오늘의 일기");
//
//		} else {
//
//			diary.setdTags(diary.getdTag().split("#"));
//
//		}

		diaryService.insertDiary(diary);

		// HashMap<String,Object> resultMap = new HashMap<>();

		// resultMap.put("status", "success");

		// return resultMap;

		model.addAttribute("result", true);

	}

	@RequestMapping(value = "/json/uploadImg", method = RequestMethod.POST)

	public void addDiaryImg(MultipartHttpServletRequest request) throws Exception {

		System.out.println(":: uploadDiaryImg ::");

		MultipartFile mpf = null;

		Iterator<String> itr = request.getFileNames();
		
		String filePath = servletCtx.getRealPath("/dodam_upload") + "/";
		String thumbnailPath = servletCtx.getRealPath("/thumbnail_upload") + "/";

		while (itr.hasNext()) {

			mpf = request.getFile(itr.next());

			// fileMeta = new FileMeta();

			// fileMeta.setFileName(mpf.getOriginalFilename());

			// fileMeta.setFileSize(mpf.getSize()/1024+" Kb");

			// fileMeta.setFileType(mpf.getContentType());

			try {

				// fileMeta.setBytes(mpf.getBytes());

				FileCopyUtils.copy(mpf.getBytes(),

						new FileOutputStream(
								filePath+"diary/"
										+ mpf.getOriginalFilename()));

				File originalFileNm = new File(
						filePath+"diary/"
								+ mpf.getOriginalFilename());

				File thumbnailFileNm = new File(
						thumbnailPath+"diary/"
								+ mpf.getOriginalFilename());

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

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

	@RequestMapping(value = "/json/updateDiary", method = RequestMethod.POST)

	public void updateJsonDiary(@RequestBody Diary diary, Model model) throws Exception {

		System.out.println(":: updateJsonDiary ::");

		System.out.println("전달받은 diary 인스턴스 == " + diary);

		if (diaryService.updateDiary(diary) == 1) {

			model.addAttribute("result", true);

		} else {

			model.addAttribute("result", false);

		}

	}

	@RequestMapping(value = "/json/deleteDiary", method = RequestMethod.POST)

	public void deleteJsonDiary(@RequestBody Diary diary, Model model) throws Exception {

		System.out.println(":: deleteJsonDiary ::");

		System.out.println("전달받은 diary 인스턴스 == " + diary);

		if (repliesService.getRepliesList(diary.getdNo()).size() >= 1) {

			repliesService.deleteDiaryReply(diary.getdNo());

		}
		
		if (likeService.getLikeList(diary.getdNo()).size() >= 1) {

			likeService.deleteDiaryLike(diary.getdNo());

		}

		if (diaryService.deleteDiary(diary.getdNo()) == 1) {

			model.addAttribute("result", true);

		} else {

			model.addAttribute("result", false);

		}

	}

	@RequestMapping(value = "/json/getDiary", method = RequestMethod.POST)

	public void getJsonDiary(@RequestBody Diary diary, Model model) throws Exception {

		System.out.println(":: getJsonDiary ::");

		System.out.println("전달받은 diary 인스턴스 == " + diary);

		// Diary returnDiary = diaryService.getDiary(diary.getdNo());

		diary = diaryService.getDiary(diary.getdNo());
		
		diary.setDiaryUser(userService.getUser(diary.getDiaryUser().getuNo()));
		diary.setLikeList(likeService.getLikeList(diary.getdNo()));
		diary.setReplyList(repliesService.getRepliesList(diary.getdNo()));
		diary.setLikeCount(diary.getLikeList().size());
		diary.setReplyCount(diary.getReplyList().size());
		diary.setdPics(diary.getdPic().split(","));

		System.out.println("리턴될 diary : " + diary);
		List<Diary> list = new ArrayList<>();
		list.add(diary);
		model.addAttribute("diaries", list);

	}

	/*
	 * @RequestMapping(value="/json/getUserDiaryList",
	 * method=RequestMethod.POST)
	 * 
	 * public void getJsonUserDiaryList(@RequestBody Diary diary, Model model)
	 * throws Exception{
	 * 
	 * 
	 * 
	 * System.out.println(":: getJsonUserDiaryList ::");
	 * 
	 * System.out.println("전달받은 diary 인스턴스 == "+diary);
	 * 
	 * diaryService.getDiaryList(diary.getDiaryUser().getuNo());
	 * 
	 * 
	 * 
	 * }
	 */

	@RequestMapping(value = "/json/getUserDiaryList")

	public void getJsonUserDiaryList(@RequestBody Diary diary, Model model) throws Exception {

		System.out.println(":: getJsonUserDiaryList ::");

		System.out.println("전달받은 diary 인스턴스 == " + diary);

		diary.setDiaryUser(userService.getUser(diary.getuNo()));

		System.out.println("전달받은 uNo로 찾은 user 인스턴스 == " + diary.getDiaryUser());

		List<Diary> list = diaryService.getDiaryList(diary.getDiaryUser().getuNo());

		System.out.println("check");

		for (int i = 0; i < list.size(); i++) {

			List<Replies> replyList = repliesService.getRepliesList(list.get(i).getdNo());
			
			List<Like> likeList = likeService.getLikeList(list.get(i).getdNo());

			for (int j = 0; j < replyList.size(); j++) {

				replyList.get(j).setrUser(userService.getNickUser(replyList.get(j).getrUser().getNickname()));

			}

			list.get(i).setReplyList(replyList);
			
			list.get(i).setLikeList(likeList);
			
			list.get(i).setLikeCount(likeList.size());

			list.get(i).setReplyCount(replyList.size());

			list.get(i).setdPics(list.get(i).getdPic().split(","));

			list.get(i).setDiaryUser(userService.getUser(list.get(i).getDiaryUser().getuNo()));

			System.out.println(userService.getUser(list.get(i).getDiaryUser().getuNo()));

		}

		model.addAttribute("diaries", list);

	}
	
	@RequestMapping(value = "/json/getAllDiary")

	public void getJsonAllDiary(@RequestBody Diary diary, Model model) throws Exception {

		System.out.println(":: getJsonAllDiary ::");

		System.out.println("전달받은 diary 인스턴스 == " + diary);

		List<Diary> list = diaryService.getAllDiary();

		for (int i = 0; i < list.size(); i++) {

			List<Replies> replyList = repliesService.getRepliesList(list.get(i).getdNo());
			
			List<Like> likeList = likeService.getLikeList(list.get(i).getdNo());

			for (int j = 0; j < replyList.size(); j++) {

				replyList.get(j).setrUser(userService.getNickUser(replyList.get(j).getrUser().getNickname()));

			}

			list.get(i).setReplyList(replyList);
			
			list.get(i).setLikeList(likeList);
			
			list.get(i).setLikeCount(likeList.size());

			list.get(i).setReplyCount(replyList.size());

			list.get(i).setdPics(list.get(i).getdPic().split(","));

			list.get(i).setDiaryUser(userService.getUser(list.get(i).getDiaryUser().getuNo()));

			System.out.println(userService.getUser(list.get(i).getDiaryUser().getuNo()));

		}

		model.addAttribute("diaries", list);

	}
	

	@RequestMapping(value = "/json/getFriendDiaryList")

	public void getJsonFriendDiaryList(@RequestBody Diary diary, Model model) throws Exception {

		System.out.println(":: getJsonFriendDiaryList ::");
		System.out.println("전달받은 diary 인스턴스 == " + diary);
		diary.setDiaryUser(userService.getUser(diary.getuNo()));
		System.out.println("전달받은 uNo로 찾은 user 인스턴스 == " + diary.getDiaryUser());
		List<Friend> fList = friendService.getFriendList(diary.getDiaryUser().getuNo());
		List<Integer> friendNo = new ArrayList<Integer>();
		for (int i = 0; i < fList.size(); i++) {
			System.out.println("친구목록 " + (i + 1) + " :: " + fList.get(i));
			friendNo.add(i, fList.get(i).getFrMate());
		}

		friendNo.add(fList.size(), diary.getDiaryUser().getuNo());
		for (int i = 0; i < friendNo.size(); i++) {
			System.out.println("다이어리 검색할 uNo :: " + friendNo.get(i));
		}
		List<Diary> list = diaryService.getFriendDiaryList(friendNo);
		// System.out.println("check");
		for (int i = 0; i < list.size(); i++) {
			List<Replies> replyList = repliesService.getRepliesList(list.get(i).getdNo());			
			List<Like> likeList = likeService.getLikeList(list.get(i).getdNo());
			for (int j = 0; j < replyList.size(); j++) {
				replyList.get(j).setrUser(userService.getNickUser(replyList.get(j).getrUser().getNickname()));
			}
			list.get(i).setReplyList(replyList);			
			list.get(i).setLikeList(likeList);
			list.get(i).setLikeCount(likeList.size());
			list.get(i).setReplyCount(replyList.size());
			list.get(i).setdPics(list.get(i).getdPic().split(","));
			list.get(i).setDiaryUser(userService.getUser(list.get(i).getDiaryUser().getuNo()));
			System.out.println(userService.getUser(list.get(i).getDiaryUser().getuNo()));
		}

		model.addAttribute("diaries", list);

	}

	@RequestMapping(value = "/json/getDiaryListForCalender")

	public void getJsonDiaryListForCalender(@RequestBody Diary diary, Model model) throws Exception {

		System.out.println("::getJsonDiaryListForCalender::");

		Map<String, Object> map = new HashMap<String, Object>();

		Date date = diary.getdDate();

		System.out.println("::::diary.getdDate :" + date + ", diary.getuNo :" + diary.getuNo());

		int month = date.getMonth() + 1;

		int year = date.getYear();

		System.out.println("::::month :" + month + ", year :" + year);

		String[] str = date.toString().split("-");

		for (int i = 0; i < str.length; i++) {

			System.out.println("str[" + i + "] :" + str[i]);

		}

		if (month == 4 || month == 6 || month == 9 || month == 11) {

			System.out.println("lastDay :" + str[0] + str[1] + "30");

			map.put("startDate", str[0] + str[1] + "01");

			map.put("lastDate", str[0] + str[1] + "30");

		} else if (month == 2) {

			System.out.println("lastDate :" + str[0] + str[1] + "28");

			map.put("startDate", str[0] + str[1] + "01");

			map.put("lastDate", str[0] + str[1] + "28");

		} else {

			System.out.println("lastDate :" + str[0] + str[1] + "31");

			map.put("startDate", str[0] + str[1] + "00");

			map.put("lastDate", str[0] + str[1] + "31");

		}

		map.put("uNo", diary.getuNo());

		List<Diary> list = diaryService.getDiaryListForCalender(map);

		for (int i = 0; i < list.size(); i++) {

			System.out.println("list[" + i + "] :" + list.get(i));

		}

		model.addAttribute("list", list);

	}
	
	// 달력에서 날짜 클릭시 다이어리리스트 불러오는 로직. 
	@RequestMapping(value="/json/getDailyDiaryList")
	public void getJsonDailyDiaryList(@RequestBody Diary diary, Model model){
		System.out.println("::getDailyDiaryList()::");
		System.out.println(":::: DataFromClient.diary.getuNo():"+diary.getuNo()+", diary.getdDate() :"+diary.getdDate());
		
		List<Diary> list = diaryService.getDailyDiaryList(diary);
		System.out.println("====From DB list.size():"+list.size());
		System.out.println("==== list :"+list);	
		model.addAttribute("list", list);
			
	}
	
	//[SELO77] 해쉬태그에 의한 다이어리 검색
		@RequestMapping(value="/json/getDiaryListByTag")
		public void getJsonDiaryListByTag(@RequestBody Diary diary, Model model) throws Exception{
			System.out.println("==getDiaryListByTag()== requestParam :"+diary.getdTag());
			
			List<Diary> list = diaryService.getDiaryListByTag(diary.getdTag());
			System.out.println("==== list.size() From DB :"+list.size());
			System.out.println("==== listByTag From DB :"+list);
			
			//Diary필수 디펜던시 데이터 
			for (int i = 0; i < list.size(); i++) {
				List<Replies> replyList = repliesService.getRepliesList(list.get(i).getdNo());			
				List<Like> likeList = likeService.getLikeList(list.get(i).getdNo());
				for (int j = 0; j < replyList.size(); j++) {
					replyList.get(j).setrUser(userService.getNickUser(replyList.get(j).getrUser().getNickname()));
				}
				list.get(i).setReplyList(replyList);			
				list.get(i).setLikeList(likeList);
				list.get(i).setLikeCount(likeList.size());
				list.get(i).setReplyCount(replyList.size());
				list.get(i).setdPics(list.get(i).getdPic().split(","));
				list.get(i).setDiaryUser(userService.getUser(list.get(i).getDiaryUser().getuNo()));
				System.out.println(userService.getUser(list.get(i).getDiaryUser().getuNo()));
			}
			
			model.addAttribute("diaries", list);		
		}
	
	//[SELO77] 해쉬태그에 의한 다이어리 검색
//	@RequestMapping(value="/json/getDiaryListByTag")
//	public void getJsonDiaryListByTag(@RequestParam String dTag, Model model) throws Exception{
//		System.out.println("==getDiaryListByTag()== requestParam :"+dTag);
//		
//		List<Diary> list = diaryService.getDiaryListByTag(dTag);
//		System.out.println("==== list.size() From DB :"+list.size());
//		System.out.println("==== listByTag From DB :"+list);
//		
//		//Diary필수 디펜던시 데이터 
//		for (int i = 0; i < list.size(); i++) {
//			List<Replies> replyList = repliesService.getRepliesList(list.get(i).getdNo());			
//			List<Like> likeList = likeService.getLikeList(list.get(i).getdNo());
//			for (int j = 0; j < replyList.size(); j++) {
//				replyList.get(j).setrUser(userService.getNickUser(replyList.get(j).getrUser().getNickname()));
//			}
//			list.get(i).setReplyList(replyList);			
//			list.get(i).setLikeList(likeList);
//			list.get(i).setLikeCount(likeList.size());
//			list.get(i).setReplyCount(replyList.size());
//			list.get(i).setdPics(list.get(i).getdPic().split(","));
//			list.get(i).setDiaryUser(userService.getUser(list.get(i).getDiaryUser().getuNo()));
//			System.out.println(userService.getUser(list.get(i).getDiaryUser().getuNo()));
//		}
//		
//		model.addAttribute("diaries", list);		
//	}

}
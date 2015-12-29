package com.dodam.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodam.service.DiaryService;
import com.dodam.service.FriendService;
import com.dodam.service.UserService;
import com.dodam.service.domain.Diary;
import com.dodam.service.domain.Friend;
import com.dodam.service.domain.User;

@Controller
@RequestMapping("/friend/*")
public class FriendController {

	@Autowired
	@Qualifier("friendServiceImpl")
	private FriendService friendService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("diaryServiceImpl")
	private DiaryService diaryService;

	public FriendController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	//친구 요청
	@RequestMapping(value="/json/friendRequest")
	public void friendRequest(@RequestBody Friend friend, Model model) throws Exception{
		
		System.out.println(":::"+friend);
		if(friend.getFrState()<=0){
			friend.setFrState(1);
		}
		if(friendService.insertFriend(friend)==1){
			model.addAttribute("message", "친구 요청을 전송하였습니다.");
		}else{
			model.addAttribute("message", "친구 요청이 실패하였습니다. 다시 시도해 주시기 바랍니다");
		}
	}
	

	//회원 검색 ( 친구 요청, 거부, 친구목록 제외하고 검색)
	@RequestMapping(value="/json/searchFriendList")
	public void searchFriendList(@RequestBody User user, Model model) throws Exception{
		
		List<User> userList=null;
		List<Friend> fNoList=null;
		
		if(user.getNickname().trim() != ""){
			userList = userService.getNickUserList(user);
			fNoList = friendService.getRelationList(user.getuNo());
			for(int j=0; j<fNoList.size();j++){
				for(int i=0; i<userList.size();i++){
				

					if(userList.get(i).getuNo() == fNoList.get(j).getFrMate() 
							|| userList.get(i).getuNo() == fNoList.get(j).getuNo()){
						userList.remove(i);
					}
				}
			}
			model.addAttribute("userList", userList);
		}
		
	}
	
	//친구목록
	@RequestMapping(value="/json/getFriendList")
	public void getJsonFriendList(@RequestBody Friend friend, Model model) throws Exception{
		
		//친구목록 가져오는 로직
		List<Friend> frTemp = friendService.getFriendList(friend.getuNo());
		int count = frTemp.size();
		
		for(int i=0; i<count; i++){
			frTemp.get(i).setUser(userService.getUser(frTemp.get(i).getFrMate()));
		}
		model.addAttribute("friendList", frTemp);
		model.addAttribute("frCount", count);
		
		//보낸 요청 가져오는 로직
		List<Friend> sendTemp = friendService.getFriendSendList(friend.getuNo());
		count = sendTemp.size();
		
		for(int i=0; i<count; i++){
			sendTemp.get(i).setUser(userService.getUser(sendTemp.get(i).getuNo()));
		}
		model.addAttribute("sendList", sendTemp);
		model.addAttribute("sendCount", count);
		
		//친구요청목록 가져오기위한 로직
		List<Friend> reqTemp=friendService.getFriendRequestList(friend.getuNo());
		count = reqTemp.size();
		
		for(int i=0; i<count; i++){
			reqTemp.get(i).setUser(userService.getUser(reqTemp.get(i).getuNo()));
		}
		
		model.addAttribute("friendReqList", reqTemp);
		model.addAttribute("frReqCount", count);
	
	}
	
	
	//친구 목록 테스트용 
	@RequestMapping(value="/json/getFriendDenyList")
	public void getFriendDenyList(@RequestBody Friend friend, Model model) throws Exception{
		
		List<Friend> denyList =friendService.getFriendDenyList(friend.getuNo());
		
		for(int i=0; i<denyList.size(); i++){
			denyList.get(i).setUser(userService.getUser(denyList.get(i).getFrMate()));
		}
		model.addAttribute("denyList", denyList);
	}
	
	
	//친구 요청에 승낙
	@RequestMapping(value="/json/approveFriend")
	public void updateApproveFriend(@RequestBody Friend friend, Model model) throws Exception{
	
		friend.setFrState(3);
		
		if(friendService.updateFriend(friend)==1){
		model.addAttribute("message", "친구 요청을 수락 하셨습니다");
	
		friend = friendService.getFriend(friend.getFrNo());
		friend.setUser(userService.getUser(friend.getuNo()));
		
		model.addAttribute("friendList", friend);
	
		//서로 친구....
		int temp=friend.getFrMate();
		friend.setFrMate(friend.getuNo());
		friend.setuNo(temp);
		
		//상대방도 친구로 뜨게하기
		friendService.insertFriend(friend);
		
		}else{
			model.addAttribute("message", "오류가 발생하였습니다");
		}
		
	}
	
	

	//친구요청 거절
	@RequestMapping(value="/json/denyFriend")
	public void updateDenyFriend(@RequestBody Friend friend, Model model) throws Exception{
		friend.setFrState(2);
		if(friendService.updateFriend(friend)==1){
			model.addAttribute("message", "친구 요청을 거부하셨습니다");
		}
	}
	
	//친구 삭제
	@RequestMapping(value="/json/deleteFriend")
	public void deleteFriend(@RequestBody Friend friend, Model model) throws Exception{
		
		if(friendService.deleteFriend(friend)==1){
			model.addAttribute("message", "삭제가 완료되었습니다");
		}
	}
	
	//친구 다이어리 보기
	@RequestMapping(value="/json/getFriendDiary")
	public void getFriendDiary(@RequestBody Friend friend, Model model) throws Exception{
		
		System.out.println("::::"+friend.getuNo());
		List<Diary> frDiary = diaryService.getDiaryList(friend.getuNo());
		
		model.addAttribute("diaries", frDiary);
	}
	
}

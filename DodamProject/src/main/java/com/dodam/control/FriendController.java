package com.dodam.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dodam.service.FriendService;
import com.dodam.service.UserService;
import com.dodam.service.domain.Friend;

@Controller
@RequestMapping("/friend/*")
public class FriendController {

	@Autowired
	@Qualifier("friendServiceImpl")
	private FriendService friendService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	public FriendController() {
		System.out.println(":::::"+getClass().getName()+" 생성!");
	}
	
	//친구 요청
	@RequestMapping(value="/json/friendRequest")
	public void friendRequest(@RequestBody Friend friend, Model model) throws Exception{
		
		if(friend.getFrState()<=0){
			friend.setFrState(1);
		}
		if(friendService.insertFriend(friend)==1){
			model.addAttribute("message", "친구 요청이 전송되었습니다.");
		}else{
			model.addAttribute("message", "친구 요청이 실패하였습니다. 다시 시도해 주시기 바랍니다");
		}
	}
	
	//친구목록
	@RequestMapping(value="/json/getFriendList")
	public void getJsonFriendList(@RequestParam int uNo, Model model) throws Exception{
		
		List<Friend> temp = friendService.getFriendList(uNo);
		int count = temp.size();
		model.addAttribute("FriendList", temp);
		model.addAttribute("frCount", count);
	
	}
	
	
	//친구 요청목록 받기
	@RequestMapping(value="/json/getFriendRequestList")
	public void getJsonFriendRequestList(/*@RequestParam int uNo,*/ Model model) throws Exception{
		//테스트용
		int uNo = 100016;
		
		List<Friend> temp=friendService.getFriendRequestList(uNo);
		int count = temp.size();
		
		for(int i=0; i<count; i++){
			temp.get(i).setUser(userService.getUser(temp.get(i).getuNo()));
		}
		
		model.addAttribute("friendReqList", temp);
		model.addAttribute("frReqCount", count);
	}
	
	
	//친구 요청에 승낙
	@RequestMapping(value="/json/approveFriend")
	public void updateApproveFriend(@RequestBody Friend friend, Model model) throws Exception{
		friend.setFrState(3);
		if(friendService.updateFriend(friend)==1){
		model.addAttribute("message", "친구 요청을 승낙하셨습니다");
		
		//서로 친구....
		int temp=friend.getFrNo();
		friend.setFrMate(friend.getFrNo());
		friend.setFrNo(temp);
		
		friendService.insertFriend(friend);
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
			model.addAttribute("message", "친구 관계를 해제 하셨습니다");
		}
	}
	
}
package diaryTest;

import org.apache.http.client.HttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dodam.service.DiaryService;
import com.dodam.service.domain.Baby;
import com.dodam.service.domain.Diary;
import com.dodam.service.domain.User;
import com.dodam.service.impl.DiaryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration	(locations = {"application-context.xml",
										"dispatch-servlet.xml"})

public class DiaryTest {
	
	@Autowired
	@Qualifier("diaryServiceImpl")
	private DiaryService diaryService;
	//private DiaryService diaryService = new DiaryServiceImpl();
	
	
	//@Test
	public void testAddDiary()throws Exception{
		Diary diary = new Diary();
		Baby baby = new Baby();
		User user = new User();
		
		baby.setbNo(100010);
		user.setuNo(100015);
		
		diary.setdCode("1");
		diary.setdContent("있는힘껏 배에다 힘줘 너의 손가락은 down down down down down 있는힘껏 악써 우리가 가루 가루 가루 가루 가루가 될때 까지");
		diary.setdPic("img/diary/pic1.jpg");
		diary.setdTag("#제목1, #다이어리");
		diary.setuPic("img/user/pic1.jpg");
		diary.setDiaryBaby(baby);
		diary.setDiaryUser(user);
		
		diaryService.insertDiary(diary);

	}
	//@Test
	public void testGetDiary() throws Exception{
		
		Diary diary = diaryService.getDiary(2);
		System.out.println("get Diary ==" + diary);
		
	}
	@Test
	public void testUpdateDiary()throws Exception{
		Diary diary = new Diary();
		Baby baby = new Baby();
		User user = new User();
		
		baby.setbNo(100010);
		user.setuNo(100015);
		
		diary.setdCode("1");
		diary.setdContent("있는힘껏 배에다 힘줘 너의 손가락은 down down down down down 있는힘껏 악써 우리가 가루 가루 가루 가루 가루가 될때 까지");
		diary.setdPic("img/diary/pic1.jpg");
		diary.setdTag("#제목1, #다이어리");
		diary.setuPic("img/user/pic1.jpg");
		diary.setDiaryBaby(baby);
		diary.setDiaryUser(user);
		
		diaryService.insertDiary(diary);
		
		diary.setdNo(100000);
		diary.setdPic("img/diary/pic2.jpg");
		diary.setdTag("#제목2, #다이어리");
		diary.setuPic("img/user/pic2.jpg");
		diaryService.updateDiary(diary);
		
		
		System.out.println("Update Diary 후 GetDiary : " + diaryService.getDiary(100000));
	}
	
	
	
}

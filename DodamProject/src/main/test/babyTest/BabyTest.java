package babyTest;

import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dodam.service.BabyService;
import com.dodam.service.domain.Baby;
import com.dodam.service.domain.User;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.sun.imageio.spi.InputStreamImageInputStreamSpi;

import junit.framework.Assert;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context.xml","dispatch-servlet.xml"})
public class BabyTest {
	
	@Autowired
	@Qualifier("babyServiceImpl")
	private BabyService babyService;
	
	public BabyTest(){
		
	}
	
	@Test
	public void testInsertBaby() throws Exception {
		Baby baby=new Baby();
		User user=new User();
		user.setuNo(100006);
		
		baby.setbName("근한이바보");
		baby.setbBirth("1989-12-10");
		baby.setbNature("깜찍");
		baby.setbPhoto("img/image.jpg");
		baby.setbSex(1);
		baby.setbType("B");
		baby.setMom(user);
		
		babyService.insertBaby(baby);
		
		System.out.println("baby 일련번호 : "+baby.getbNo());
	}
	
//	@Test
	public void testGetBaby() throws Exception {
		Baby baby=babyService.getBaby(100012);
		
		Assert.assertEquals("근한이귀여워", baby.getbName());
	}
	
	//@Test
	public void testUpdateBaby() throws Exception {
		Baby baby=new Baby();
		User user=new User();
		
		user.setuNo(100011);
		
		baby.setbNo(100006);
		baby.setbName("일섭수정");
		baby.setbBirth("2015-12-12");
		baby.setbSex(2);
		baby.setMom(user);
		
		babyService.updateBaby(baby);
	}
	
	//@Test
	public void testDeleteBaby() throws Exception {
		
		babyService.deleteBaby(100006);
	}
	
	//@Test
	public void testInsertBabyJson() throws Exception {
		HttpClient httpClient=new DefaultHttpClient();
		String url="http://127.0.0.1:8080/baby/json/addJsonBaby";
		
		HttpPost httpPost=new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		Baby baby=new Baby();
		User user=new User();
		user.setuNo(100006);
		
		baby.setbName("근한이바보");
		baby.setbBirth("1989-12-10");
		baby.setbNature("깜찍");
		baby.setbPhoto("img/image.jpg");
		baby.setbSex(1);
		baby.setbType("B");
		baby.setMom(user);
		
		ObjectMapper objMapper=new ObjectMapper();
		//JsonValue에 baby domain을 json Data 형식으로 변환
		String jsonValue=objMapper.writeValueAsString(baby);
		//httpEntity =>body에 jsonValue를 UTF-8 인코딩형식으로 넣는다.
		HttpEntity httpEntity=new StringEntity(jsonValue,"UTF-8");
		
		//httpPost에 body에 위에서 설정한 entity를 setting
		httpPost.setEntity(httpEntity);
		//Response 받는 header를 설정해줌
		HttpResponse httpResponse=httpClient.execute(httpPost);
		
		//entity에 response에서 받은 body 저장
		HttpEntity entity=httpResponse.getEntity();
		
		//Object로 들어오는 값을 읽을 수 있게 설정
		InputStream is=entity.getContent();
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		
		
		
		
		
	}
	
}

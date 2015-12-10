package com.dodam.common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import com.dodam.service.domain.Email;
import com.dodam.service.domain.User;

public class SendEmail {
	
	public SendEmail() {
		
	}
	
	public static void sendEmail(Email email,String authNum,User user) {
		String host="smtp.gmail.com";
		String subject="회원인증";
		String fromName="이근한";
		String from="dlrmsgks12@gmail.com";
		String to1=email.getMail();
		
		String content="<h1>DODAM DODAM</h1>"
				+"<br/>"+user.getNickname()+"님의 가입을 환영합니다!!"
				+"<br/>"+"가입완료를 원하시면 "
				+"<a href='http://192.168.1.4:8080/email/json/insertEmail"
				+ "?mail="+email.getMail()+"&code="+email.getAuthnum()+"&uNo="+email.getuNo()+"'>"+
					"인증 <a>"
				+"버튼을 눌러주세요!!";
		
		
		try{
			Properties props=new Properties();
			
			props.put("mail.smtp.starttls.enable", "ture");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);
			props.setProperty("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.port","465");
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.auth", "true");
			
			Session mailSession=Session.getInstance(props,
					new javax.mail.Authenticator(){
						protected PasswordAuthentication getPasswordAuthentication(){
							return new PasswordAuthentication("dlrmsgks12@gmail.com",
									"gpdus4fkd");
						}
			});
			
			mailSession.setDebug(true);
			Message message=new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(from,MimeUtility.encodeText(
					fromName,"UTF-8","B")));
			
			InternetAddress[] address1={new InternetAddress(to1)};
			message.setRecipients(Message.RecipientType.TO,address1);
			message.setSubject(subject);
			message.setSentDate(new java.util.Date());
			message.setContent(content,"text/html;charset=UTF-8");
			message.setReplyTo(InternetAddress.parse("no_reply@dodam.com", false));
			
			Transport.send(message);
			System.out.println("성공");
		}
		catch(MessagingException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

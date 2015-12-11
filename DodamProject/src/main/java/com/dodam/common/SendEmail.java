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
		String subject="Dodam 회원가입 이메일 인증";
		String fromName="Dodam";
		String from="projectdodam@gmail.com";
		String to1=email.getMail();
		
		String content="<h1>DODAM DODAM</h1>"
				+"<br/>"+user.getNickname()+"님 아래 링크를 클릭하시면 인증이 완료됩니다. <hr>"			
				+"<a href='http://127.0.0.1:8080/email/json/insertEmail"
				+ "?mail="+email.getMail()+"&code="+email.getAuthnum()+"&uNo="+email.getuNo()+"'>"
						+ "http://127.0.0.1:8080/email/json/insertEmail"
				+ "?mail="+email.getMail()+"&code="+email.getAuthnum()+"&uNo="+email.getuNo()+"</a>";
		
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
			
			//dlrmsgks12@gmail.com  gpdus4fkd
			// projectdodam@gmail.com qwer1234@
			Session mailSession=Session.getInstance(props,
					new javax.mail.Authenticator(){
						protected PasswordAuthentication getPasswordAuthentication(){
							return new PasswordAuthentication("projectdodam@gmail.com ",
									"qwer1234@");
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
			System.out.println("==sendEmail() success==");
		}
		catch(MessagingException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

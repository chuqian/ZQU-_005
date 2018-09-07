package com.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @ author : 李国鹏 @ datetime : 18-8-24 上午10:53
 */
public class MailUtil implements Runnable {

	private String email;
	private String code;

	public MailUtil(String email, String code) {
		this.email = email;
		this.code = code;
	} 

	public void run() {
		String from = "1241875397@qq.com";
		String host = "smtp.qq.com";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.auth", "true");

		try {
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf);

			Session session = Session.getDefaultInstance(properties, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("1241875397@qq.com", "rdykdkfriusjjgdc"); 
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("多野商城注册验证");
			String content = "<html><head></head><body><h1>此邮件是由多野商城官方邮箱发出，如您未注册多野商城请勿理会!</h1><h3> 注册验证码为: " + code + "</h3></body></html>";
			message.setContent(content, "text/html;charset=UTF-8");
			
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

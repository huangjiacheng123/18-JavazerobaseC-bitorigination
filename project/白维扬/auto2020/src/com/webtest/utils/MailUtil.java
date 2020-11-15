package com.webtest.utils;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	// 这里的email参数是toemail，要寄给谁，在config.properties文件配置，用逗号分隔开
	public static void sendEmail(String email, String subject, String body) throws IOException {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", ReadProperties.getPropertyValue("server"));
			props.put("mail.smtp.port", ReadProperties.getPropertyValue("port"));
			props.put("mail.smtp.auth", "true");
			Transport transport = null;
			Session session = Session.getDefaultInstance(props, null);
			transport = session.getTransport("smtp");
			transport.connect(ReadProperties.getPropertyValue("server"), ReadProperties.getPropertyValue("user"),
					ReadProperties.getPropertyValue("password"));
			MimeMessage msg = new MimeMessage(session);
			msg.setSentDate(new Date());

			InternetAddress fromAddress = new InternetAddress(ReadProperties.getPropertyValue("user"),
					ReadProperties.getPropertyValue("from"), "UTF-8");
			msg.setFrom(fromAddress);
			String emailList[] = email.split(",");
			InternetAddress[] toAddress = new InternetAddress[emailList.length];

			for (int i = 0; i < emailList.length; i++) {
				toAddress[i] = new InternetAddress(emailList[i]);
			}
			// msg.setRecipients(Message.RecipientType.TO, toAddress);
			msg.addRecipients(Message.RecipientType.TO, toAddress);
			msg.setSubject(subject, "UTF-8");
			msg.setContent(body, "text/html;charset=utf-8");
			msg.saveChanges();
			transport.sendMessage(msg, msg.getAllRecipients());
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws IOException {
		MailUtil.sendEmail("bai531813318@163.com", "xinhu", "23333333");
	}

}

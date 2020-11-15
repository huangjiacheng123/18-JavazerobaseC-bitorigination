package com.webtest.core;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.testng.ITestResult;

import com.webtest.utils.ReadProperties;

public class MailUtil {

//	private String sender = "test2014123@126.com"; // 邮箱地址
	private String sender; // 邮箱地址
//	private String auth_code = "VZWDRLIBCRCPABRM"; // 授权码
	private String auth_code; // 授权码
	private String to; // 接收人的邮箱
	private List<ITestResult> failList; // 失败的测试用例的集合
	private List<ITestResult> passList; // 成功的测试用例的集合

	public MailUtil() throws IOException {
		// TODO Auto-generated constructor stub
		this.sender = ReadProperties.getPropertyValue("sendermail");
		this.auth_code = ReadProperties.getPropertyValue("authorization_code");
		this.to = ReadProperties.getPropertyValue("tomail");
	}

	public void sendMail(String title, String body) throws UnsupportedEncodingException {
		try {
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", "smtp.126.com");
			props.put("mail.smtp.auth", true);

			// 1、构造Session对象（邮箱绘画对象），设置服务器、授权码，需要Properties
			Session session = Session.getInstance(props, new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(sender, auth_code);
				}

			});

			// 2、创建邮件，创建Message对象，子类MimeMessage
			// 创建发件人、收件人、主题、正文
			Message msg = new MimeMessage(session);

			msg.setSentDate(new Date());

			InternetAddress fromAddress = new InternetAddress(sender, "UTF-8");
			msg.setFrom(fromAddress);
			String[] emailList = to.split(",");
			InternetAddress[] toAddress = new InternetAddress[emailList.length];

			for (int i = 0; i < emailList.length; i++) {
				toAddress[i] = new InternetAddress(emailList[i]);
			}
			// msg.setRecipients(Message.RecipientType.TO, toAddress);
			msg.addRecipients(Message.RecipientType.TO, toAddress);
			msg.setSubject(title);
//			msg.setC
			msg.setContent("<p>测试报告如下：</p>", "text/html;charset=UTF-8");
			msg.setContent(body, "text/html;charset=UTF-8");
			msg.saveChanges();
			Transport.send(msg, msg.getAllRecipients());
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}

//public class MailUtil {
//
////	private String sender = "test2014123@126.com"; // 邮箱地址
//	private String sender; // 邮箱地址
////	private String auth_code = "VZWDRLIBCRCPABRM"; // 授权码
//	private String auth_code; // 授权码
//	private String to; // 接收人的邮箱
//	private List<ITestResult> failList; // 失败的测试用例的集合
//	private List<ITestResult> passList; // 成功的测试用例的集合
//
//	public MailUtil(List<ITestResult> failList, List<ITestResult> passList) throws IOException {
//		// TODO Auto-generated constructor stub
//		this.failList = failList;
//		this.passList = passList;
//		this.sender = ReadProperties.getPropertyValue("sendermail");
//		this.auth_code = ReadProperties.getPropertyValue("authorization_code");
//		this.to = ReadProperties.getPropertyValue("tomail");
//	}
//
//	public void sendMail() {
//		Properties props = new Properties();
//		props.put("mail.transport.protocol", "smtp");
//		props.put("mail.smtp.host", "smtp.126.com");
//		props.put("mail.smtp.auth", true);
//
//		// 1、构造Session对象（邮箱绘画对象），设置服务器、授权码，需要Properties
//		Session session = Session.getInstance(props, new Authenticator() {
//
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				// TODO Auto-generated method stub
//				return new PasswordAuthentication(sender, auth_code);
//			}
//
//		});
//
//		// 2、创建邮件，创建Message对象，子类MimeMessage
//		// 创建发件人、收件人、主题、正文
//		Message message = new MimeMessage(session);
//
//		try {
//			message.setFrom(new InternetAddress(sender));
//			// 多个接收账号
//			InternetAddress[] address = null;
//			try {
//				// 不能使用string类型的类型，这样只能发送一个收件人
//				List<InternetAddress> list = new ArrayList<InternetAddress>();
//				String[] median = to.split(","); // 对读取的多个邮件进行逗号分割
//				for (int i = 0; i < median.length; i++) {
//					list.add(new InternetAddress(median[i]));
//				}
//				address = (InternetAddress[]) list.toArray(new InternetAddress[list.size()]);
//
//			} catch (AddressException e) {
//				e.printStackTrace();
//			}
//
//			message.setSubject("hello,吴汶航");
//			String e1 = "失败的测试用例数目：" + this.failList.size();
//			String f0 = null, f1 = null, f2 = null;
//			for (int i = 0; i < failList.size(); i++) {
//				if (i == 0) {
//					ITestResult tr = this.failList.get(i);
//					f0 = tr.getInstanceName() + "：" + tr.getName() + "失败了！！！！";
//				} else if (i == 1) {
//					ITestResult tr = this.failList.get(i);
//					f1 = tr.getInstanceName() + "：" + tr.getName() + "失败了！！！！";
//				} else {
//					ITestResult tr = this.failList.get(i);
//					f2 = tr.getInstanceName() + "：" + tr.getName() + "失败了！！！！";
//				}
//
//			}
//			String e2 = "成功的测试用例数目：" + this.passList.size();
//			String p0 = null, p1 = null;
//			for (int i = 0; i < passList.size(); i++) {
//				if (i == 0) {
//					ITestResult tr = this.passList.get(i);
//					p0 = tr.getInstanceName() + "：" + tr.getName() + "成功了！！！！";
//				} else {
//					ITestResult tr = this.passList.get(i);
//					p1 = tr.getInstanceName() + "：" + tr.getName() + "成功了！！！！";
//				}
//				ITestResult tr = this.passList.get(i);
//				message.setText(tr.getInstanceName() + "：" + tr.getName() + "成功了！！！！");
//			}
//			message.setText(e1 + "\n" + f0 + "\n" + f1 + "\n" + f2 + "\n" + e2 + "\n" + p0 + "\n" + p1);
//
//			Transport.send(message, address);
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}

package com.webtest.core;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.webtest.utils.FreemarkerTemplateEngine;
import com.webtest.utils.Log;
import com.webtest.utils.MailUtil;
import com.webtest.utils.ReadProperties;

//监听器
public class WebTestListener extends TestListenerAdapter {
	FreemarkerTemplateEngine ft = new FreemarkerTemplateEngine();

	public WebTestListener() {
		super();
	}

	private String writeResultToMailTemplate() {
		// 获取testng里存储的用例信息，并且存储到list里面
		ITestNGMethod method[] = this.getAllTestMethods();
		List<ITestResult> failedList = this.getFailedTests();
		List<ITestResult> passedList = this.getPassedTests();
		List<ITestResult> failedList1 = new ArrayList<>();
		List<ITestResult> passedList1 = new ArrayList<>();
		for (int j = 0; j < failedList.size(); j++) {
			ITestResult tr = (ITestResult) failedList.get(j);
			for (int i = 0; i < method.length; i++) {
				if (tr.getMethod().getMethodName().equals(method[i].getMethodName())) {
					// 设置attribute，但是我觉得，可能比较啰嗦了
					// 一行代码
					// tr.setAttribute("name",
					// method[i].getDescription()!=null?method[i].getDescription():"");
					if (method[i].getDescription() != null) {
						tr.setAttribute("name", method[i].getDescription());
					} else {
						tr.setAttribute("name", "");
					}
					break;
				}
			}
			failedList1.add(tr);
		}
		for (int j = 0; j < passedList.size(); j++) {
			ITestResult tr = (ITestResult) passedList.get(j);
			for (int i = 0; i < method.length; i++) {
				if (tr.getMethod().getMethodName().equals(method[i].getMethodName())) {
					if (method[i].getDescription() != null) {
						tr.setAttribute("name", method[i].getDescription());
					} else {
						tr.setAttribute("name", "");
					}
					break;
				}
			}
			passedList1.add(tr);
		}
		// 这个Map没有设置泛型就离谱
		// 下面这个声明就可以，ojbect是所有类的公共祖先
		// Map<String, Object> context = new HashMap<>();
		Map<String, Object> context = new HashMap<>();
		context.put("date", new Date());
		context.put("failedList", failedList);
		context.put("passedList", passedList1);
		context.put("casesize", passedList.size() + failedList.size());
		context.put("failcasesize", failedList.size());
		try {
			// 调用FreemarkerTemplateEngine里的run方法，生成一个html代码，并且以String类型传过来，也就是html文件用记事本打开的内容，都是简单的标签
			String content = ft.run(context);
			return content;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
//		if (System.getProperty("os.name").contains("dow")) {
//			// return;
//		}
		try {
			if (ReadProperties.getPropertyValue("enable_email").equals("true")) {
				// 得到测试报告的String类型代码
				String emailContent = this.writeResultToMailTemplate();
				String emailTitle = ReadProperties.getPropertyValue("mail_title") + "----" + this.getTime();
				String toMail = ReadProperties.getPropertyValue("to_mail");
				try {
					if (this.getFailedTests() != null && this.getFailedTests().size() > 0) {
						MailUtil.sendEmail(toMail, emailTitle, emailContent);
						Log.info("email send to " + toMail + " success");
					} else {
						MailUtil.sendEmail(ReadProperties.getPropertyValue("success_to_mail"), emailTitle,
								emailContent);
						Log.info("email send to " + ReadProperties.getPropertyValue("success_to_mail") + " success");
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					Log.fatal("email send fail :" + e.getMessage());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getTime() {
		java.util.Calendar c = java.util.Calendar.getInstance();
		java.text.SimpleDateFormat f = new java.text.SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		return f.format(c.getTime());
	}
}

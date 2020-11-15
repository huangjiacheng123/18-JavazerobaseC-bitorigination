package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Testhomework extends BaseTest {
//	第一题
	@Test(priority = 0)
	public void testLogin() {
		webtest.open("http://www.roqisoft.com/zhsx/");
		webtest.click("link=登录");
		webtest.type("id=user", "baiwwwww");
		webtest.type("id=pw", "12345678");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("退出"));
	}

	@Test(priority = 1, dataProviderClass = NSDataProvider.class, dataProvider = "travel")
	public void testAddTravels(String firstTitel, String firstContent, String secondTitel, String secondContent)
			throws InterruptedException {
		webtest.open("http://www.roqisoft.com/zhsx/");
		webtest.mouseToElement("xpath=//strong[text()='我的空间']");
		Thread.sleep(1000);
		webtest.mouseToElementandClick("link=个人游记");
		Thread.sleep(2000);
		webtest.click("link=点我写游记");
		Thread.sleep(2000);
		webtest.type("id=title", firstTitel);
		webtest.tapClick();
		webtest.tapType(firstContent);
		webtest.click("xpath=//input[@value='发布文章']");
		Thread.sleep(2000);

		// 通过标题找
		webtest.click("link=" + firstTitel);
		webtest.typeAndClear("id=title", secondTitel);
		webtest.tapClick();
		// body标签里面的内容不能直接修改，typeAndClear不能使用
		webtest.tapType(secondContent);
		webtest.click("xpath=//input[@value='保存并返回']");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent(secondTitel));
	}

	@Test(priority = 2)
	public void testUploadPicture() throws InterruptedException {
		webtest.open("http://www.roqisoft.com/zhsx/");
		webtest.mouseToElement("xpath=//strong[text()='我的空间']");
		Thread.sleep(1000);
		webtest.mouseToElementandClick("link=个人相册");
		Thread.sleep(2000);
		webtest.click("xpath=//strong[text()='点击上传图片']");
		webtest.enterFrame1("xpath=//div[@id='FrameUpload']//iframe");
		webtest.type("xpath=//input[@type='file']", "F:\\s\\3.jpg");
		webtest.click("xpath=//div[@id='FrameUpload']//iframe//body");
		webtest.click("xpath=//input[@value='上传' ]");
		// 在webdriver.get前需要回到默认框架(窗口)
		webtest.leaveFrame();
	}

	@Test(priority = 3)
	public void testComment() throws InterruptedException {
		webtest.open("http://www.roqisoft.com/zhsx/blog");
		Thread.sleep(3000);
		// 始终访问第一个
		webtest.click("xpath=//a[text()='阅读全文']");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String nowDateTime = sdf.format(new Date());
		webtest.type("name=comment", "登录了再评价" + nowDateTime);
		webtest.click("xpath=//input[@name='submit']");
		Thread.sleep(3000);
	}

}

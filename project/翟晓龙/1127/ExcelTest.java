package com.webtest.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.fabric.xmlrpc.base.Data;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;

public class ExcelTest extends BaseTest{
	private static String block="xpath=//span[@pmenuid='19']";
	@Test(dataProvider = "excel",dataProviderClass = NSDataProvider.class)
	public void test(String s1,String s2,String s3,String s4) throws InterruptedException, IOException {
		load(block);
		webtest.click("id=menu_list_num135");
		webtest.click("xpath=//a[@oi='0' and @oj='0']");
		Thread.sleep(1000);
		webtest.click("xpath=//li[@temp='2']");
		Thread.sleep(1000);
		webtest.type("id=confirm_input",s1+s2+s3+s4);
		Thread.sleep(1000);
		webtest.click("id=confirm_btn1");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isTextPresent("处理成功"));
		
	}	
}	


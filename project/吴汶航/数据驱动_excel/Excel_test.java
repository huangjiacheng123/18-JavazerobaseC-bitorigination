package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Excel_test extends BaseTest{
	
	//������������½�������Ʒ����
	@Test(dataProvider = "xinhu_xingzheng", dataProviderClass = NSDataProvider.class)
	public void test_login(String s1, String s2, String s3) {
		//��½
		webtest.type("name=adminuser", s1);
		webtest.type("xpath=//input[@type='password']", s2);
		webtest.click("name=button");
		
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num28");
		webtest.click("id=menu_list_num30");
		webtest.click("xpath=//button[@click='clickwin,0']");

		webtest.enterFrame1("name=openinputiframe");

		webtest.type("name=name", s3);
		webtest.click("name=typeid");
		webtest.click("xpath=//option[text()='������']");
		webtest.click("name=unit");
		webtest.click("xpath=//option[@value='̨']");

		webtest.click("id=AltS");
		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("��������ɹ�"));
	}

}

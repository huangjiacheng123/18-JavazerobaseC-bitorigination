package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;

public class Demo1 extends BaseTest {

	// �����в��Է���ǰִ�У���¼�ź������л����ͻ�ģ��
	@BeforeMethod
	public void login() {
		webtest.open("http://localhost:7777/?m=login");
		webtest.clear("name=adminuser");
		webtest.type("name=adminuser", "admin");
		webtest.clear("xpath=//input[@type='password']");
		webtest.type("xpath=//input[@type='password']", "123456");
		webtest.click("name=button");
	}

	//ѡ��һ���ҵĿͻ������������������飬�������PV������༭��ɾ���û����ƣ�������棬��ʾ�û�������Ϊ��
	@Test
	public void test01() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.clear("name=name");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	
	//ѡ��һ���ҵĿͻ������������������飬�������PV������༭���޸��û����ƣ�������棬����ɹ�
	@Test
	public void test02() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.type("name=name","A");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		Thread.sleep(500);
	}

	// ѡ��һ���ҵĿͻ������������������飬�������PV������༭��ɾ����Դ��������棬��ʾ��Դ����Ϊ��
	@Test
	public void test03() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='-��ѡ��-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// ѡ��һ���ҵĿͻ������������������飬�������PV������༭���޸���Դ��������棬����ɹ�
	@Test
	public void test04() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='�绰����']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		Thread.sleep(500);
	}

	// ѡ��һ���ҵĿͻ������������������飬�������PV������༭��ɾ���û����ͣ�������棬��ʾ�û����Ͳ���Ϊ��
	@Test
	public void test05() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='-��ѡ��-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	
	// ѡ��һ���ҵĿͻ������������������飬�������PV������༭���޸Ŀͻ����ͣ�������棬����ɹ�
	@Test
	public void test06() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='���']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		Thread.sleep(500);
	}
	// ѡ��һ���ҵĿͻ������������������飬�������PV������༭��ɾ����ַ��������棬��ʾ��ַ����Ϊ��
	//�������ʧ���ˣ����Ǹ�bug
	@Test
	public void test07() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.clear("name=address");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		Thread.sleep(500);
	}	

	// ѡ��һ���ҵĿͻ������������������飬�������PV������༭���޸ĵ�ַ��������棬����ɹ�
	@Test
	public void test08() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.type("name=address","A");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		Thread.sleep(500);
	}	

	// ѡ��һ���ҵĿͻ������������������飬�������PV������༭��ɾ��״̬��������棬��ʾ״̬����Ϊ��
	@Test
	public void test09() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.click("name=status");
		webtest.click("xpath=//option[text()='-��ѡ��-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	
	//	ѡ��һ���ҵĿͻ������������������飬�������PV������༭���޸�״̬��������棬����ɹ�
	@Test
	public void test10() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.click("name=status");
		webtest.click("xpath=//option[text()='ͣ��']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ������������������飬�������PV������༭��ɾ���Ƿ��������棬��ʾ�Ƿ����Ϊ��
	@Test
	public void test11() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='-��ѡ��-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ������������������飬�������PV������༭���޸��Ƿ��������棬����ɹ�
	@Test
	public void test12() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='��']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ������������������飬�������PV�����ɾ�������ȡ��
	@Test
	public void test13() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='ɾ��...']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//a[text()='����V']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	// ����
	@Test
	public void test14() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' ����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='���Ͽ���']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='������']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='��������ɹ�']"));
		Thread.sleep(500);
	}
	
	//	ѡ��һ���ҵĿͻ������������������飬�������PV������ر�
	@Test
	public void test15() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		Thread.sleep(1000);
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�ر�']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='����Ա']"));
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ������������������飬�������PV�����ˢ��
	@Test	
	public void test16() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		Thread.sleep(1000);
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='ˢ��']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='����Ա']"));
		Thread.sleep(500);
	}
	
	//ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������༭��ɾ���û����ƣ�������棬��ʾ�û�������Ϊ��
	@Test	
	public void test17() throws InterruptedException {
		
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.clear("name=name");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	
	//ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������༭���޸��û����ƣ�������棬����ɹ�
	@Test
	public void test18() throws InterruptedException {
		
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		Thread.sleep(3500);
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.type("name=name","A");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		
		Thread.sleep(500);
	}

	// ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������༭��ɾ����Դ��������棬��ʾ��Դ����Ϊ��
	@Test
	public void test19() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='-��ѡ��-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������༭���޸���Դ��������棬����ɹ�
	@Test
	public void test20() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='�绰����']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������༭��ɾ���û����ͣ�������棬��ʾ�û����Ͳ���Ϊ��
	@Test
	public void test21() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='-��ѡ��-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	
	// ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������༭���޸Ŀͻ����ͣ�������棬����ɹ�
	@Test
	public void test22() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='���']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	// ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������༭��ɾ����ַ��������棬��ʾ��ַ����Ϊ��
	//�������ʧ���ˣ����Ǹ�bug
	@Test
	public void test23() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.clear("name=address");
		webtest.click("xpath=//input[@type='button']");
		Thread.sleep(3500);
		webtest.closeWindow();
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[text()='��ַ����Ϊ��']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}	

	// ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������༭���޸ĵ�ַ��������棬����ɹ�
	@Test
	public void test24() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.type("name=address","A");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}	

	// ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������༭��ɾ��״̬��������棬��ʾ״̬����Ϊ��
	@Test
	public void test25() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.exectueScript("name=status");
		webtest.click("name=status");
		webtest.click("xpath=//option[text()='-��ѡ��-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	
	//	ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������༭���޸�״̬��������棬����ɹ�
	@Test
	public void test26() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.exectueScript("name=status");
		webtest.click("name=status");
		webtest.click("xpath=//option[text()='ͣ��']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������༭��ɾ���Ƿ��������棬��ʾ�Ƿ����Ϊ��
	@Test
	public void test27() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.exectueScript("name=isstat");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='-��ѡ��-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������༭���޸��Ƿ��������棬����ɹ�
	@Test
	public void test28() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.exectueScript("name=isstat");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='��']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ�������������������(�´���)���������PV�����ɾ�������ȡ��
	@Test
	public void test29() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='ɾ��...']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		webtest.closeWindow();
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='����Ա']"));
		Thread.sleep(3500);
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ�������������������(�´���)���������PV�����ɾ�������ȷ����ɾ���ɹ�
	@Test
	public void test30() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='ɾ��...']");
		webtest.click("xpath=//button[@id='confirm_btn1']");
		Thread.sleep(3500);
		webtest.closeWindow();
		Thread.sleep(500);
		webtest.getWindow(0);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='����Ա']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ�������������������(�´���)���������PV������ر�
	@Test
	public void test31() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='�ر�']");
		webtest.closeWindow();
		webtest.getWindow(0);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='����Ա']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ�������������������(�´���)���������PV�����ˢ��
	@Test
	public void test32() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����(�´���)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='����V']");
		webtest.click("xpath=//li[text()='ˢ��']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//a[text()='����V']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ���������������+��Ӹ�����¼�����ȷ������ʾû������[+��Ӹ�����¼]˵��
	@Test
	public void test33() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����Ӹ�����¼']");
		webtest.click("xpath=//button[@type='button']");
		Thread.sleep(3500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//button[@type='button']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	
	//	ѡ��һ���ҵĿͻ���������������+��Ӹ�����¼�����ȡ��
	@Test
	public void test34() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����Ӹ�����¼']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='����Ա']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	//	ѡ��һ���ҵĿͻ���������������+��Ӹ�����¼����[+��Ӹ�����¼]˵�����������ݣ����ȷ������ʾ����ɹ�
	@Test
	public void test35() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����Ӹ�����¼']");
		webtest.type("xpath=//textarea[@id='confirm_input']","A");
		webtest.click("xpath=//button[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='����ɹ�']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	
	//	ѡ��һ���ҵĿͻ���������������ͣ�ã����ȷ������ʾû������[ͣ��]˵��
	@Test
	public void test36() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='ͣ��']");
		webtest.click("xpath=//button[@type='button']");
		Thread.sleep(3500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//button[@type='button']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ���������������ͣ�ã����ȡ��
	@Test
	public void test37() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='ͣ��']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='����Ա']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ���������������ͣ�ã���[ͣ��]˵�����������ݣ����ȷ������ʾ����ɹ�
	@Test
	public void test38() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='ͣ��']");
		webtest.type("xpath=//textarea[@id='confirm_input']","A");
		webtest.click("xpath=//button[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='����ɹ�']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ��������������������ȷ������ʾû������[���]˵��
	//���Ǹ�bug�����������Ϳ���
	@Test
	public void test39() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' ����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='���Ͽ���']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='������']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='���']");
		webtest.click("xpath=//button[@type='button']");
		Thread.sleep(3500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//button[@type='button']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ��������������������ȡ��
	@Test
	public void test40() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' ����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='���Ͽ���']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='������']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='���']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='����Ա']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ�������������������[���]˵�����������ݣ����ȷ������ʾ����ɹ�
	@Test
	public void test41() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' ����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='���Ͽ���']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='������']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='���']");
		webtest.type("xpath=//textarea[@id='confirm_input']","A");
		webtest.click("xpath=//button[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='����ɹ�']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ���������������ȡ�������ȷ������ʾû������[ȡ�����]˵��
	//���Ǹ�bug�����������Ϳ���
	@Test
	public void test42() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' ����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='���Ͽ���']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='������']");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='��']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='ȡ�����']");
		webtest.click("xpath=//button[@type='button']");
		Thread.sleep(3500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//button[@type='button']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ���������������ȡ�������ȡ��
	@Test
	public void test43() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' ����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='���Ͽ���']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='������']");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='��']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='ȡ�����']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='����Ա']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ���ҵĿͻ���������������ȡ������[ȡ�����]˵�����������ݣ����ȷ������ʾ����ɹ�
	@Test
	public void test44() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' ����']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='���Ͽ���']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='������']");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='��']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='ȡ�����']");
		webtest.type("xpath=//textarea[@id='confirm_input']","A");
		webtest.click("xpath=//button[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='����ɹ�']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ����ͣ�ÿͻ������������������ã����ȷ������ʾû������[����]˵��
	//���Ǹ�bug�����������Ϳ���
	@Test
	public void test45() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()='��ͣ�ÿͻ�']");
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.click("xpath=//button[@type='button']");
		Thread.sleep(3500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//button[@type='button']"));
		Thread.sleep(500);
	}
	//	ѡ��һ����ͣ�ÿͻ������������������ã����ȡ��
	@Test
	public void test46() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()='��ͣ�ÿͻ�']");
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='����Ա']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//	ѡ��һ����ͣ�ÿͻ������������������ã���[����]˵�����������ݣ����ȷ������ʾ����ɹ�
	@Test
	public void test47() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()='��ͣ�ÿͻ�']");
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='����']");
		webtest.type("xpath=//textarea[@id='confirm_input']","A");
		webtest.click("xpath=//button[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='����ɹ�']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	//	ѡ��һ���ҵĿͻ����������������༭
	@Test
	public void test48() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='�༭']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='�༭����ɹ�']"));
		
		Thread.sleep(500);
	}

	//	ѡ��һ���ҵĿͻ���������������ɾ�������ȡ��
	@Test
	public void test49() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='ɾ��']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='����Ա']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	//	ѡ��һ���ҵĿͻ���������������ɾ�������ȷ����ɾ���ɹ�
	@Test
	public void test50() throws InterruptedException {
		webtest.click("xpath=//span[text()='�ͻ�']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='����Ա']");
		webtest.click("xpath=//a[text()='����']");
		webtest.click("xpath=//li[text()='ɾ��']");
		webtest.type("xpath=//textarea[@id='confirm_input']","A");
		webtest.click("xpath=//button[@id='confirm_btn1']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='����ɹ�']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
////****************************************************************************************************
	
}

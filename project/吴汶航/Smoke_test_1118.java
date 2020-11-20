package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.freemarker.BaseTest;
import com.webtest.freemarker.WebTestListenerFreemarker;

@Listeners(WebTestListenerFreemarker.class)
public class Smoke_test_1118 extends BaseTest {

	@BeforeMethod
	public void open_Login() {
		webtest.open("?m=login");
		webtest.type("name=adminuser", "admin");
		webtest.type("xpath=//input[@type='password']", "123456");
		webtest.click("name=button");
	}

	// 1.�ɹ���½
	@Test(priority = 1)
	public void test_success_login() {
		webtest.open("?m=login");
		webtest.type("name=adminuser", "admin");
		webtest.type("xpath=//input[@type='password']", "123456");
		webtest.click("name=button");
		assertTrue(webtest.isTextPresent("  ��ҳ"));
	}

	// 2.��½ʧ�ܣ��û���δע��
	@Test(priority = 2)
	public void test_false_login() {
		webtest.open("?m=login");
		webtest.type("name=adminuser", "adminaaa");
		webtest.type("xpath=//input[@type='password']", "123456");
		webtest.click("name=button");
		assertTrue(webtest.isTextPresent("�û�������"));
	}

	// 3.��½ʧ�ܣ�����Ϊ��
	@Test(priority = 3)
	public void test_null_psw_login() {
		webtest.open("?m=login");
		webtest.type("name=adminuser", "admin");
		webtest.type("xpath=//input[@type='password']", "");
		webtest.click("name=button");
		assertTrue(webtest.isTextPresent("���벻��Ϊ��"));
	}

	// 4.��½ʧ�ܣ��������
	@Test(priority = 4)
	public void test_psw_false_login() {
		webtest.open("?m=login");
		webtest.type("name=adminuser", "admin");
		webtest.type("xpath=//input[@type='password']", "12345666");
		webtest.click("name=button");
		assertTrue(webtest.isTextPresent("���벻��"));
	}

	// 5.�����̶��ʲ�
	@Test(priority = 5)
	public void test_addSuccess_FixedAssets() {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//button[@click='adds']");

		webtest.enterFrame1("name=openinputiframe");

		webtest.click("id=div_typeid");
		webtest.click("xpath=//option[@value='207']");
		webtest.type("name=title", "����̨ʽ����");
		webtest.click("name=ckid");
		webtest.click("xpath=//option[text()='�ֿ�1']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[@value='����']");
		webtest.click("name=state");
		webtest.click("xpath=//option[@value='0']");
		webtest.click("id=AltS");
		webtest.leaveFrame();

		assertTrue(webtest.isTextPresent("��������ɹ�"));
	}

	// 6.�����̶��ʲ���δѡ���ʲ�����
	@Test(priority = 6)
	public void test_add_null_typeid_FixedAssets() {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//button[@click='adds']");

		webtest.enterFrame1("name=openinputiframe");

		webtest.click("id=div_typeid");
		webtest.click("xpath=//option[@value='']");
		webtest.type("name=title", "����̨ʽ����");
		webtest.click("name=ckid");
		webtest.click("xpath=//option[text()='�ֿ�1']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[@value='����']");
		webtest.click("name=state");
		webtest.click("xpath=//option[@value='0']");
		webtest.click("id=AltS");

		assertTrue(webtest.isTextPresent("�ʲ����಻��Ϊ��"));
		webtest.leaveFrame();
	}

	// 7.�����̶��ʲ���δ��������
	@Test(priority = 7)
	public void test_add_null_title_FixedAssets() {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//button[@click='adds']");

		webtest.enterFrame1("name=openinputiframe");

		webtest.click("id=div_typeid");
		webtest.click("xpath=//option[@value='207']");
		webtest.type("name=title", "");
		webtest.click("name=ckid");
		webtest.click("xpath=//option[text()='�ֿ�1']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[@value='����']");
		webtest.click("name=state");
		webtest.click("xpath=//option[@value='0']");
		webtest.click("id=AltS");

		assertTrue(webtest.isTextPresent("���Ʋ���Ϊ��"));
		webtest.leaveFrame();
	}

	// 8.�����̶��ʲ���δѡ���ʲ���Դ
	@Test(priority = 8)
	public void test_add_null_laiyuan_FixedAssets() {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//button[@click='adds']");

		webtest.enterFrame1("name=openinputiframe");

		webtest.click("id=div_typeid");
		webtest.click("xpath=//option[@value='207']");
		webtest.type("name=title", "����̨ʽ����");
		webtest.click("name=ckid");
		webtest.click("xpath=//option[text()='�ֿ�1']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[@value='']");
		webtest.click("name=state");
		webtest.click("xpath=//option[@value='0']");
		webtest.click("id=AltS");

		assertTrue(webtest.isTextPresent("�ʲ���Դ����Ϊ��"));
		webtest.leaveFrame();
	}

	// 9.�����̶��ʲ���δѡ��ֿ�
	@Test(priority = 9)
	public void test_add_null_ckid_FixedAssets() {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//button[@click='adds']");

		webtest.enterFrame1("name=openinputiframe");

		webtest.click("id=div_typeid");
		webtest.click("xpath=//option[@value='207']");
		webtest.type("name=title", "����̨ʽ����");
		webtest.click("name=ckid");
		webtest.click("xpath=//option[text()='-��ѡ��-']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[@value='����']");
		webtest.click("name=state");
		webtest.click("xpath=//option[@value='0']");
		webtest.click("id=AltS");

		assertTrue(webtest.isTextPresent("��Ųֿⲻ��Ϊ��"));
		webtest.leaveFrame();
	}

	// 10.�����̶��ʲ���δѡ��״̬
	@Test(priority = 10)
	public void test_add_null_state_FixedAssets() {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//button[@click='adds']");

		webtest.enterFrame1("name=openinputiframe");

		webtest.click("id=div_typeid");
		webtest.click("xpath=//option[@value='207']");
		webtest.type("name=title", "����̨ʽ����");
		webtest.click("name=ckid");
		webtest.click("xpath=//option[text()='�ֿ�1']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[@value='����']");
		webtest.click("id=div_state");
		webtest.click("xpath=//option[text()='-��ѡ��-']");
		webtest.click("id=AltS");

		assertTrue(webtest.isTextPresent("״̬����Ϊ��"));
		webtest.leaveFrame();
	}

	// 11.�����̶��ʲ���δ�����κ���Ϣ
	@Test(priority = 11)
	public void test_add_null_all_FixedAssets() {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//button[@click='adds']");

		webtest.enterFrame1("name=openinputiframe");

		webtest.click("id=div_typeid");
		webtest.click("xpath=//option[@value='']");
		webtest.type("name=title", "");
		webtest.click("name=ckid");
		webtest.click("xpath=//option[text()='-��ѡ��-']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[@value='']");
		webtest.click("id=div_state");
		webtest.click("xpath=//option[text()='']");
		webtest.click("id=AltS");
		webtest.leaveFrame();

		assertTrue(webtest.isTextPresent("�ʲ����಻��Ϊ��"));
	}

	// 12.�̶��ʲ����������ʲ�����
	@Test(priority = 12)
	public void test_details_FixedAssets() {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[text()='����']");

		webtest.click("xpath=//li[text()='����']");
		assertTrue(webtest.isTextPresent("����"));
	}

	// 13.�̶��ʲ����������ʲ����飨�´��ڣ�
	@Test(priority = 13)
	public void test_details_newWindow_FixedAssets() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[text()='����']");

		webtest.click("xpath=//li[text()='����(�´���)']");
		Thread.sleep(1000);
//		��λ�´���
		webtest.getWindow(1);
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("���ļ�¼"));
		webtest.getWindow(0);
	}

	// 14.�̶��ʲ������������õǼ�
	@Test(priority = 14)
	public void test_recipients_FixedAssets() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[text()='����']");

		webtest.click("xpath=//li[text()='���õǼ�']");
		webtest.type("id=confirm_input", "���õǼ�˵��");
		Thread.sleep(1000);
		webtest.click("id=confirm_btn1");

		assertTrue(webtest.isTextPresent("����ɹ�"));
	}

	// 15.�̶��ʲ���������ά�޵Ǽ�
	@Test(priority = 15)
	public void test_maintenance_FixedAssets() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[text()='����']");

		webtest.click("xpath=//li[text()='ά�޵Ǽ�']");
		webtest.type("id=confirm_input", "ά�޵Ǽ�˵��");
		Thread.sleep(1000);
		webtest.click("id=confirm_btn1");

		assertTrue(webtest.isTextPresent("����ɹ�"));
	}

	// 16.�̶��ʲ�������������
	@Test(priority = 16)
	public void test_comments_FixedAssets() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[text()='����']");

		webtest.click("xpath=//li[text()='����']");
		webtest.type("id=confirm_input", "�ҵ�����˵��");
		Thread.sleep(1000);
		webtest.click("id=confirm_btn1");

		assertTrue(webtest.isTextPresent("����ɹ�"));
	}

	// 17.�̶��ʲ���������ɾ������ɾ��˵����
	@Test(priority = 17)
	public void test_delete_instructions_FixedAssets() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[text()='����']");

		webtest.click("xpath=//li[text()='ɾ��']");
		webtest.type("id=confirm_input", "�ҵ�ɾ��˵��");
		Thread.sleep(1000);
		webtest.click("id=confirm_btn1");

		assertTrue(webtest.isTextPresent("����ɹ�"));
	}

	// 18.�̶��ʲ���������ɾ������ɾ��˵����
	@Test(priority = 18)
	public void test_delete_null_noInstructions_FixedAssets() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[text()='����']");

		webtest.click("xpath=//li[text()='ɾ��']");
		Thread.sleep(1000);
		webtest.click("id=confirm_btn1");

		assertTrue(webtest.isTextPresent("����ɹ�"));
	}

	// 19.�̶��ʲ���������������ѣ��ɹ���
	@Test(priority = 19)
	public void test_add_reminder_success_FixedAssets() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[text()='����']");
		String str = webtest.getText("xpath=//li[@temp='5']");
		webtest.click("xpath=//li[@temp='5']");

		webtest.enterFrame1("name=openinputiframe");
		webtest.click("name=rave_pinlvs2");
		webtest.click("xpath=//td[text()='28']");
		webtest.click("xpath=//a[text()='ȷ��']");
		webtest.click("name=ratecont");
		Thread.sleep(1000);
		webtest.click("id=AltS");
		webtest.switchToDefault();
		if (str.equals("�������ñ༭")) {
			assertTrue(webtest.isTextPresent("�༭����ɹ�"));
		} else {
			assertTrue(webtest.isTextPresent("��������ɹ�"));
		}
	}

	// 20.�̶��ʲ���������������ѣ�ʧ�ܣ�
	@Test(priority = 20)
	public void test_add_reminder_false_FixedAssets() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[text()='����']");

		String str = webtest.getText("xpath=//li[@temp='5']");
		webtest.click("xpath=//li[@temp='5']");
		webtest.enterFrame1("name=openinputiframe");
		if (str.equals("�������ñ༭")) {
			webtest.click("name=rave_pinlvs2");
			webtest.click("xpath=//a[text()='���']");
			webtest.click("name=ratecont");
		}
		Thread.sleep(1000);
		webtest.click("id=AltS");
		assertTrue(webtest.isTextPresent("����Ƶ�ʲ���Ϊ��"));
		webtest.switchToDefault();
	}

	// 21.����ʲ�����1
	@Test(priority = 21)
	public void test_add_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[@title='����']");
		webtest.type("name=name", "����Air15");
		webtest.click("name=sort");
		webtest.click("xpath=//button[starts-with(@id,'save')]");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("����ɹ�"));
	}

	// 21.����ʲ�����2
	@Test(priority = 21)
	public void test_add2_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[@title='����']");
		webtest.type("name=name", "����Air152");
		webtest.click("name=sort");
		webtest.click("xpath=//button[starts-with(@id,'save')]");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("����ɹ�"));
	}

	// 22.����ʲ����ࣨδ�������ƣ�
	@Test(priority = 22)
	public void test_add_noName_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[@title='����']");
		webtest.type("name=name", "");
		webtest.click("name=sort");
		webtest.click("xpath=//button[starts-with(@id,'save')]");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("���Ʋ���Ϊ��"));
	}

	// 23.����ʲ����ࣨ�����ظ����ƣ�
	@Test(priority = 23)
	public void test_add_doublename_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[@title='����']");
		webtest.type("name=name", "����Air15");
		webtest.click("name=sort");
		webtest.click("xpath=//button[starts-with(@id,'save')]");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("���Ʋ����ظ�"));
	}

	// 24.�޸��ʲ���������
	@Test(priority = 24)
	public void test_modify_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//ul[@oi='0']");
		webtest.click("xpath=//a[@title='�༭']");
		webtest.type("name=name", "����С��");
		webtest.click("name=sort");
		webtest.click("xpath=//button[starts-with(@id,'save')]");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("����ɹ�"));
	}

	// 25.�޸��ʲ��������ƣ������ظ����ƣ�
	@Test(priority = 25)
	public void test_modify_doublename_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//ul[@oi='0']");
		webtest.click("xpath=//a[@title='�༭']");
		webtest.type("name=name", "����");
		webtest.click("name=sort");
		webtest.click("xpath=//button[starts-with(@id,'save')]");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("���Ʋ����ظ�"));
	}

	// 26.�޸��ʲ��������ƣ�δѡ����ࣩ
	@Test(priority = 26)
	public void test_modify_noChoseName_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[@title='�༭']");
		webtest.type("name=name", "����");
		webtest.click("name=sort");
		webtest.click("xpath=//button[starts-with(@id,'save')]");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("��ѡ�����"));
	}

	// 27.ɾ���ʲ���������
	@Test(priority = 27)
	public void test_delete_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//ul[@oi='7']");
		webtest.click("xpath=//a[@title='ɾ��']");
		webtest.click("id=confirm_btn1");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("ɾ���ɹ�"));
	}

	// 28.ɾ���ʲ����ࣨδѡ����ࣩ
	@Test(priority = 28)
	public void test_delete_noChoseName_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[@title='ɾ��']");
		webtest.click("id=confirm_btn1");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("��ѡ�����"));
	}

	// 29.ɾ���ʲ��������ƣ����¼����ࣩ
	@Test(priority = 29)
	public void test_delete_haveSun_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//ul[@oi='6']");
		webtest.click("xpath=//a[@title='ɾ��']");
		webtest.click("id=confirm_btn1");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("���¼����಻����ɾ��"));
	}

	// 30.�ƶ��ʲ�����
	@Test(priority = 30)
	public void test_mobile_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//ul[@oi='8']");
		webtest.click("xpath=//a[@title='�ƶ�']");
		webtest.click("xpath=//ul[@oi='7']");
		webtest.click("id=confirm_btn1");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("�ƶ��ɹ�"));
	}

	// 31.�ƶ��ʲ����ࣨδѡ����Ҫ�ƶ����ࣩ
	@Test(priority = 31)
	public void test_mobile_noChose_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[@title='�ƶ�']");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("û��ѡ����"));
	}

	// 32.�ƶ��ʲ����ࣨδѡ���ƶ����ĸ�����֮�£�
	@Test(priority = 32)
	public void test_mobile_noChose5_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//ul[@oi='7']");
		webtest.click("xpath=//a[@title='�ƶ�']");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("����5����ѡ����������ȷ���ƶ�"));
	}

	// 33.�ƶ��ʲ����ࣨ�ƶ����Լ����¼���
	@Test(priority = 33)
	public void test_mobile_myDown_classification() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//ul[@oi='6']");
		webtest.click("xpath=//a[@title='�ƶ�']");
		webtest.click("xpath=//ul[@oi='2']");
		webtest.click("id=confirm_btn1");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("�����ƶ����Լ����¼�"));
	}

	// 34.�ƶ��ʲ����ൽ����
	@Test(priority = 34)
	public void test_mobile_classification_toUp() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//ul[@oi='8']");
		webtest.click("xpath=//a[@title='�ƶ�������']");
		webtest.click("id=confirm_btn1");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("�ƶ��ɹ�"));
	}

	// 35.�ƶ��ʲ����ൽ������δѡ����Ҫ�ƶ����ࣩ
	@Test(priority = 35)
	public void test_mobile_noChose_classification_toUp() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//a[@title='�ƶ�������']");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("û��ѡ����"));
	}

	// 36.�ƶ��ʲ����ൽ�������Ѿ�Ϊ�������ࣩ
	@Test(priority = 36)
	public void test_mobile_choseUp_classification_toUp() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num137");
		webtest.click("xpath=//ul[@oi='0']");
		webtest.click("xpath=//a[@title='�ƶ�������']");
		webtest.click("id=confirm_btn1");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("�Ѿ�Ϊ��������"));
	}

	// 37.��������Ԥ��
	@Test(priority = 37)
	public void test_reservation_add_success() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		webtest.click("xpath=//button[starts-with(@id,'addbtn')]");

		webtest.enterFrame1("name=openinputiframe");

		webtest.click("id=btnchange_usename");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "��Ŀ����");
		Thread.sleep(1000);
		webtest.mouseToElementandClick("xpath=//input[contains(@name,'soukey')]");
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);
		webtest.click("name=startdt");
		webtest.click("xpath=//td[text()='27']");
		webtest.click("xpath=//a[text()='ȷ��']");
		webtest.click("name=enddt");
		webtest.click("xpath=//td[text()='28']");
		webtest.click("xpath=//a[text()='ȷ��']");
		webtest.type("name=address", "Ŀ�ĵ�");
		webtest.type("name=xianlines", "��·");
		Thread.sleep(1000);
		webtest.click("xpath=//span[@id='div_carnum']/table/tbody/tr/td[2]/a");
		webtest.click("xpath=//input[@value='2']");
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		webtest.click("id=btnchange_jianame");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "�߼�����Ա");
		Thread.sleep(1000);
		webtest.mouseToElementandClick("xpath=//input[contains(@name,'soukey')]");
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(1000);
		webtest.click("id=AltS");

		webtest.leaveFrame();
		assertTrue(webtest.isTextPresent("��������ɹ�"));

	}

	// 38.������״̬��������Ԥ����ѯ������������
	@Test(priority = 38)
	public void test_car_reservation_operation_details() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			webtest.click("xpath=//li[@temp='0']");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("����Ԥ��"));
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}
	}

	// 39.������״̬��������Ԥ����ѯ�����������飨�´��ڣ�
	@Test(priority = 39)
	public void test_car_reservation_operation_details_newWindow() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			webtest.click("xpath=//li[@temp='1']");
			webtest.getWindow(1);
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("���ļ�¼"));
			webtest.getWindow(0);
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}
	}

	// 40.������״̬��������Ԥ����ѯ��������׷��˵��
	@Test(priority = 40)
	public void test_car_reservation_operation_additional() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			webtest.click("xpath=//li[@temp='2']");
			webtest.type("id=confirm_input", "��ӵ�׷��˵��");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("����ɹ�"));
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}
	}

	// 41.������״̬��������Ԥ����ѯ��������׷��˵����δ���룩
	@Test(priority = 41)
	public void test_car_reservation_operation_noAdditional() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			webtest.click("xpath=//li[@temp='2']");
			webtest.type("id=confirm_input", "");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("û������[׷��˵��...]˵��"));
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}
	}

	// 42.������״̬��������Ԥ����ѯ���������߰�
	@Test(priority = 42)
	public void test_car_reservation_operation_cuiBan() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			webtest.click("xpath=//li[@temp='4']");
			webtest.type("id=confirm_input", "�߰�˵��");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("����ɹ�"));
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}
	}

	// 43.������״̬��������Ԥ����ѯ���������߰죨δ���룩
	@Test(priority = 43)
	public void test_car_reservation_operation_noCuiBan() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			webtest.click("xpath=//li[@temp='4']");
			webtest.type("id=confirm_input", "");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("û������[�߰�...]˵��"));
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}
	}

	// 44.������״̬��������Ԥ����ѯ������������
	@Test(priority = 44)
	public void test_car_reservation_operation_comments() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			webtest.click("xpath=//li[@temp='5']");
			webtest.type("id=confirm_input", "�ҵ�����");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("����ɹ�"));
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}
	}

	// 45.������״̬��������Ԥ����ѯ�����������ۣ�δ���룩
	@Test(priority = 45)
	public void test_car_reservation_operation_noComments() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			webtest.click("xpath=//li[@temp='5']");
			webtest.type("id=confirm_input", "");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("û������[����]˵��"));
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}
	}

	// 46.������״̬��������Ԥ����ѯ���������������
	@Test(priority = 46)
	public void test_car_reservation_operation_addRemind() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			String str2 = webtest.getText("xpath=//li[@temp='6']");
			webtest.click("xpath=//li[@temp='6']");
			webtest.enterFrame1("name=openinputiframe");
			webtest.click("name=rave_pinlvs2");
			webtest.click("xpath=//td[text()='28']");
			webtest.click("xpath=//a[text()='ȷ��']");
			webtest.click("name=ratecont");
			Thread.sleep(1000);
			webtest.click("id=AltS");
			webtest.leaveFrame();
			if (str2.equals("�������ñ༭")) {
				assertTrue(webtest.isTextPresent("�༭����ɹ�"));
			} else {
				assertTrue(webtest.isTextPresent("��������ɹ�"));
			}
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}
	}

	// 47.������״̬��������Ԥ����ѯ���������������
	@Test(priority = 47)
	public void test_car_reservation_operation_addRemind_noPinLv() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			String str2 = webtest.getText("xpath=//li[@temp='6']");
			webtest.click("xpath=//li[@temp='6']");
			webtest.enterFrame1("name=openinputiframe");
			if (str2.equals("�������ñ༭")) {
				webtest.click("name=rave_pinlvs2");
				webtest.click("xpath=//a[text()='���']");
				webtest.click("name=ratecont");
			}
			Thread.sleep(1000);
			webtest.click("id=AltS");
			assertTrue(webtest.isTextPresent("����Ƶ�ʲ���Ϊ��"));
			webtest.leaveFrame();
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}

	}

	// 48.������״̬��������Ԥ����ѯ���������༭
	@Test(priority = 48)
	public void test_car_reservation_operation_editor() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			webtest.click("xpath=//li[@temp='7']");
			webtest.enterFrame1("name=openinputiframe");
			webtest.click("id=AltS");
			webtest.leaveFrame();
			assertTrue(webtest.isTextPresent("�༭����ɹ�"));
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}
	}

	// 49.������״̬��������Ԥ����ѯ���������������루δ���룩
	@Test(priority = 49)
	public void test_car_reservation_operation_noInvalid() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			webtest.click("xpath=//li[@temp='3']");
			webtest.type("id=confirm_input", "");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("û������[��������...]˵��"));
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}
	}

	// 50.������״̬��������Ԥ����ѯ����������������
	@Test(priority = 50)
	public void test_car_reservation_operation_invalid() throws InterruptedException {
		webtest.click("xpath=//span[text()='����']");
		webtest.click("id=menu_list_num138");
		webtest.click("id=menu_list_num144");
		String str = webtest.getText("xpath=//font[text()='������']");
		if (str.equals("������")) {
			webtest.click("xpath=//a[text()='����']");
			webtest.click("xpath=//li[@temp='3']");
			webtest.type("id=confirm_input", "��ӵ���������");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("����ɹ�"));
		} else {
			System.out.println("The operation was not found !");
			assertTrue(false);
		}
	}

}

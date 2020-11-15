package com.webtest.core;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;

/**
 * author:lihuanzhen
 *
 */

public class BaseTest {

	public WebDriverEngine webtest;
	private WebDriver driver;
	public String driverType;

	private WebDriver newWebDriver(String driverType) throws IOException {
		WebDriver driver = null;
		if (driverType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "/Users/baiweiyang/libs/chromedriver");
			driver = new ChromeDriver();

			Log.info("Using Firefox");
		} else if (driverType.equalsIgnoreCase("chrome")) {
			String chrome_path = ReadProperties.getPropertyValue("chrome_path");
			System.setProperty("webdriver.chrome.driver", chrome_path);
			driver = new ChromeDriver();
			Log.info("Using Chrome");

		} else {
			return null;
		}

		return driver;

	}

	/**
	 * 
	 * ��ʼ�������
	 * 
	 */

	@BeforeClass
	public void doBeforeClass() throws Exception {

		driverType = ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		// 窗口最大化
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);

	}

	@AfterClass
	public void doAfterMethod() {
		if (this.driver != null) {
			this.driver.quit();
		}
		Log.info("Quitted Browser");
	}

	public WebDriver getDriver() {
		return driver;
	}

}

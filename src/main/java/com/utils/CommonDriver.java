package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonDriver {

	private WebDriver driver;

	private int pageLoadTimeout;

	private int elementDetectionTimeout;

	public CommonDriver(String browserType) throws Exception {
		pageLoadTimeout = 10;
		elementDetectionTimeout = 10;

		if (browserType.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\RAJKMURU\\Downloads\\chromedriver-win64\\chromedriver-win64");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserType.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid browser type : " + browserType);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	public void navigateToUrl(String url) {
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		driver.get(url);
	}

	public void closeAllBrowser(WebDriver driver) { 
		  driver.quit(); 
	}
	 
}

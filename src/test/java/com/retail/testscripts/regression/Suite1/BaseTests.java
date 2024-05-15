package com.retail.testscripts.regression.Suite1;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.utils.CommonDriver;
import com.utils.ReportUtils;
import com.utils.ScreenShotUtils;
import com.utils.configUtils;

public class BaseTests {
	
	WebDriver driver;
	
	String url;
	
	CommonDriver cmdriver;
	
	ReportUtils reportUtils;
	
	ScreenShotUtils screenshot;
	
	String currentWorkingDirectory;
	
	String configFileName;
	
	Properties configProperty;
	
	String reportFileName;
	
	
	@BeforeSuite
	public void preSetUp() throws Exception {
		currentWorkingDirectory = System.getProperty("user.dir");
		configFileName = currentWorkingDirectory + "\\src\\main\\resources\\config\\login.properties";
		reportFileName = currentWorkingDirectory + "\\reports\\AutomationReports.html";
		configProperty = configUtils.readProperties(configFileName);
		reportUtils = new ReportUtils(reportFileName);
	}
	
	@BeforeClass
	public void setup() throws Exception {
		String browserType = configProperty.getProperty("browsertype");
		cmdriver = new CommonDriver(browserType);
		driver = cmdriver.getDriver();
		screenshot = new ScreenShotUtils(driver);
		
		url = configProperty.getProperty("baseurl");
		cmdriver.navigateToUrl(url);
	}
	
	@AfterMethod
	public void postTestAction(ITestResult result) throws Exception {
		String testcasename = result.getName();
		long executionTime = System.currentTimeMillis();
		
		String screenshotFileName = currentWorkingDirectory + "\\screenshots\\" + testcasename +
				executionTime + ".jpeg";
		
		if(result.getStatus() == ITestResult.FAILURE) {
			reportUtils.addTestLog(Status.FAIL, "One or more steps failed");
			
			screenshot.CaptureAndSaveScreenshot(screenshotFileName);
			reportUtils.attachScreenShotToReports(screenshotFileName);
		}
	}
	
	@AfterClass
	public void tearDown() {
		cmdriver.closeAllBrowser(driver);
	}
	
	@AfterSuite
	public void closeReport() {
		reportUtils.flushReport();
	}
	

}

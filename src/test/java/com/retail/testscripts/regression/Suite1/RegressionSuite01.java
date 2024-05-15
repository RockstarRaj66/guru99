package com.retail.testscripts.regression.Suite1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.guru99.pages.LoginPage;
import com.guru99.utils.CommonUtils;



public class RegressionSuite01 extends BaseTests {
	
	String username;
	String password;
	
	
	public void Testsetup() { 
	   username = configProperty.getProperty("username");
	   password = configProperty.getProperty("password"); 
	}
	 
	
	
	@Test()
	public void verifyUserLoginWithCorrectCredentials() {
		reportUtils.createATestCase("Verify user Login with correct credentials");
		username = configProperty.getProperty("username");
		password = configProperty.getProperty("password"); 
		String expectedTitle = "Guru99 Bank Manager Home page";
		
		
		  LoginPage loginPage = new LoginPage(driver);
		  reportUtils.addTestLog(Status.INFO, "Performing Login");
		  loginPage.loginToGuru99(username, password);
		  
		  String actualTitle = CommonUtils.getTitle(driver);
		  reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");
		  Assert.assertEquals(actualTitle, expectedTitle);
		 
	}
}

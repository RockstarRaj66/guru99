package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.utils.CommonUtils;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name="uid")
	private WebElement userId;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="btnLogin")
	private WebElement login;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void loginToGuru99(String username, String pass) {
		CommonUtils.setText(userId, username);
		CommonUtils.setText(password, pass);
		CommonUtils.clickElement(login);
	}

}

package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.guru99.utils.CommonUtils;

public class HomePage extends LoadableComponent<HomePage> {
	
	private String appUrl;
	private WebDriver driver;
	private boolean isPageLoaded;
	
	@FindBy(css = ".main-home-banner")
	WebElement homeBanner;
	
	@FindBy(css = ".cart_text")
	WebElement cartText;
	
	public HomePage(WebDriver driver, String url) {
		appUrl = url;
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		isPageLoaded = true;
		driver.get(appUrl);
	}

	@Override
	protected void isLoaded() throws Error {
		
		if(!isPageLoaded)
			Assert.fail();
		
		if(isPageLoaded & CommonUtils.waitForElement(driver, homeBanner, 3)) {
			
		}
	}
	
	/**
	 * Verify cart text in home page 
	 * @return - boolean
	 */
	public boolean verifyCartText() {
		boolean status = false;
		if(cartText.getText().trim().equals("Cart"))
			status = true;
		
		return status;
	}
	
}

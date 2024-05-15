package com.guru99.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

	public static boolean waitForElement(WebDriver driver, WebElement element, int maxWait) {
		boolean statusOfElementToBeReturned = false;
		WebDriverWait wait = new WebDriverWait(driver, maxWait);

		try {
			WebElement waitElement = wait.until(ExpectedConditions.visibilityOf(element));
			if(waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfElementToBeReturned = true;
			}

		} catch (Exception ex) {
			statusOfElementToBeReturned = false;
		}

		return statusOfElementToBeReturned;
	}
	
	public static void clickElement(WebElement element) {
		element.click();
	}
	
	public static void clear(WebElement element) {
		element.clear();
	}
	
	public static boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public static void setText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

}

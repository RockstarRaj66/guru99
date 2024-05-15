package com.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtils {
	
	private TakesScreenshot screenshot;
	
	public ScreenShotUtils(WebDriver driver) {
		screenshot = (TakesScreenshot) driver;
	}
	
	public void CaptureAndSaveScreenshot(String filename) throws Exception {
		filename = filename.trim();
		
		File imgFile, tempFile;
		imgFile = new File(filename);
		
		if(imgFile.exists()) {
			throw new Exception("File already exist");
		}
		
		tempFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tempFile, imgFile);
		
	}

}

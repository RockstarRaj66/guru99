package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {
	
	ExtentSparkReporter extentSparkReporter ;
	
	ExtentReports extentReports;
	
	ExtentTest extentTest;
	
	public ReportUtils(String htmlReportFileName) {
		extentSparkReporter = new ExtentSparkReporter(htmlReportFileName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}
	
	public void createATestCase(String testcaseName) {
		extentTest = extentReports.createTest(testcaseName);
	}
	
	public void attachScreenShotToReports(String filename) {
		extentTest.addScreenCaptureFromPath(filename);
	}
	
	public void addTestLog(Status status, String comment) {
		extentTest.log(status, comment);
	}
	
	public void flushReport() {
		extentReports.flush();
	}

}

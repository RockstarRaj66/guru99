package com.retail.testscripts.regression.Suite1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import io.github.bonigarcia.wdm.WebDriverManager;


public class EventListenerSample extends BaseTests {

public static void main(String[] args) {
		
	    WebDriver webdriver;
	    WebDriverManager.chromedriver().setup();
		 webdriver = new ChromeDriver();
		
		WebDriverListener listener = new MyListener();
		WebDriver driver = new EventFiringDecorator<WebDriver>(listener).decorate(webdriver);
 
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.id("identifierId")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("password");
		driver.quit();
		
	}
}

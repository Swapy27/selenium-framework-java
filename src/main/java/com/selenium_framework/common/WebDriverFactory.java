package com.selenium_framework.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

	private static WebDriver dr;
	public static void createWebdriverInstance(){
		System.setProperty("webdriver.chrome.driver", "c:\\Selenium\\Chromedriver.exe");
		dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	public static WebDriver getDriver(){
		return dr;
	}
}

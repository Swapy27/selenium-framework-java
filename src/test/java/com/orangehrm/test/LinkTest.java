package com.orangehrm.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LinkTest {

	@Test
	public static void VerifyLink() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "c:\\Selenium\\Chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login");
		dr.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		dr.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		dr.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		dr.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		
		String ohandle=dr.getWindowHandle();
		Set<String>allHandles=dr.getWindowHandles();
		Iterator<String> itr=allHandles.iterator();
		
		while (itr.hasNext())
		{
			String currentHandle=itr.next();
			if (!ohandle.contentEquals(currentHandle))
			{
				dr.switchTo().window(currentHandle);
				System.out.println(dr.getTitle());
				dr.close();	
			}
			dr.switchTo().window(ohandle);
			//System.out.println(dr.getTitle());
			//dr.quit();
		}
		
	}
}

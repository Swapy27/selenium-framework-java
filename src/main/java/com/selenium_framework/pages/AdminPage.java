package com.selenium_framework.pages;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_framework.common.WebDriverFactory;

public class AdminPage {
	@FindBy (id="btnAdd")
	private WebElement addUserButton;
	
	public AdminPage(){
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	public AddUserPage navigateToAddUserPage(){
		addUserButton.click();
		return new AddUserPage();
	}
	
	public AdminPage verifyUserInUserTable(){
		WebDriver dr = WebDriverFactory.getDriver();
		WebElement table = dr.findElement(By.xpath("//table[@id='resultTable']/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Iterator<WebElement> itr = rows.iterator();
		
		while(itr.hasNext()){
			String name = itr.next().findElement(By.xpath(".//td[2]/a")).getText();
			if(name.contentEquals("amol1234")){
				Assert.assertTrue(true);
				return this;
			}
		}
		Assert.assertTrue(false);
		return this;
		
	}
}

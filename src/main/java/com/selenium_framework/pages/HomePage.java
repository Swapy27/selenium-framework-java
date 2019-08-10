package com.selenium_framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium_framework.common.WebDriverFactory;

public class HomePage {

	@FindBy (id="Welcome")
	private WebElement WelcomeText;
	@FindBy (id="menu_admin_viewAdminModule")
	private WebElement adminTab;


public HomePage(){
	PageFactory.initElements(WebDriverFactory.getDriver(), this);
}

public HomePage VerifyAdminLinkIsGettingDisplayed(){
	System.out.println(WelcomeText.isDisplayed());
	Assert.assertEquals(WelcomeText.isDisplayed(), true);
	Assert.assertEquals(WelcomeText.getText(), "Welcome Admin");
	return this;
}

public AdminPage navigateToAdminPage(){
	adminTab.click();
	return new AdminPage();
}
public HomePage IsPageLoaded(){
	Assert.assertTrue(WelcomeText.isDisplayed(),"username not loaded");
	Assert.assertTrue(WelcomeText.isDisplayed(),"username not loaded");
	return this;
}


}

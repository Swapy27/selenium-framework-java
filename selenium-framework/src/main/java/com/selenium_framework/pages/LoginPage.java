package com.selenium_framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium_framework.common.WebDriverFactory;


public class LoginPage  {

	@FindBy(id="txtUsername")
	private WebElement userName;
	@FindBy(id="txtPassword")
	private WebElement passWord;
	@FindBy(id="btnLogin")
	//@FindBy(xpath=("//input[@id='btnLogin']"))
	private WebElement login;
	
	private WebDriverWait wait;
	
	@SuppressWarnings("deprecation")
	public LoginPage(){ //Constructor no return type, always return object of itself so no return type
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
		navigateToLoginpage();
		wait=new WebDriverWait(WebDriverFactory.getDriver(), 30);
		
	}
	public LoginPage navigateToLoginpage(){
		WebDriverFactory.getDriver().get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login");
		return this;
	}
	public HomePage login(String strUserName, String strPassWord){
		userName.sendKeys(strUserName);
		passWord.sendKeys(strPassWord);
		login.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//HomePage hp = new HomePage();
		//return hp;
		return new HomePage().IsPageLoaded();
	}
	public LoginPage IsPageLoaded(){
		wait.until(ExpectedConditions.visibilityOf(userName));
		wait.until(ExpectedConditions.visibilityOf(passWord));
		
		//Assert.assertTrue(userName.isDisplayed(),"username not loaded");
		//Assert.assertTrue(passWord.isDisplayed(),"username not loaded");
		//Assert.assertTrue(login.isDisplayed(),"submit button not loaded");
		return this;
	}
	
}

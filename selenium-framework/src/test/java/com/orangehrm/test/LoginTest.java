package com.orangehrm.test;

import org.testng.annotations.Test;

import com.selenium_framework.common.AbstractSelenium;
import com.selenium_framework.pages.LoginPage;

public class LoginTest extends AbstractSelenium {

	@Test (dataProvider="ExcelData")
	public void VerifyAdminLoginSuccessfully(String userName, String passWord){
	LoginPage lp =	new LoginPage();
	lp.navigateToLoginpage()
		.login(userName, passWord)
			.VerifyAdminLinkIsGettingDisplayed();
	
	}
	
	@Test (dataProvider="ExcelData")
	public void VerifyAdminLoginSucesfully(String userName, String passWord){
	LoginPage lp =	new LoginPage();
	lp.navigateToLoginpage()
		.login(userName, passWord)
			.VerifyAdminLinkIsGettingDisplayed();
	
}
}

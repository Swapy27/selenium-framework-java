package com.orangehrm.test;

import org.testng.annotations.Test;

import com.selenium_framework.common.AbstractSelenium;
import com.selenium_framework.pages.LoginPage;

public class AddUserTest extends AbstractSelenium{

	@Test
	public void VerifyAdminLoginSuccessfully(){
	LoginPage lp =	new LoginPage();
	lp.login("admin", "admin")
		.VerifyAdminLinkIsGettingDisplayed()
			.navigateToAdminPage()
				.navigateToAddUserPage()
					.addUser("userName", "password", "confirmPassWord", "employeeName")
						.verifyUserInUserTable();
}
}
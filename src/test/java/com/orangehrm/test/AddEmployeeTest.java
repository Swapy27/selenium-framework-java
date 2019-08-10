package com.orangehrm.test;

import org.testng.annotations.Test;

import com.selenium_framework.common.AbstractSelenium;
import com.selenium_framework.pages.LoginPage;

public class AddEmployeeTest extends AbstractSelenium{

	@Test
	public void VerifyAdminLoginSuccessfully(){
	LoginPage lp =	new LoginPage();
	lp.navigateToLoginpage()
		.login("admin", "admin")
			.VerifyAdminLinkIsGettingDisplayed()
				.navigateToAdminPage()
					.navigateToAddUserPage()
						.addUser("John", "Roy"	, "Roy", "Roy");
}
}
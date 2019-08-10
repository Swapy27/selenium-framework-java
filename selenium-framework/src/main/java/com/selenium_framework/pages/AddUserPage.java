package com.selenium_framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_framework.common.WebDriverFactory;

public class AddUserPage {

	//@FindBy(id="menu_admin_viewAdminModule")
	//private WebElement addAdmin;
	//@FindBy(id="btnAdd")
	//private WebElement buttonAdd;
	@FindBy(id="systemUser_employeeName_empName")
	private WebElement empName;
	@FindBy(id="systemUser_userName")
	private WebElement userName;
	@FindBy(id="systemUser_password")
	private WebElement passWord;
	@FindBy(id="systemUser_confirmPassword")
	private WebElement confirmPassWord;
	@FindBy(id="btnSave")
	private WebElement buttonSave;
	
	public AddUserPage(){
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	public AdminPage addUser(String strEmpName, String strUserName, String strPassWord, String strConfirmPassWord){
		//addAdmin.click();
		//buttonAdd.click();
		empName.sendKeys(strEmpName);
		userName.sendKeys(strUserName);
		passWord.sendKeys(strPassWord);
		confirmPassWord.sendKeys(strConfirmPassWord);
		buttonSave.click();
		AdminPage ap = new AdminPage();
		return ap;
		//return new AddEmployeePage();
}
	
}


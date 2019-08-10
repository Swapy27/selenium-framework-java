package com.selenium_framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_framework.common.WebDriverFactory;

public class AddEmployeePage {
	@FindBy(id="menu_pim_viewPimModule")
	private WebElement addPIM;
	@FindBy(id="menu_pim_addEmployee")
	private WebElement addEmp;
	@FindBy(id="firstName")
	private WebElement frstName;
	@FindBy(id="lastName")
	private WebElement lstName;
	@FindBy(id="btnSave")
	private WebElement bttnSave;
	
	public AddEmployeePage(){
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	public AddEmployeePage login(String strfirstName, String strlastName){
		addPIM.click();
		addEmp.click();
		frstName.sendKeys(strfirstName);
		lstName.sendKeys(strlastName);
		bttnSave.click();
		//HomePage hp = new HomePage();
		//return hp;
		return new AddEmployeePage();
}
}

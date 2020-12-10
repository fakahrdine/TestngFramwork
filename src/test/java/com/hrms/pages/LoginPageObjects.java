package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonFunctions;

public class LoginPageObjects extends CommonFunctions {

	@FindBy(id = "txtUsername")
	public WebElement userName;
	@FindBy(id = "txtPassword")
	public WebElement passWord;
	@FindBy(id = "btnLogin")
	public WebElement loginBtn;
	@FindBy(xpath = "//a[@target='_blank']/img")
	public WebElement logoPresent;

	public LoginPageObjects() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	public void loginTHrms(String uSerName, String passWord) {
		sendText(userName, uSerName);
		sendText(this.passWord, passWord);
		click(loginBtn);

	}

}

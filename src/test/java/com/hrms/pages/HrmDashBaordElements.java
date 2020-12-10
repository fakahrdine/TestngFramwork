package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class HrmDashBaordElements {

	@FindBy(id = "welcome")
	public WebElement WelcomeBtn;

	@FindBy(xpath = "//a[text()='Logout']")

	public WebElement logOutBtn;

	public HrmDashBaordElements() {
		PageFactory.initElements(BaseClass.driver, this);

	}

}

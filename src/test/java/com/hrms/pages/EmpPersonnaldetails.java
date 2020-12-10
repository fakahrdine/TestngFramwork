package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class EmpPersonnaldetails {

	@FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
	public WebElement pdIdemp;

	@FindBy(xpath = "//div[@id='profile-pic']/h1")

	public WebElement pdEmpName;

	public EmpPersonnaldetails() {
		PageFactory.initElements(BaseClass.driver, this);

	}

}

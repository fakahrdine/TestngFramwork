package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.utils.CommonFunctions;
import com.hrms.utils.Constants;
import com.hrms.utils.ExecelUtility;

public class LoginTest extends CommonFunctions {

	@Test(groups = { "Smoke" }, dataProvider = "logindata")
	public void positiveLoginVirefication(String usernames, String passwords) {

		test.info("login in to the application");
		sendText(login.userName, usernames);
		sendText(login.passWord, passwords);
		click(login.loginBtn);

		test.info("validating the user loggen in successfully");
		Boolean logoIsPresent = login.logoPresent.isDisplayed();

		Assert.assertTrue(logoIsPresent, "the logo isnt displayed");

	}

	@DataProvider(name = "logindata")
	public Object[][] getData() {

		return ExecelUtility.exelIntoArray(Constants.EXCEL_FILE_PATH, "positivelogindata");

	}

}

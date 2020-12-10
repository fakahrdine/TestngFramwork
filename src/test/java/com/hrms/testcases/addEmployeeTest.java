package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrms.utils.CommonFunctions;
import com.hrms.utils.ConfigsReader;

public class addEmployeeTest extends CommonFunctions {

	@Test(groups = { "Regression" })
	public void virefyaddEmpLibels() {
		wait(2);
		


		addEmp.navigateToAddEmployee();
		SoftAssert asert = new SoftAssert();
		boolean firstNlabelisD = addEmp.firstNlabel.isDisplayed();
		boolean lastNlableisD = addEmp.lastNlable.isDisplayed();
		boolean photoGrapthLabelisD = addEmp.photoGrapthLabel.isDisplayed();
		boolean empIdlabelisD = addEmp.empIdlabel.isDisplayed();
		asert.assertTrue(firstNlabelisD);
		asert.assertTrue(lastNlableisD);
		asert.assertTrue(photoGrapthLabelisD);
		asert.assertTrue(empIdlabelisD);
		takeScreenShot("lables.png");
		asert.assertAll();
	}

	@Test(groups = { "Regression" })
	public void addEmpinfo() {
		login.loginTHrms(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		wait(2);

		click(addEmp.pimBtn);
		click(addEmp.addEmpBtn);
		sendText(addEmp.firstNText, "Jackie");
		sendText(addEmp.lastNText, "Alan");
		sendText(addEmp.choseFileBtn, "C:\\Users\\Mohamed\\Desktop\\maxresdefault.jpg");// uplaod an img
		click(addEmp.saveBtn);
		wait(3);
		boolean empIsadded = addEmp.addedEmpName.isDisplayed();
		Assert.assertTrue(empIsadded);
	}

	@Test(dataProvider = "userData", groups = "Regression")

	public void test(String firstName, String lasName, String userName, String passWord, String passWordConf) {
		// System.out.println(firstName + " " + lasName + " " + userName + " " +
		// password);
		login.loginTHrms(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		addEmp.navigateToAddEmployee();
		sendText(addEmp.firstNText, firstName);
		sendText(addEmp.lastNText, lasName);
		String expectedEmpId = addEmp.empIdtext.getAttribute("value");
		click(addEmp.addEmpCredentialsCheckBox);
		sendText(addEmp.empUserName, userName);
		sendText(addEmp.empPassWord, passWord);
		sendText(addEmp.empConfirmPass, passWordConf);

		click(addEmp.saveBtn);

		waitForVisibilty(EmpPd.pdIdemp);

		String accualEmpId = EmpPd.pdIdemp.getAttribute("value");

		Assert.assertEquals(accualEmpId, expectedEmpId, "accualEmpId is not matching expectedEmpId ");

		wait(2);

		takeScreenShot(firstName + "_" + lasName);

		wait(3);

		// Assert.assertTrue();

	}

	@DataProvider(name = "userData")
	public Object getData() {

		Object[][] data = { { "Johnyoy", "Smithiya", "Layal@h123", "AmirKhljg87Uan@123", "AmirKhljg87Uan@123" },
				{ "Raj", "Kapoor", "john17823", "AmirKhljg87Uan@123", "AmirKhljg87Uan@123" },
				{ "Rohaniii", "khan", "rohani1223", "AmirKhljg87Uan@123", "AmirKhljg87Uan@123" },
				{ "Asslam", "Marpio", "Aslamo787", "AmirKhljg87Uan@123", "AmirKhljg87Uan@123" },
				{ "Sozzan", "brown", "opira77", "AmirKhljg87Uan@123", "AmirKhljg87Uan@123" },
				{ "Amaol", "guino", "ossi818", "AmirKhljg87Uan@123", "AmirKhljg87Uan@123" },

		};

		return data;

	}

}

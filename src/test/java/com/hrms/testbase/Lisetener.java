package com.hrms.testbase;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrms.utils.CommonFunctions;

public class Lisetener extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {

		System.out.println("Test started !!!" + result.getName());
	    test=report.createTest(result.getName());

	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test passed !!!");
		test.pass("Test passed !!! "+result.getName());
		CommonFunctions.takeScreenShot("pass//" + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("test failed !!!");
		test.fail("test failed !!! "+result.getName());
		CommonFunctions.takeScreenShot("failed//" + result.getName());

	}

}

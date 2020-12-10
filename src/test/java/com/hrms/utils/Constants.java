package com.hrms.utils;

public class Constants {

	public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir")
			+ "//src//test//resources//drivers//chromedriver.exe";
	public static final String GECKO_DRIVER_PATH = System.getProperty("user.dir")
			+ "//src//test//resources//drivers//geckodriver.exe";

	public static final String PROPERTIES_FILE_PATH = System.getProperty("user.dir")
			+ "//src//test//resources//configs//configuration.properties";
	public static final int IMPLICIT_TIME_WAIT = 15;
	public static final int EXPLICIT_TIME_WAIT = 25;

	public static final String EXCEL_FILE_PATH = System.getProperty("user.dir")
			+ "//src//test//resources//testdata//employeedata.xlsx";

	public static final String REPORT_FILE_PATH = System.getProperty("user.dir") + "//target//html-reports//HRMS.html";

}

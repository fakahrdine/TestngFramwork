package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlreporte;
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeTest(alwaysRun = true)

	public static void generateReport() {
		ConfigsReader.readPropertieas(Constants.PROPERTIES_FILE_PATH);

		htmlreporte = new ExtentHtmlReporter(Constants.REPORT_FILE_PATH);
		htmlreporte.config().setDocumentTitle("Syntax");
		htmlreporte.config().setReportName("Hrms");
		htmlreporte.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlreporte);
		report.setSystemInfo("QA Enginner ", "fakhardine");
		report.setSystemInfo("Environment", "Test");
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Browser", ConfigsReader.getProperty("browser"));
		
		
		
		

	}

	@AfterTest(alwaysRun = true)
	public void writeReport() {
		report.flush();
	}

	@BeforeMethod(alwaysRun = true)
	public static WebDriver setUP() {

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("browser not Supported !!!!");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_TIME_WAIT, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProperty("url"));

		PageInitilizer.initialize();
		return driver;
	}

	@AfterMethod(alwaysRun = true)
	public static void tearDown() {

		if (driver != null) {
			driver.quit();
		}

	}
}

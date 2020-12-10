package com.hrms.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.PageInitilizer;

public class CommonFunctions extends PageInitilizer {
	/**
	 * Method that clears and send keys
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);

	}

	/**
	 * this method checks if radio/checkbox is enabled and clicks it
	 * 
	 * @param radioOrCheckBox
	 * @param value
	 */
	public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBox, String value) {
		String actualValue;
		for (WebElement el : radioOrCheckBox) {
			actualValue = el.getAttribute("value").trim();
			if (el.isEnabled() && actualValue.equals(value))
				;
			el.click();
			break;

		}

	}

	/**
	 * Method that checks text is there and then selects it
	 * 
	 * @param element
	 * @param textToselect
	 */

	public static void selectDdvalue(WebElement element, String textToselect) {
		try {
			String text;

			Select select = new Select(element);
			List<WebElement> allOptions = select.getOptions();
			for (WebElement Ele : allOptions) {

				text = Ele.getText();
				if (text.equals(textToselect)) {
					select.selectByVisibleText(textToselect);

					break;

				}

			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This Method that select value by index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDdvalue(WebElement element, int index) {
		try {
			Select select = new Select(element);
			List<WebElement> allIndexes = select.getOptions();
			int size = allIndexes.size();
			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method that accept alert an catches exception if alert is not present
	 */

	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method that dismiss alert an catches exception if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method that get text from the alert an catches exception if alert is not
	 * present
	 * 
	 * @return alert text
	 */
	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();

		} catch (Exception e) {

		}
		return alertText;

	}

	/**
	 * Method that send text to the alert an catches exception if alert is not
	 * present
	 * 
	 * @param textToAlert
	 */

	public static void sendAlertText(String textToAlert) {

		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(textToAlert);
		} catch (NoAlertPresentException e) {

			e.printStackTrace();
		}

	}

	/**
	 * this method switch focus to a frame based on name or Id an catches exception
	 * if frame is not present
	 * 
	 * @param nameOrId
	 */

	public static void swichToFrame(String nameOrId) {
		try {

			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * this method switch focus to a frame the WebElement an catches exception if
	 * frame is not present
	 * 
	 * @param element
	 */
	public static void swichToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * this method switch focus to a frame based on frame index an catches exception
	 * if frame is not present
	 * 
	 * @param findex
	 */
	public static void swichToFrame(int findex) {
		try {
			driver.switchTo().frame(findex);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method creat the object of {@link WebDriverWait} and return instance of
	 * WebDriverWait
	 * 
	 * @return {@link WebDriverWait}
	 */

	/**
	 * this method swich the focus to the child window
	 */
	public static void swichToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!mainWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}

		}
	}

	public static WebDriverWait getWaitObject() {

		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_TIME_WAIT);

		return wait;

	}

	/**
	 * this method wait for the clicibilty of a WebElement
	 * 
	 * @param element
	 */
	public static WebElement waitForCliblility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * this method will wait until the element become visible
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement waitForVisibilty(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * 
	 * this method will call the method waitForCliblility and click on a WebElement
	 * 
	 * @param element
	 */

	public static void click(WebElement element) {
		waitForCliblility(element);
		element.click();

	}

	/**
	 * this method will take screen shot of the webpage with png/jpg extensions
	 * 
	 * @param fileName + file extentions:png/jpg
	 */

	public static void takeScreenShot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenShotcopy = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShotcopy, new File("screenShots\\" + fileName+".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * this method contains the the object of javaScriptExecuter.
	 * 
	 * @return
	 */
	public static JavascriptExecutor getJsObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;

	}

	/**
	 * this method click on the button using java executer
	 * 
	 * @param element
	 */

	public static void jsClick(WebElement element) {
		getJsObject().executeScript("arguments[0].click();", element);

	}

	/**
	 * this method will scroll to specific element in the webpage
	 * 
	 * @param element
	 */

	public static void scrollToElement(WebElement element) {
		getJsObject().executeScript("arguments[0].scrollIntoView[true];", element);

	}

	/**
	 * this method will scroll down the webpage
	 * 
	 * @param pixel
	 */

	public static void scrollDown(int pixel) {
		getJsObject().executeScript("window.scrollBy(0," + pixel + ")");

	}

	/**
	 * this method will scroll up the webpage
	 * 
	 * @param pixel
	 */

	public static void scrollUp(int pixel) {
		getJsObject().executeScript("window.scrollBy(0,-" + pixel + ")");

	}

	/**
	 * this is static wait method
	 * 
	 * @Thread.sleep
	 * @param waitTime
	 */
	public static void wait(int waitTime) {
		try {
			Thread.sleep(waitTime * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * this method will select a date from a calendar
	 * @param element
	 * @param date
	 */
	public static void selectDateCalendar(List<WebElement> element, String date) {

		for (WebElement pickDate : element) {
			if (pickDate.isEnabled()) {
				if (pickDate.getText().equals(date)) {
					pickDate.click();

				}

			}

		}

	}

}

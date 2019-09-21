package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains the utility methods which we can use anywhere
 * @author Manvendra
 *
 */
public class Util {

	/**
	 * This method will wait for 60 seconds before throwing the 'ElementNotVisible'
	 * exception
	 * 
	 * @param driver
	 * @param element
	 */
	public static void waitExplicitlyForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this is an overloaded {@code waitExplicitlyForElementVisibility} method where you can
	 * provide the number of seconds to wait before throwing the ElementNotVisible
	 * exception
	 * 
	 * @param seconds
	 * @param driver
	 * @param element
	 */
	public static void waitExplicitlyForElementVisibility(int seconds, WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}

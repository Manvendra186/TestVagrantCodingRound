package com.pom.pages;

import org.openqa.selenium.*;

/**
 * This class is a design pattern to create Object Repository for web elements.
 * This class will find the WebElements of that web page and also has
 * Page methods which perform operations on those WebElements.
 * 
 * @author Manvendra
 *
 */
public class SignIn {
	By yourTrips = By.linkText("Your trips");
	By yourTripSignInBtn = By.id("SignIn");
	By popupSignInBtn = By.id("signInButton");
	By error1 = By.id("errors1");
	By modelWindow = By.id("modal_window");

	WebDriver driver;
	public SignIn(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * 
	 * @return YourTrips webelement
	 */
	public WebElement yourTripWebelement() {
		return driver.findElement(yourTrips);
	}
	/**
	 * Click on the your trips option
	 */
	public void clickYourTrip() {
		driver.findElement(yourTrips).click();
	}

	/**
	 * clicks on the sign in button which is in 'your trips' section
	 */
	public void clickYourTripSignInBtn() {
		driver.findElement(yourTripSignInBtn).click();
	}

	/**
	 * 
	 * @return Popup sign in btn webelement
	 */
	public WebElement popupSignInBtnWebelement() {
		return driver.findElement(popupSignInBtn);
	}
	/**
	 * clicks on the sign in pop-up 'signin button'
	 */
	public void clickPopupSignInBtn() {
		driver.findElement(popupSignInBtn).click();;
	}

	/**
	 * 
	 * @return the error text when user clicks on the pop-up sign in button without
	 *         giving any credentials
	 */
	public String signInErrorText() {
		return driver.findElement(error1).getText();
	}
	
	/**
	 * 
	 * @return the WebElement for model window which is poped up after clicking sign in btn from 'your trips' section
	 */
	public WebElement modelWindow() {
		return driver.findElement(modelWindow);
	}

}

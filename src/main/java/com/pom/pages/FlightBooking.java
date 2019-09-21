package com.pom.pages;

import java.util.List;

import org.openqa.selenium.*;

public class FlightBooking {

	/**
	 * This class is a design pattern to create Object Repository for web elements.
	 * This class will find the WebElements of that web page and also has page
	 * methods which perform operations on those WebElements.
	 * 
	 * @author Manvendra
	 *
	 */
	By oneWay = By.id("OneWay");
	By fromTag = By.id("FromTag");
	By toTag = By.id("ToTag");
	By searchBtn = By.id("SearchBtn");
	By datePicker = By.id("DepartDate");
	By selectTodayDate = By.xpath("//*[contains(@class,'ui-state-active')]");
	By originList = By.id("ui-id-1");
	By originListOptions = By.tagName("li");
	By destinationList = By.id("ui-id-2");
	By destinationListOptions = By.tagName("li");
	
	
	public By searchSummary = By.className("searchSummary");
	

	WebDriver driver;

	public FlightBooking(WebDriver dr) {
		this.driver = dr;
	}

	/**
	 * Clicks on one way option
	 */
	public void clickOnOneway() {
		driver.findElement(oneWay).click();
	}

	/**
	 * Perform sendkeys operation with the provided string into the 'To' text box
	 * 
	 * @param s
	 */
	public void typeTo(String s) {
		toTagElement().sendKeys(s);
	}

	/**
	 * Perform sendkeys operation with the provided string into the 'From' text box
	 * 
	 * @param s
	 */
	public void typeFrom(String s) {
		fromTagElement().sendKeys(s);
	}

	public WebElement toTagElement() {
		return driver.findElement(toTag);
	}

	public WebElement fromTagElement() {
		return driver.findElement(fromTag);
	}

	public void clearATextbox(WebElement element) {
		element.click();
		element.clear();
	}

	public void clickOnSearchBtn() {
		driver.findElement(searchBtn).click();
	}
	public WebElement searchSummaryElement() {
		return driver.findElement(searchSummary);
	}
	
	public WebElement datePickerElement() {
		return driver.findElement(datePicker);
	}
	public void clickDatePicker() {
		datePickerElement().click();
	}
	public WebElement selectedDateElement() {
		return driver.findElement(selectTodayDate);
	}
	public void clickSelectedDate() {
		selectedDateElement().click();
	}
	
	public WebElement originListElement() {
		return driver.findElement(originList);
	}
	public List<WebElement> originListElements(){
		return driver.findElement(originList).findElements(originListOptions);
	}
	public WebElement destinationListElement() {
		return driver.findElement(destinationList);
	}
	public List<WebElement> destinationListElements(){
		return driver.findElement(destinationList).findElements(destinationListOptions);
	}
}

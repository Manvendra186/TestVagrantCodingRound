package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.sun.javafx.PlatformUtil;

/**
 * 
 * @author Manvendra
 *
 */
public class DriverInstance {

	private WebDriver driver;
	private String dir = System.getProperty("user.dir");

	public DriverInstance() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", dir + "\\chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", dir + "\\chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", dir + "\\chromedriver_linux");
		}
		// I can make it for other browsers also but since chromedriver is only
		// mentioned therefore i am directly creating chromdriver's object
		this.driver = new ChromeDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}
}

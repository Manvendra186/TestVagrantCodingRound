import com.sun.javafx.PlatformUtil;
import com.utility.DriverInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest extends DriverInstance {

	// WebDriver driver = new ChromeDriver();

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		//setDriverPath();
		getDriver().get("https://www.cleartrip.com/");
		waitFor(2000);
		getDriver().findElement(By.id("OneWay")).click();

		getDriver().findElement(By.id("FromTag")).clear();
		getDriver().findElement(By.id("FromTag")).sendKeys("Bangalore");

		// wait for the auto complete options to appear for the origin

		waitFor(2000);
		List<WebElement> originOptions = getDriver().findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();

		getDriver().findElement(By.id("toTag")).clear();
		getDriver().findElement(By.id("toTag")).sendKeys("Delhi");

		// wait for the auto complete options to appear for the destination

		waitFor(2000);
		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = getDriver().findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();

		getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();

		// all fields filled in. Now click on search
		getDriver().findElement(By.id("SearchBtn")).click();

		waitFor(5000);
		// verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(By.className("searchSummary")));

		// close the browser
		getDriver().quit();

	}

	private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
		}
	}

	private boolean isElementPresent(By by) {
		try {
			getDriver().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// commented the code because created a class to instantiate the driver which
		// will be reusable in all test classes
		/*
		 * private void setDriverPath() {
		 * 
		 * if (PlatformUtil.isMac()) { System.setProperty("webdriver.chrome.driver",
		 * "chromedriver"); } if (PlatformUtil.isWindows()) {
		 * System.setProperty("webgetDriver().chrome.driver", "chromedriver.exe"); } if
		 * (PlatformUtil.isLinux()) { System.setProperty("webdriver.chrome.driver",
		 * "chromedriver_linux"); } }
		 */
}

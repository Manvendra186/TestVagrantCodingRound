import com.pom.pages.FlightBooking;
import com.utility.*;

import org.openqa.selenium.*;

import org.testng.*;
import org.testng.annotations.*;

import java.util.List;

public class FlightBookingTest extends DriverInstance implements Constants {

	// WebDriver driver = new ChromeDriver();
	FlightBooking flightBookingObj = new FlightBooking(getDriver());

	@BeforeTest
	public void navigateToClearTrip() {
		getDriver().get(URL);
		getDriver().manage().window().maximize();
	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		// setDriverPath();
		Util.waitExplicitlyForElementVisibility(getDriver(), flightBookingObj.toTagElement());
		// waitFor(2000);
		// getDriver().findElement(By.id("OneWay")).click();
		flightBookingObj.clickOnOneway();

		// getDriver().findElement(By.id("FromTag")).clear();
		// getDriver().findElement(By.id("FromTag")).sendKeys("Bangalore");

		flightBookingObj.clearATextbox(flightBookingObj.fromTagElement());
		flightBookingObj.typeFrom(FROM);

		// wait for the auto complete options to appear for the origin

		Util.waitExplicitlyForElementVisibility(getDriver(), flightBookingObj.originListElement());
		List<WebElement> originOptions = flightBookingObj.originListElements();
		originOptions.get(0).click();

		// getDriver().findElement(By.id("toTag")).clear();
		// getDriver().findElement(By.id("toTag")).sendKeys("Delhi");

		flightBookingObj.clearATextbox(flightBookingObj.toTagElement());
		flightBookingObj.typeTo(TO);

		// wait for the auto complete options to appear for the destination

		 Util.waitExplicitlyForElementVisibility(getDriver(), flightBookingObj.destinationListElement());
		// select the first item from the destination auto complete list

		// List<WebElement> destinationOptions =
		// getDriver().findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		List<WebElement> destinationOptions = flightBookingObj.destinationListElements();
		destinationOptions.get(0).click();

		// getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();

		flightBookingObj.clickDatePicker();
		flightBookingObj.clickSelectedDate();

		// all fields filled in. Now click on search
		// getDriver().findElement(By.id("SearchBtn")).click();
		flightBookingObj.clickOnSearchBtn();

		// waitFor(5000);
		Util.waitExplicitlyForElementVisibility(10, getDriver(), flightBookingObj.searchSummaryElement());
		// verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(flightBookingObj.searchSummary));

		/*
		 * close the browser getDriver().quit();
		 */

	}

	@AfterTest
	public void closeBrowser() {
		getDriver().close();
	}

	/*private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File | Settings| File Templates.
		}
	}*/

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

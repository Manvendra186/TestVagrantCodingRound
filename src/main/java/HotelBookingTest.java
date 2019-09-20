import com.sun.javafx.PlatformUtil;
import com.utility.DriverInstance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest extends DriverInstance {

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@Test
	public void shouldBeAbleToSearchForHotels() {
		// setDriverPath();

		getDriver().get("https://www.cleartrip.com/");
		hotelLink.click();

		localityTextBox.sendKeys("Indiranagar, Bangalore");

		new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
		searchButton.click();

		getDriver().quit();

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

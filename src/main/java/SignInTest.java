import com.pom.pages.SignIn;
import com.utility.DriverInstance;
import com.utility.Util;

import org.testng.Assert;
import org.testng.annotations.*;

public class SignInTest extends DriverInstance {

	SignIn signInPomObj = new SignIn(getDriver());

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		getDriver().get("https://www.cleartrip.com/");
		getDriver().manage().window().maximize();

		Util.waitExplicitlyForElementVisibility(getDriver(), signInPomObj.yourTripWebelement());
		signInPomObj.clickYourTrip();
		signInPomObj.clickYourTripSignInBtn();

		Util.waitExplicitlyForElementVisibility(10, getDriver(), signInPomObj.modelWindow());
		getDriver().switchTo().frame(signInPomObj.modelWindow());
	
		Util.waitExplicitlyForElementVisibility(getDriver(), signInPomObj.popupSignInBtnWebelement());
		signInPomObj.clickPopupSignInBtn();

		String errors1 = signInPomObj.signInErrorText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
	}

	@AfterTest
	public void closeBrowser() {
		getDriver().close();
		// we can use quit also but that will close all the open tabs i.e., the browser
		// but 'close()' will only close the current focused tab
	}

}

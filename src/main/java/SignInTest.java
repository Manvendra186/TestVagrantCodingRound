import com.pom.pages.SignIn;
import com.utility.Constants;
import com.utility.DriverInstance;
import com.utility.Util;

import org.testng.Assert;
import org.testng.annotations.*;

public class SignInTest extends DriverInstance implements Constants{

	SignIn signInPomObj = new SignIn(getDriver());

	@BeforeTest
	public void navigateToClearTrip() {
		getDriver().get(URL);
		getDriver().manage().window().maximize();
	}
	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing(){

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

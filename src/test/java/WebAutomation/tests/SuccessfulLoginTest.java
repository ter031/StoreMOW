package WebAutomation.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import WebAutomation.pageObjects.HomePage;
import WebAutomation.pageObjects.LandingPage;
import WebAutomation.pageObjects.LoginPage;
import WebAutomation.pageObjects.LogoutPage;
import WebAutomation.testComponents.BaseTest;

public class SuccessfulLoginTest extends BaseTest {
	
	@Test(dataProvider="getData", groups= {"Smoke"})
	public void userIsSuccessfullyLoggedInUsingValidCredentials(HashMap<String, String> input)
	{
		LoginPage loginpage = landingpage.goToLogin();
		HomePage homepage = loginpage.LoginIntoAppUsingValidCredentials(input.get("email"), input.get("password"));
		String myAccountText = homepage.getMyAccountText();
		Assert.assertTrue(myAccountText.equalsIgnoreCase("My Account"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//WebAutomation//data//ValidLoginCredentials.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	@Test(dataProvider="getData", groups= {"Smoke"})
	public void logoutIsWorking(HashMap<String, String> input)
	{
		LoginPage loginpage = landingpage.goToLogin();
		HomePage homepage = loginpage.LoginIntoAppUsingValidCredentials(input.get("email"), input.get("password"));
		LogoutPage logoutpage = homepage.logoutAction();
		String logoutConfirmationText = logoutpage.getLogoutConfirmationText();
		Assert.assertTrue(logoutConfirmationText.contains("You have been logged off your account"));
	}
}

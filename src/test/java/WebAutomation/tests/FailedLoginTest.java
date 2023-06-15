package WebAutomation.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import WebAutomation.pageObjects.LandingPage;
import WebAutomation.pageObjects.LoginPage;
import WebAutomation.testComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FailedLoginTest extends BaseTest {
	
	@Test(dependsOnMethods= {"returningCustomerSectionIsThere"}, dataProvider="getData")
	public void failedLogin(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		LoginPage loginpage = landingpage.goToLogin();
		loginpage.LoginIntoAppUsingInvalidCredentials(input.get("email"), input.get("password"));
		String message = loginpage.getFailedMessage();
		Assert.assertTrue(message.equalsIgnoreCase("Warning: No match for E-Mail Address and/or Password."));
	}
	
	@Test
	public void returningCustomerSectionIsThere()
	{
		LoginPage loginpage = landingpage.goToLogin();
		String headerText = loginpage.getHeaderTextOfReturningCustomerSection();
		Assert.assertTrue(headerText.equalsIgnoreCase("Return Customer"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//WebAutomation//data//InvalidLoginCredentials.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}

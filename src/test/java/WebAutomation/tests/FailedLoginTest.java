package WebAutomation.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebAutomation.pageObjects.LandingPage;
import WebAutomation.pageObjects.LoginPage;
import WebAutomation.testComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FailedLoginTest extends BaseTest {
	
	@Test(dependsOnMethods= {"returningCustomerSectionIsThere"})
	public void failedLogin() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		LoginPage loginpage = landingpage.goToLogin();
		loginpage.LoginIntoApp("thakurdpk786@gmail.com", "msl");
		String message = loginpage.getFailedMessage();
		Assert.assertTrue(message.equalsIgnoreCase("Warning: No match for E-Mail Address and/or Password."));
	}
	
	@Test
	public void returningCustomerSectionIsThere()
	{
		LoginPage loginpage = landingpage.goToLogin();
		String headerText = loginpage.getHeaderTextOfReturningCustomerSection();
		Assert.assertTrue(headerText.equalsIgnoreCase("Returning Customer"));
	}

}

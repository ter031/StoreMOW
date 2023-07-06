package WebAutomation.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import WebAutomation.pageObjects.LandingPage;
import WebAutomation.pageObjects.LoginPage;
import WebAutomation.testComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
	
	public LandingPage landingpage;
	public LoginPage loginpage;
	
	@Given("User is landed on the landing page")
	public void User_is_landed_on_the_landing_page() throws IOException
	{
		landingpage = launchApp();
	}
	
	@Given("User is on the login page")
	public void User_is_on_the_login_page()
	{
		loginpage = landingpage.goToLogin();
	}
	
	@When("^User try to login with (.+) and (.+)$")
	public void User_try_to_login_with_invaid_email_and_password(String username, String password)
	{
		loginpage.LoginIntoAppUsingInvalidCredentials(username, password);
	}
	
	@Then("{string} warning message is thrown")
	public void warning_message_is_thrown(String warningMessage)
	{
		String message = loginpage.getFailedMessage();
		Assert.assertTrue(message.equalsIgnoreCase(warningMessage));
		driver.close();
	}
	
	@Then("support email is {string}")
	public void support_email(String supportEmail)
	{
		String email = landingpage.getSupportEmail();
		Assert.assertTrue(email.contains(supportEmail));
		driver.close();
	}
	
	@Then("address is {string}")
	public void verify_address(String addr)
	{
		String address = landingpage.getAddress();
		Assert.assertTrue(address.contains(addr));
		driver.close();
	}
}

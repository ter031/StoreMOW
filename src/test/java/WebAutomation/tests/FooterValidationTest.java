package WebAutomation.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebAutomation.testComponents.BaseTest;

public class FooterValidationTest extends BaseTest {
	
	@Test(groups= {"Sanity"})
	public void verifySupportEmail()
	{
		String email = landingpage.getSupportEmail();
		Assert.assertTrue(email.contains("support@mapsherpa.com"));
	}
	
	@Test
	public void verifyAddress()
	{
		String address = landingpage.getAddress();
		Assert.assertTrue(address.contains("MapSherpa Inc, 1953 Bromley Road, Ottawa, Ontario, Canada, K2A 1C3"));
	}
}

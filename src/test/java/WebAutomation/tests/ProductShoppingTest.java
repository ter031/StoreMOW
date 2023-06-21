package WebAutomation.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import WebAutomation.pageObjects.HomePage;
import WebAutomation.pageObjects.LoginPage;
import WebAutomation.pageObjects.MapDetailPage;
import WebAutomation.pageObjects.ProductPage;
import WebAutomation.testComponents.BaseTest;

public class ProductShoppingTest extends BaseTest {
	
	@Test(dataProvider="getData", groups = {"Shopping"})
	public void productIsAddedToTheCart(HashMap<String, String> input)
	{
		LoginPage loginpage = landingpage.goToLogin();
		HomePage homepage = loginpage.LoginIntoAppUsingValidCredentials(input.get("email"), input.get("password"));
		ProductPage productpage = homepage.clickOnLogo();
		MapDetailPage mapdetailspage = productpage.viewDetailsOfWorldSeaRouteMap();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		mapdetailspage.addMapToTheCart();
		String sucessfulTextForMapAdded = mapdetailspage.grabMapAddedText();
		Assert.assertTrue(sucessfulTextForMapAdded.equalsIgnoreCase("You have added World Sea Routes Map to your shopping cart!"));
	}
	
	@Test(dataProvider="getSearchData", groups= {"Shopping"})
	public void noMapIsDisplayedWhenSearchedForInvalidMap(HashMap<String, String> input)
	{
		LoginPage loginpage = landingpage.goToLogin();
		HomePage homepage = loginpage.LoginIntoAppUsingValidCredentials(input.get("email"), input.get("password"));
		ProductPage productpage = homepage.clickOnLogo();
		productpage.searchAction(input.get("mapToBeSearchedFor"));
		String textOnInvalidSearch = productpage.getTextOnInvalidSearch();
		Assert.assertTrue(textOnInvalidSearch.contains("There is no product that matches the search criteria"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//WebAutomation//data//ValidLoginCredentials.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	@DataProvider
	public Object[][] getSearchData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//WebAutomation//data//InvalidSearchData.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}

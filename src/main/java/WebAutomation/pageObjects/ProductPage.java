package WebAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebAutomation.abstractComponents.AbstractComponent;

public class ProductPage extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='sec3tab2slider1div']/ul/li[1]/div/div[2]/div[1]/a/img")
	WebElement firstMapImage;
	
	@FindBy(xpath="//div[@id='sec3tab2slider1div']/ul/li[1]/div/div[2]/div[1]/div/div/div[1]/a")
	WebElement viewDetails;
	
	@FindBy(id="search")
	WebElement searchBar;
	
	@FindBy(id="button-search")
	WebElement searchButton;
	
	@FindBy(xpath="//section[@class='container-fluid listing-section']/div/div/div[3]/p")
	WebElement textOnInvalidSearch;
	
	public MapDetailPage viewDetailsOfWorldSeaRouteMap()
	{
		Actions action = new Actions(driver);
		action.moveToElement(firstMapImage).build().perform();
		viewDetails.click();
		MapDetailPage mapdetailpage = new MapDetailPage(driver);
		return mapdetailpage;
	}
	
	public void searchAction(String mapToBeSearchFor)
	{
		searchBar.sendKeys(mapToBeSearchFor);
		searchButton.click();
	}
	
	public String getTextOnInvalidSearch()
	{
		return textOnInvalidSearch.getText();
	}
}

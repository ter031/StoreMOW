package WebAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebAutomation.abstractComponents.AbstractComponent;

public class MapDetailPage extends AbstractComponent {
	
	WebDriver driver;
	
	public MapDetailPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="button-cart")
	WebElement addToCartButton;
	
	@FindBy(css=".light-img-wrp p")
	WebElement mapAddedText;
	
	public void addMapToTheCart()
	{
		addToCartButton.click();
	}
	
	public String grabMapAddedText()
	{
		return mapAddedText.getText();
	}
}

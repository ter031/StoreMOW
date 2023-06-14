package WebAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebAutomation.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class=' col-md-8']/div[3]/a")
	WebElement supportEmail;
	
	@FindBy(xpath="//b[@class='col-md-12 text-center serv-text hidden-sm hidden-xs']")
	WebElement address;
	
	public void hitAppURL()
	{
		driver.get("https://store.mapsofworld.com/");
	}
	
	public String getSupportEmail()
	{
		return supportEmail.getText();
	}
	
	public String getAddress()
	{
		return address.getText();
	}
}

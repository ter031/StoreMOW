package WebAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebAutomation.abstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement MessageOnFailedLogin;
	
	@FindBy(xpath="//div[@id='content']/div/div[2]/div/h2")
	WebElement headerTextOfReturningCustomer;
	
	public String getFailedMessage() 
	{
		return MessageOnFailedLogin.getText();
	}
	
	public String getHeaderTextOfReturningCustomerSection()
	{
		return headerTextOfReturningCustomer.getText();
	}
}

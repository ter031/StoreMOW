package WebAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebAutomation.abstractComponents.AbstractComponent;

public class LogoutPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='content']/p[1]")
	WebElement logoutConfirmationText;
	
	public String getLogoutConfirmationText()
	{
		return logoutConfirmationText.getText();
	}
}

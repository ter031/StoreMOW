package WebAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebAutomation.abstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='full-width margin-bottom-10']/div/div[1]/h2")
	WebElement myAccountText;
	
	@FindBy(css=".log-btn")
	WebElement logoutButton;
	
	public String getMyAccountText()
	{
		return myAccountText.getText();
	}
	
	public LogoutPage logoutAction()
	{
		logoutButton.click();
		LogoutPage logoutpage = new LogoutPage(driver);
		return logoutpage;
	}
}

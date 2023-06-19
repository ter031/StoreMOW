package WebAutomation.abstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebAutomation.pageObjects.HomePage;
import WebAutomation.pageObjects.LoginPage;
import WebAutomation.pageObjects.ProductPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".log-btn")
	WebElement LoginRegisterButton;
	
	@FindBy(id="input-email")
	WebElement EmailTextbox;
	
	@FindBy(id="input-password")
	WebElement PasswordTextbox;
	
	@FindBy(css="input.btn-primary")
	WebElement LoginButton;
	
	@FindBy(css=".logo a img")
	WebElement logo;
	
	public LoginPage goToLogin()
	{
		LoginRegisterButton.click();
		LoginPage loginpage = new LoginPage(driver);
		return loginpage;
	}
	
	public void LoginIntoAppUsingInvalidCredentials(String email, String password)
	{
		EmailTextbox.sendKeys(email);
		PasswordTextbox.sendKeys(password);
		LoginButton.click();
	}
	
	public HomePage LoginIntoAppUsingValidCredentials(String email, String password)
	{
		EmailTextbox.sendKeys(email);
		PasswordTextbox.sendKeys(password);
		LoginButton.click();
		HomePage homepage = new HomePage(driver);
		return homepage;
	}
	
	public ProductPage clickOnLogo()
	{
		logo.click();
		ProductPage productpage = new ProductPage(driver);
		return productpage;
	}
}

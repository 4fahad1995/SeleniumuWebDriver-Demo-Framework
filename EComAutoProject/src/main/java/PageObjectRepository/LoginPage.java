package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)   //constructor
	{
		//super(driver);               //this is required if you are inheriting from another class(parent)
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory
	@FindBy(xpath="//input[@placeholder = 'Username']")
	WebElement usrname;
	
	@FindBy(xpath="//input[@placeholder = 'Password']")
	WebElement pass;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement login_btn;
	
	public void loginApp(String user, String password) {
		usrname.sendKeys(user);
		pass.sendKeys(password);
		login_btn.click();
	}
	
	@BeforeMethod
	public void GoTo() 
	{
		driver.get("https://www.saucedemo.com/");
	}
	
}

package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;

	public LandingPage(WebDriver driver) //constructor
	{
		// initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory
	@FindBy(xpath="//input[@id = 'userEmail']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@id = 'userPassword']")
	WebElement passwordEle;
	
	@FindBy(xpath="//input[@id= 'login']")
	WebElement login_btn;
	
	@FindBy(css="[class*=flyInOut]")
	WebElement error_msg;
	//[class*=flyInOut]
	
	//div[@class='ng-tns-c4-5 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
	
	public ProductsPage loginApp(String email, String password) //action methods
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		login_btn.click();
		ProductsPage productPage = new ProductsPage(driver);
		return productPage;
	}
	
	public String getErrorMsg() 
	{
		waitForWebElementToAppear(error_msg);
		return error_msg.getText();
	}
	
	public void goTo() //action methods
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}

}

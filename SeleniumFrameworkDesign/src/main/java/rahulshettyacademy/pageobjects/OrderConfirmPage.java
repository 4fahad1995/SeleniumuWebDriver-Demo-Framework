package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class OrderConfirmPage extends AbstractComponents {
	
	WebDriver driver;

	public OrderConfirmPage(WebDriver driver) //constructor
	{
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='hero-primary']")
	WebElement confirm_msg;
	
	public String confirmOrder() //action methods
	{
		//order cofirmation page
		return confirm_msg.getText();
	}
	
}

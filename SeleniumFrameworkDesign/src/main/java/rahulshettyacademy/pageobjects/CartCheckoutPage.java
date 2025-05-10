package rahulshettyacademy.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartCheckoutPage extends AbstractComponents {
	
	WebDriver driver;

	public CartCheckoutPage(WebDriver driver) //constructor
	{
		//initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@class='totalRow']//button")
	WebElement checkout_btn;
	
	@FindBy(xpath="//*[@class='cart']//h3")
	List<WebElement> cart_items;
	
	public Boolean verifyCorrectProduct(String productName)// action methods
	{
		Boolean match = cart_items.stream().anyMatch(s-> s.getText().equalsIgnoreCase(productName));
		return match;
	} 
	
	public PaymentsAndCountrySelectPage checkOutPage() 
	{
		checkout_btn.click();//go to payments page
		PaymentsAndCountrySelectPage selectCountry = new PaymentsAndCountrySelectPage(driver);
		return selectCountry;
	}
	

}

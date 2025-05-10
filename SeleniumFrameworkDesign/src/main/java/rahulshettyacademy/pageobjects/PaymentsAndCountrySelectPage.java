package rahulshettyacademy.pageobjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class PaymentsAndCountrySelectPage extends AbstractComponents {
	String country_name = "India";
	WebDriver driver;

	public PaymentsAndCountrySelectPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory
	@FindBy(css=".ta-item")
	List<WebElement> country_list;
	
	@FindBy(xpath="//*[@class='actions']//a")
	WebElement place_order;
	
	@FindBy(xpath="//*[@placeholder= 'Select Country']")
	WebElement select_country;
		
	By country = By.cssSelector(".ta-results");
		
	public List<WebElement> getCountryList() //action methods
	{
		select_country.sendKeys("ind");
		waitForElementToAppear(country);
		return country_list;
	}
	public List<WebElement> selectCountry()//action methods
	{
		List<WebElement> selectedCountry = country_list.stream().filter(s-> s.getText().
				equalsIgnoreCase(country_name)).collect(Collectors.toList());//filter the required country and collect into list
		return selectedCountry;
	}
	public OrderConfirmPage placeOrder() 
	{
		selectCountry().get(0).click();//select the country
		place_order.click();//go to final page
		OrderConfirmPage confirm = new OrderConfirmPage(driver);
		return confirm;
	}

}

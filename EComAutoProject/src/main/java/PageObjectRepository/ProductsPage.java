package PageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) //constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[data-test*= 'inventory-item-description']")
	List<WebElement> product_list;
	
	
	By invent_btn = By.cssSelector("[class*='btn_inventory']");
	By cart_btn = By.cssSelector("[class*='shopping_cart_link']");
	By checkout = By.cssSelector("[name='checkout']");
	
	public WebElement getProductByName(String productName) {
		WebElement prod = product_list.stream().filter(
				s -> s.findElement(By.cssSelector("[class*='inventory_item_name ']")).getText().equals(productName))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void addProduct(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(invent_btn).click();
		driver.findElement(cart_btn).click();
		driver.findElement(checkout).click();        //Cart Page
	}

}

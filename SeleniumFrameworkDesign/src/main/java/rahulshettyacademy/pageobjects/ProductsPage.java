package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ProductsPage extends AbstractComponents {
	
	WebDriver driver;

	public ProductsPage(WebDriver driver) //constructor
	{
		// initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory
	@FindBy(css=".mb-3")
	List<WebElement> product_list;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	
	By products = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".w-10"); //add to cart
	By toastMsg = By.id("toast-container");
	
	public List<WebElement> getProductList() //action methods
	{
		waitForElementToAppear(products);
		return product_list;
	}
	
	public WebElement getProductByName(String productName) //action methods
	{
		WebElement prod = getProductList().stream().filter(s-> s.findElement(By.cssSelector("b"))
				.getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException //action methods
	{
		WebElement prod = getProductByName(productName);// filter product name by name
		prod.findElement(addToCart).click(); //add to cart
		waitForElementToAppear(toastMsg);// add to cart acknowledgement message
		waitForElementToDisAppear(spinner);// loading animation
	}


}

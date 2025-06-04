package testCases;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjectRepository.PageObject;


public class E2E_ECom_Automation extends PageObject {

	@Test
	@Parameters({"user", "password"})
	public void E2E_Test(String user, String password) throws InterruptedException {
		String productName = "Sauce Labs Backpack";
		 
		
		 // Login Page 
		 login.GoTo();
		 login.loginApp(user, password);
		 
		 //Products Page
		 productPage.getProductByName(productName);
		 productPage.addProduct(productName);
		 
		
		// Add User Page
		driver.findElement(By.cssSelector("[name='firstName']")).sendKeys("Fahad");
		driver.findElement(By.cssSelector("[name='lastName']")).sendKeys("Khan");
		driver.findElement(By.cssSelector("[name='postalCode']")).sendKeys("123456");
		driver.findElement(By.cssSelector("[name='continue']")).click();

		// Product Overview Page
		System.out.println(driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());

		// Order Confirm Page
		driver.findElement(By.cssSelector("[name='finish']")).click();
		System.out.println(driver.findElement(By.cssSelector("[class*='complete-header']")).getText());
		
	}
}

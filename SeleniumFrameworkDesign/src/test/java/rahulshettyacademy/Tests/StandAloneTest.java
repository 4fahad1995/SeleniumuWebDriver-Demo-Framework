package rahulshettyacademy.Tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		String productName = "ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//LandingPage landingPage = new LandingPage(driver);
		//Login page
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.xpath("//input[@id = 'userEmail']")).sendKeys("fahad@email.com");
		driver.findElement(By.xpath("//input[@id = 'userPassword']")).sendKeys("Khamgaon1");
		driver.findElement(By.xpath("//input[@id= 'login']")).click();
		//Products page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> product_list =driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = product_list.stream().filter(s-> s.findElement(By.cssSelector("b"))
				.getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".w-10")).click(); //add to cart
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		Thread.sleep(500);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();// go to cart checkout page
		//Cart checkout page
		List<WebElement> cart_items = driver.findElements(By.xpath("//*[@class='cart']//h3"));
		Boolean match = cart_items.stream().anyMatch(s-> s.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//*[@class='totalRow']//button")).click();//go to payments page
		//Payments and country selection page 
		driver.findElement(By.xpath("//*[@placeholder= 'Select Country']")).sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		List<WebElement> countries = driver.findElements(By.cssSelector(".ta-item"));
		
		List<WebElement> selectCountry = countries.stream().filter(s-> s.getText().equalsIgnoreCase("India")).collect(Collectors.toList());
		selectCountry.get(0).click();
		driver.findElement(By.xpath("//*[@class='actions']//a")).click();//go to final page
		//order cofirmation page
		String confirm_msg = driver.findElement(By.xpath("//*[@class='hero-primary']")).getText();
		Assert.assertTrue(confirm_msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.close();

	}

}

package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void intializeDriver() 
	{
	    // Initialize driver
	    WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static WebDriver getDriverObj() 
	{
		return driver;
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeDriver() 
	{
		driver.quit();
	}

}

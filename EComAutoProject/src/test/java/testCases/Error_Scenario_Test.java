package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjectRepository.PageObject;

public class Error_Scenario_Test extends PageObject
{
	@Test(enabled = true )
	@Parameters({"inv_user", "inv_password"})
	public void IncorrectUserPass(String user, String password) 
	{
		// Login Page 
		login.GoTo();
		login.loginApp(user, password);
		String error_msg = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
		Assert.assertEquals(error_msg, "The error message when invalid user trying to login is not as expected.");
	}
	
	@Test(enabled = true)
	public void LoginRedirectTest() 
	{
		driver.get("https://www.saucedemo.com/inventory.html");
		String error_msg = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
		Assert.assertEquals(error_msg, "Unable to access inventory page without login.");
	}
	
	@Test(enabled = true)
	@Parameters({"user", "password"})
	public void SessionAfterLogoutTest(String user, String password) {
		login.GoTo();
		login.loginApp(user, password);
		sideMenu.SideMenuClick_and_Logout();
		driver.navigate().back();
		String error_msg = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
		Assert.assertEquals(error_msg, "Unable to access inventory page without login.");
	}

}

package rahulshettyacademy.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.ProductsPage;

public class ErrorValidations extends BaseTest {

	@Test
	public void StandAloneTst() throws IOException, InterruptedException
	{
		String productName = "ZARA COAT 3";
		ProductsPage productPage = landingPage.loginApp("fahad@email.com", "Khamgaon");//go to next page through object inside
		Assert.assertEquals("Incorrect mail or password", landingPage.getErrorMsg());
		

	}

}

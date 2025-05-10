package rahulshettyacademy.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartCheckoutPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderConfirmPage;
import rahulshettyacademy.pageobjects.PaymentsAndCountrySelectPage;
import rahulshettyacademy.pageobjects.ProductsPage;

public class StandAloneTest2 extends BaseTest {

	@Test
	public void StandAloneTst() throws IOException, InterruptedException
	{
		String productName = "ZARA COAT 3";
		//Login page
		LandingPage landingPage = launchApp();
		ProductsPage productPage = landingPage.loginApp("fahad@email.com", "Khamgaon1");//go to next page through object inside
		
		//Products page
		productPage.addProductToCart(productName);
		
		//Go to cart
		CartCheckoutPage checkoutPage = productPage.goToCartPage();//go to checkout page through object inside
		
		//Cart checkout page
		Boolean match = checkoutPage.verifyCorrectProduct(productName);
		Assert.assertTrue(match);
		PaymentsAndCountrySelectPage selectCountry = checkoutPage.checkOutPage();//go to country select page through object inside
		
		//Payments and country selection page 
		selectCountry.getCountryList();
		selectCountry.selectCountry();
		OrderConfirmPage confirm = selectCountry.placeOrder();// go to order confirm page through object inside
		
		//order cofirmation page
		String msg = confirm.confirmOrder();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));//confirm whether the message displayed is correct or not

	}

}

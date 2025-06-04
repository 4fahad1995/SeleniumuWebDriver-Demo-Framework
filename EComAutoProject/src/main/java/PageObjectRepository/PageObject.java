package PageObjectRepository;

import org.testng.annotations.BeforeMethod;

import testBase.BaseTest;

public class PageObject extends BaseTest {
	
	public LoginPage login;
	public ProductsPage productPage;
	public SideMenu sideMenu;
	
	@BeforeMethod
	public void initPageObjects() {
		login = new LoginPage(driver);
		productPage = new ProductsPage(driver);
		sideMenu = new SideMenu(driver);

	}

}

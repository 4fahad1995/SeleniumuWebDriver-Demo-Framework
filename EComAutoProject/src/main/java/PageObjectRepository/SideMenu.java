package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenu {
	
	public WebDriver driver;
	
	public SideMenu(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[id*='burger']")
	WebElement menu_btn;
	
	@FindBy(xpath = "//a[@id= 'logout_sidebar_link']")
	WebElement logout_btn;
	
	public void SideMenuClick_and_Logout() {
		menu_btn.click();
		logout_btn.click();
	}

}

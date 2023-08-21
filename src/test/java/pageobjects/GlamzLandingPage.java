package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class GlamzLandingPage extends CommonMethods {
	
	public 	WebDriver driver;
	public GlamzLandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "Login")
	WebElement loginbtn;
	
	public void clickloginbtn() {
		loginbtn.click();
	}
	
	
	
}

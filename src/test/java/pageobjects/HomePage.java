package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class HomePage extends CommonMethods {

	public 	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "/html/body/app-root/app-full-layout/div/div[1]/app-sidebar/div[2]/div[1]/ul/li[11]/a")
	WebElement Setupbtn;
	
	@FindBy (xpath = "//a[contains(@href,'/about')]")
	WebElement Aboutbtn;
	
	
	
	public void clickonabout() throws InterruptedException  {
		WaitForElementVisible(Setupbtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Setupbtn);
		Setupbtn.click();
		WaitForElementVisible(Aboutbtn);
		Aboutbtn.click();
	}
}

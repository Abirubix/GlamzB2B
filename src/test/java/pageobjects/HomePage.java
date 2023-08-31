package pageobjects;

import org.openqa.selenium.By;
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
	
	@FindBy (xpath = "//span[text()='Gallery']")
	WebElement Gallerybtn;
	
	@FindBy (xpath = "//div//ul//li//a[text()='Salon-Info']")
	WebElement SalonInfo;


	
	public void clickonabout() throws InterruptedException  {
		WaitForElementVisible(Setupbtn);
		Click(Setupbtn);
		WaitForElementVisible(Aboutbtn);
		Click(Aboutbtn);
		WaitForElementVisible(SalonInfo);
	}
	
	public void clickGallerybtn() throws InterruptedException {
		WaitForElementVisible(Gallerybtn);
		Click(Gallerybtn);
		
	}
}

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class AboutPagePersonalInfo extends CommonMethods {
	public 	WebDriver driver;
	public AboutPagePersonalInfo(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy (xpath="//*[@id=\"navbar\"]/ul/li[2]")
WebElement PersonalInfo;


String mobilenumber = "input[placeholder=\"CURRENT MOBILE NUMBER\"]";

public void clickonpersonalinfo() {

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PersonalInfo);
	PersonalInfo.click();
}
public String extractmobilenumber() throws InterruptedException {
    clickonpersonalinfo();
	
	String script = "var input = document.querySelector('" + mobilenumber
			+ "'); if (input) return input.value; else return null ;";
	String mobilenum = (String) ((JavascriptExecutor) driver).executeScript(script);
	return mobilenum;
	
}
}

package pageobjects;

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

String locvalue;
String mobilenumber = "input[placeholder=\"CURRENT MOBILE NUMBER\"]";

public void clickonpersonalinfo() throws InterruptedException {

	Click(PersonalInfo);
}
public String extractmobilenumber() throws InterruptedException {
    clickonpersonalinfo();
    locvalue = "cssSelector";
   return  getDisabledElements(mobilenumber, locvalue);
	
}
}

package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class AboutPagePersonalInfo extends CommonMethods {
	public WebDriver driver;

	public AboutPagePersonalInfo(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[2]")
	WebElement PersonalInfo;

	@FindBy(xpath = "//label[normalize-space()='Login Credentials']")
	WebElement logincredentialtitle;

	@FindBy(xpath = "//label[normalize-space()='Notification Settings']")
	WebElement notificationsettingtitle;

	@FindBy(xpath = "//span[normalize-space()='Receive SMS notifications']")
	WebElement recievesms;

	@FindBy(xpath = "//p[@class='mt-2 smstext']")
	WebElement texts1;

	@FindBy(xpath = "//label[normalize-space()='Unlist Company']")
	WebElement texts2;

	@FindBy(xpath = "//p[contains(text(),'PLEASE CONTACT THE SUPPORT TEAM TO UNLIST YOUR SAL')]")
	WebElement texts3;
	
	@FindBy(xpath = "//p[normalize-space()='EMAIL: support@glamz.com']")
	WebElement texts4;
	
	@FindBy(xpath = "//p[contains(text(),'PHONE LANDLINE:')]")
	WebElement texts5;
	
	@FindBy(xpath = "//p[contains(text(),'BUSINESS WHATSAPP:')]")
	WebElement texts6;
	
	@FindBy(xpath = "//p[contains(text(),'Unlisting a company will remove it from the public')]")
	WebElement texts7;
	
	@FindBy(xpath = "//div[@class='detail']//p[2]")
	WebElement texts8;
	
	@FindBy(xpath = "//p[contains(text(),'You will still have unlimited access to your accou')]")
	WebElement texts9;
	

	String locvalue;
	String mobilenumber = "input[placeholder=\"CURRENT MOBILE NUMBER\"]";

	public void clickonpersonalinfo() throws InterruptedException {

		Click(PersonalInfo);
	}

	public String extractmobilenumber() throws InterruptedException {
		clickonpersonalinfo();
		locvalue = "cssSelector";
		return getDisabledElements(mobilenumber, locvalue);

	}

	public void verifyTitles() {
		isDisplayed(logincredentialtitle);
		isDisplayed(notificationsettingtitle);
	}

	public void verifySms() {
		isDisplayed(recievesms);
	}

	public void textVerification() {
		isDisplayed(texts1);
		isDisplayed(texts2);
		isDisplayed(texts3);
		isDisplayed(texts4);
		isDisplayed(texts5);
		isDisplayed(texts6);
		isDisplayed(texts7);
		isDisplayed(texts8);
		isDisplayed(texts9);

	}
	
}

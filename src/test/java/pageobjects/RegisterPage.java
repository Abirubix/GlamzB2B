package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class RegisterPage extends CommonMethods {
	public WebDriver driver;

	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.btnlist.btn.btn-outline-danger[href='/register']")
	WebElement button;

	@FindBy(css = "input[formcontrolname='fullName']")
	WebElement firstName;

	@FindBy(css = "input[formcontrolname='phone']")
	WebElement mobileNumber;

	@FindBy(css = "input[formcontrolname='email']")
	WebElement emailAddress;

	@FindBy(css = "input[formcontrolname='password']")
	WebElement emailPassword;

	@FindBy(css = "input[formcontrolname='confirmPassword']")
	WebElement confirmPassword;

	@FindBy(css = "input[formcontrolname='salonName']")
	WebElement salonName;

	@FindBy(xpath = "//ng-select[@formcontrolname='salonType']")
	WebElement dropdownArrow;

	@FindBy(xpath = "//*[@id=\'regestration\']/div/div/div/div/div/div/div[2]/form/div[8]/ng-select/div")
	WebElement dealorType;
	
	By dealorTypeby = By.xpath("//*[@id=\'regestration\']/div/div/div/div/div/div/div[2]/form/div[8]/ng-select/div");

	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted' and text()='Exempt Dealer (No VAT)']")
	WebElement dealorValue;

	@FindBy(css = "input[formcontrolname='address']")
	WebElement address;

	@FindBy(id = "auth-login")
	WebElement checkbox;

	@FindBy(css = "button.btn.btn-primary.registerbtn")
	WebElement registerButton;

	public void clickbutton() {
		button.click();
	}

	public void fieldvalidations(List<String> str) throws InterruptedException {
		Enter(firstName, str.get(0));
		Enter(mobileNumber, str.get(1));
		Enter(emailAddress, str.get(2));
		Enter(emailPassword, str.get(3));
		Enter(confirmPassword, str.get(4));
		Enter(salonName, str.get(5));
		Enter(address, str.get(6));
	}


	public void dropdownvalidations() throws InterruptedException {
		Click(dropdownArrow);
		for (int i = 1; i <= 8; i++) {
			String locator = "//div[@class='ng-dropdown-panel-items scroll-host']//div//div[" + i + "]//span";
			WebElement options = (WebElement) driver.findElement(By.xpath(locator));
			Click(options);
            Click(dropdownArrow);
		}
		Click(dropdownArrow);

		Thread.sleep(500);
		//WaitForPresenceOfWebElement(dealorTypeby);		//WaitForElementClickable(dealorType);
		Click(dealorType);
		Click(dealorValue);

	}
	
	public void selectCheckbox() throws InterruptedException {
		scrollToElement(checkbox);
		selectCheckbox(checkbox);
		Thread.sleep(1000);
	}
	
	public void clickRegister() throws InterruptedException {
		Click(registerButton);
	}

}

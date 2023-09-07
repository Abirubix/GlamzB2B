package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class AboutPagePersonalInfoPhone extends CommonMethods {
	public 	WebDriver driver;
	public AboutPagePersonalInfoPhone(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	String phonefieldstring = "input[placeholder=\"CURRENT MOBILE NUMBER\"]";
	String popupphonefieldstring = "body > modal-container > div > div > app-personal-compaign > form > div.modal-body > div > div > div.form-group.mb-2.align-label.px-2 > input";
	String loctype = "cssSelector";
			
	@FindBy(xpath="//label[normalize-space()='Mobile Phone for Login']")
	WebElement mobilephonelabel;
	
	@FindBy(xpath="//div[@class='row cardcontent']//div[2]//div[1]//div[2]//button[1]")
	WebElement editbutton;
	
	@FindBy(xpath="//input[@placeholder='CURRENT MOBILE NUMBER']")
	WebElement mobilenumberfield;
	
	@FindBy(xpath="//h4[@class='modal-title']")
	WebElement editmobilenumbertitle;
	
	@FindBy(xpath="//i[@class='ft-x-circle font-medium-3']")
	WebElement crossmark;
	
	@FindBy(xpath="//label[normalize-space()='CURRENT MOBILE NUMBER']")
	WebElement currentmobilenumberlabel;
	
	@FindBy(xpath="//div[@class='form-group mb-2 align-label px-2']//input[@type='text']")
	WebElement currentmobilenumbervalue;
	
	@FindBy(xpath="//label[normalize-space()='NEW MOBILE NUMBER']")
	WebElement newmobilenumberlabel;
	
	@FindBy(xpath="//input[@placeholder='Enter your mobile number']")
	WebElement newmobilenumberfield;
	
	@FindBy(xpath="//label[normalize-space()='CONFIRMATION CODE']")
	WebElement confirmationcodelabel;
	
	@FindBy(xpath="//input[@placeholder='Enter your 6 digit otp number']")
	WebElement confirmationcodefield;
	
	@FindBy(xpath="//button[normalize-space()='SEND VERIFICATION CODE']")
	WebElement sendverificationbutton;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement popupsavebutton;
	
	@FindBy(xpath="//button[normalize-space()='Cancel']")
	WebElement popupcancelbutton;

	@FindBy(xpath="//span[normalize-space()='Mobile no starts with 05 and contains 10 digits']")
	WebElement mobilenumberInstructionmsg;
	
	@FindBy(xpath="//div[@aria-label='otp sent successfully']")
	WebElement otpsentmessage;
	
	@FindBy(css="div[aria-label='Invalid OTP']")
	WebElement invalidotpmsg;
	
	@FindBy(xpath="//span[normalize-space()='Enter your 6 digit otp number']")
	WebElement otpinstructionmsg;
	
	public void validateLabelsAndButtons() {
		isDisplayed(mobilephonelabel);
		isDisplayed(editbutton);
	}

	public String mobilePhoneNonEditable() {
		highlight(mobilenumberfield);
		 String flag = mobilenumberfield.getAttribute("readonly");
		 return flag;
	}

	public void clickOnEdit() throws InterruptedException {
		Thread.sleep(700);
		WaitForElementClickable(editbutton);
		
		Click(editbutton);
	}

	public void validateLabelsAndButtonsinPopup() {
		isDisplayed(editmobilenumbertitle);
		isDisplayed(crossmark);
		isDisplayed(currentmobilenumberlabel);
		isDisplayed(currentmobilenumbervalue);
		isDisplayed(newmobilenumberlabel);
		isDisplayed(confirmationcodelabel);
		isDisplayed(sendverificationbutton);
		isDisplayed(popupsavebutton);
		isDisplayed(popupcancelbutton);
		
	}

	public List<String> validateEmailInPopup() throws InterruptedException {
		Click(popupcancelbutton);
		waitForElementInvisible(popupcancelbutton);
		String phone =getDisabledElements(phonefieldstring, loctype);
		WaitForElementVisible(editbutton);
		WaitForElementClickable(editbutton);
		Click(editbutton);
		String phonepopup = getDisabledElements(popupphonefieldstring, loctype);
		ArrayList<String> phonevalues = new ArrayList<String>();
		phonevalues.add(phone);
		phonevalues.add(phonepopup);
       

		return phonevalues;
	}

	public void enterInvalidPhoneNumber(String string) throws InterruptedException{
		Enter(newmobilenumberfield, string);
		isDisplayed(mobilenumberInstructionmsg);
		
	}

	public void enterValidPhoneNumber(String string) throws InterruptedException {
		clear_default(newmobilenumberfield);
		Enter(newmobilenumberfield, string);
	}

	public void sendVerificationCode() throws InterruptedException {
		Click(sendverificationbutton);
		//isDisplayed(otpsentmessage);
		WaitForElementVisible(otpsentmessage);
		waitForElementInvisible(otpsentmessage);

	}

	public void enterWrongOtp(String string) throws InterruptedException {
		clear_default(confirmationcodefield);
		Enter(confirmationcodefield, string);
		Click(popupsavebutton);
		
	}

	public void invalidOtpMsgDisplayed() {
		WaitForElementVisible(invalidotpmsg);
		waitForElementInvisible(invalidotpmsg);		
	}

	public void otpInstructionMsg() {
		WaitForElement(otpinstructionmsg);
		//waitForElementInvisible(otpinstructionmsg);
		//isDisplayed(otpinstructionmsg);
	}

	public void clickOnCancelbutton() throws InterruptedException {
		Click(popupcancelbutton);
	}

	public void clickonCrossMark() throws InterruptedException {
		Click(crossmark);
	}

	public void entersmallerotp(String str) throws InterruptedException {
		clear_default(confirmationcodefield);
		Enter(confirmationcodefield,str);
	}
	
	

	
}

package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class AboutPagePersonalInfoEmail extends CommonMethods {
	public 	WebDriver driver;
	public AboutPagePersonalInfoEmail(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public String emailfieldstring = "input[placeholder=\"EMAIL\"]";
	public String popupemailvaluestring = "body > modal-container > div > div > app-personal-compaign-email > form > div.modal-body > div > div > div:nth-child(1) > input";
	public String loctype = "cssSelector";
	By editbuttonby = By.xpath("//div[4]//div[1]//div[2]//button[1]");
	@FindBy(xpath = "//input[@placeholder='EMAIL']")
	WebElement emailfield;
	
	@FindBy(xpath = "//label[normalize-space()='EMAIL']")
	WebElement emailfieldlabel;
	
	@FindBy(xpath = "//div[4]//div[1]//div[2]//button[1]")
	WebElement editbutton;
	
	@FindBy(xpath = "//h4[@class='modal-title']")
	WebElement editemailtitle;
	
	@FindBy(xpath = "//i[@class='ft-x-circle font-medium-3']")
	WebElement editemailclose;
	
	@FindBy(xpath="//label[normalize-space()='Email']")
	WebElement popupemaillabel;
	
	@FindBy(xpath="//div[@class='form-group mb-2 align-label px-2']//input[@type='text']")
	WebElement popupemailvalue;
	
	@FindBy(xpath="//label[normalize-space()='NEW EMAIL']")
	WebElement popupnewemaillabel;
	
	@FindBy(xpath="//label[normalize-space()='EMAIL CONFIRMATION']")
	WebElement popupconfirmnewemaillabel;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement popupsavebutton;
	
	@FindBy(xpath="//button[normalize-space()='Cancel']")
	WebElement popupcancelbutton;
	
	@FindBy(xpath="//input[@id='newemail']")
	WebElement popupnewemailfield;
	
	@FindBy(xpath="//input[@id='confirmEmail']")
	WebElement popupcofirmnewemailfield;
	
	@FindBy(xpath="//div[@aria-label='Email Already Exist']")
	WebElement emailexistserror;
	
	@FindBy(xpath="//div[@class='mb-2']//span[contains(text(),'Invalid Email')]")
	WebElement popupnewemailinvaliderror;
	
	@FindBy(xpath="(//div[@class='alert-icon-right']//span[1])[2]")
	WebElement popupconfirmnewemailinvaliderror;
	
	@FindBy(xpath="//div[@aria-label='Updated Successfully']")
	WebElement successfullyupdatedmsg;
	
	@FindBy(xpath="//div[@aria-label='Email and Confirm email are not same']")
	WebElement emailsnotsamemsg;
	
	@FindBy(xpath="//div[@aria-label='Invalid Email']")
	WebElement invalidemailmsg;
	
	public void validateLabelAndEditButton() {
		isDisplayed(editbutton);
		isDisplayed(emailfieldlabel);
	}
	public String emailFieldNonEditable() {
		highlight(emailfield);
		 String flag = emailfield.getAttribute("readonly");
		return flag;
	}
	public void clickOnEdit() throws InterruptedException {
	
		Thread.sleep(700);
		WaitForElementClickable(editbutton);
		
		Click(editbutton);
		
	}
	public void validateEmaiLPopup() {
		isDisplayed(editemailtitle);
		isDisplayed(popupemaillabel);
		isDisplayed(editemailclose);
		isDisplayed(popupemailvalue);
		isDisplayed(popupnewemaillabel);
		isDisplayed(popupconfirmnewemaillabel);
		isDisplayed(popupsavebutton);
		isDisplayed(popupcancelbutton);
        isEnabled(popupnewemailfield);
        isEnabled(popupcofirmnewemailfield);
	}
	public List<String> validateEmailinPopup() throws InterruptedException {
		Click(popupcancelbutton);
		waitForElementInvisible(popupcancelbutton);
	
		String email =getDisabledElements(emailfieldstring, loctype);
		WaitForElementVisible(editbutton);
		WaitForElementClickable(editbutton);
		Click(editbutton);
		//Thread.sleep(2000);
		String emailinpopup = getDisabledElements(popupemailvaluestring, loctype);
		ArrayList<String> emailvalues = new ArrayList<String>();
		emailvalues.add(email);
		emailvalues.add(emailinpopup);

		return emailvalues;
	}

	public void EnterSameEmail() throws InterruptedException {
		 String emailinpopup = getDisabledElements(popupemailvaluestring, loctype);
			Enter(popupnewemailfield,emailinpopup);
			Enter(popupcofirmnewemailfield,emailinpopup);
		
	}
	public void sameEmailValidations() throws InterruptedException {
		Click(popupsavebutton);
		//Thread.sleep(3000);

		WaitForElementVisible(emailexistserror);
		waitForElementInvisible(emailexistserror);
		
	}

	public void clearingEmailField(String str) throws InterruptedException {
		
		clear_default(popupcofirmnewemailfield);
		clear_default(popupnewemailfield);
		Click(popupsavebutton);
		isDisplayed(popupconfirmnewemailinvaliderror);
		isDisplayed(popupnewemailinvaliderror);
		WaitForElementVisible(invalidemailmsg);
		waitForElementInvisible(invalidemailmsg);
	}
	public void enteringEmails(String str, String str1) throws InterruptedException {
		clear_default(popupnewemailfield);
		clear_default(popupcofirmnewemailfield);
		Enter(popupnewemailfield, str);
		Enter(popupcofirmnewemailfield, str1);
	}
	public void successfullyEntered() throws InterruptedException {
		Click(popupsavebutton);
		WaitForElementVisible(successfullyupdatedmsg);
		waitForElementInvisible(successfullyupdatedmsg);
		
	}
	public String emailDisplayed() throws InterruptedException {
		String email =getDisabledElements(emailfieldstring, loctype);
		return email;
	}
	public  void emailsNotSame() throws InterruptedException {
		Click(popupsavebutton);
		WaitForElementVisible(emailsnotsamemsg);
		waitForElementInvisible(emailsnotsamemsg);
	}
	public void invalidEmailErrorDispalyed() throws InterruptedException {
		Click(popupsavebutton);
		isDisplayed(popupnewemailinvaliderror);
		WaitForElementVisible(invalidemailmsg);
		waitForElementInvisible(invalidemailmsg);
	}
	public void validateCancelButton() throws InterruptedException {
		Click(popupcancelbutton);
	}
	public void validateCrossMark() throws InterruptedException {
		Click(editemailclose);
	}
	
	
	
	
}

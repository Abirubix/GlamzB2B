package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class AboutPagePersonalInfoPassword extends CommonMethods {
	public WebDriver driver;

	public AboutPagePersonalInfoPassword(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[normalize-space()='PASSWORD']")
	WebElement passwordlabel;

	@FindBy(xpath = "//input[@placeholder='PASSWORD']")
	WebElement passwordfield;

	@FindBy(xpath = "//div[5]//div[1]//div[2]//button[1]")
	WebElement editbutton;

	@FindBy(xpath = "//h4[@class='modal-title']")
	WebElement editpasswordtitle;

	@FindBy(xpath = "//i[@class='ft-x-circle font-medium-3']")
	WebElement crossmark;

	@FindBy(xpath = "//label[normalize-space()='Password']")
	WebElement popuppasswordlabel;

	@FindBy(xpath = "//input[@id='password']")
	WebElement popuppasswordfield;

	@FindBy(xpath = "//label[normalize-space()='NEW PASSWORD']")
	WebElement newpasswordlabel;

	@FindBy(xpath = "//input[@id='passwordNew']")
	WebElement newpasswordfield;

	@FindBy(xpath = "//label[normalize-space()='CONFIRM NEW PASSWORD']")
	WebElement confirmnewpasswordlabel;

	@FindBy(xpath = "//input[@id='confirmPassword']")
	WebElement confirmnewpasswordfield;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement popupsavebutton;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement popupcancelbutton;

	@FindBy(xpath = "//div[@class='help-block mt-1 text-danger align-header ng-star-inserted']")
	WebElement passwordmustmatchmsg;

	@FindBy(xpath = "//div[@class='mb-1']//div[1]")
	WebElement passwordisrequiredmsg;

	@FindBy(xpath = "//div[@class='mb-3']//div[1]")
	WebElement confirmpswdrequiredmsg;
	
	@FindBy(xpath = "//div[@class='mb-1']//div[1]")
	WebElement passwordrulesnewpassword;
	
	@FindBy(xpath = "//div[@aria-label='Updated Successfully']")
	WebElement updatedsuccessfullymsg;

	public void validateLabelsAndButtons() {
		isDisplayed(passwordlabel);
		isDisplayed(editbutton);
	}

	public String passwordNonEditable() {
		highlight(passwordfield);
		String flag = passwordfield.getAttribute("readonly");
		return flag;
	}

	public void clickOnEdit() throws InterruptedException {
		Thread.sleep(700);
		WaitForElementClickable(editbutton);
		Click(editbutton);
	}

	public void ValidatesLabelsAndFieldsInPopup() {
		isDisplayed(editpasswordtitle);
		isDisplayed(crossmark);
		isDisplayed(popuppasswordlabel);
		isDisplayed(popuppasswordfield);
		isDisplayed(newpasswordlabel);
		isDisplayed(confirmnewpasswordlabel);
		isDisplayed(popupsavebutton);
		isDisplayed(popupcancelbutton);

	}

	public String passwordNonEditableInPopUp() {
		String flag = popuppasswordfield.getAttribute("readonly");
		return flag;
	}

	public void enterPasswordFields(String string, String string2) throws InterruptedException {
		clear_default(newpasswordfield);
		clear_default(confirmnewpasswordfield);
		Enter(newpasswordfield, string);
		Enter(confirmnewpasswordfield, string2);

	}

	public String passwordMustMatchErrorObtaibed() throws InterruptedException {
		Click(popupsavebutton);
		isDisplayed(passwordmustmatchmsg);
		return passwordmustmatchmsg.getText();
	}

	public String errorMessageOnClearNewPassword() {
		clear_default(newpasswordfield);
		isDisplayed(passwordisrequiredmsg);
		String flag = passwordisrequiredmsg.getText();
		return flag;
	}

	public String errorMessageOnClearConfirmNewPassword() {
		clear_default(confirmnewpasswordfield);
		isDisplayed(confirmpswdrequiredmsg);
		String flag = confirmpswdrequiredmsg.getText();
		return flag;
	}

	public void EnterNewPasswordField(String string) throws InterruptedException {
		clear_default(newpasswordfield);
		Enter(newpasswordfield,string);
		
	}

	public String errorMessageOnshorterpswd() {
		String flag = passwordrulesnewpassword.getText();
		return flag;		
	}

	public void clickOnSave() throws InterruptedException {
		Click(popupsavebutton);
		WaitForElementVisible(updatedsuccessfullymsg);
		waitForElementInvisible(updatedsuccessfullymsg);
	}

	public void clickOnCancel() throws InterruptedException {
		Click(popupcancelbutton);
	}

	public void clickOnCrossMark() throws InterruptedException {
		Click(crossmark);
	}
	

}

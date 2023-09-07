package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class AboutPagePersonalInfoName extends CommonMethods{
	public 	WebDriver driver;
	public AboutPagePersonalInfoName(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String namefieldString = "input[formcontrolname=\"fullName\"]";
	public String locvalue = "cssSelector";
			
	@FindBy(xpath = "//input[@formcontrolname='fullName']")
	WebElement namefield;
	
	@FindBy(xpath = "//label[text()='NAME']")
	WebElement namefieldlabel;
	
	@FindBy(xpath = "//button[@class='btn btn-secondary ng-star-inserted']")
	WebElement editbutton;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancelbutton;
	
	public void presenceOfLabelAndEdit() {
		isDisplayed(editbutton);
		isDisplayed(namefieldlabel);

	}
	public boolean nameFieldNonEditable() {
		highlight(namefield);
	    boolean flag=namefield.isEnabled();
	    return flag;
	}
	public void clickonedit() throws InterruptedException {
		Click(editbutton);
	}
	
	public boolean editNameField(String name) throws InterruptedException {
		Clear(namefield);
		boolean flag = namefield.isEnabled();
		Enter(namefield, name);
		return flag;
	}
	
	public void clickOnSave() throws InterruptedException {
		Click(savebutton);
	}
	public void clickOnEditAndCancel() throws InterruptedException {
		Click(editbutton);
		Click(cancelbutton);
	}
	public String extractName() throws InterruptedException {
		return getDisabledElements(namefieldString, locvalue);
	}
	

}

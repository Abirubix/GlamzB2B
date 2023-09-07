package pageobjects;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class EditAboutPageSalonInfo extends CommonMethods {
	public WebDriver driver;

	public EditAboutPageSalonInfo(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div//div[1]//div//input[@formcontrolname='contactNumber']")
	WebElement addonemorephonefirstfield;

	@FindBy(xpath = "//div[@class='col-md-12']//div[1]//div[1]//ngb-alert[1]//div[1]//span[1]")
	WebElement addonemorephonefirsterrormsg;

	@FindBy(xpath = "(//div[2]//div[1]//div[1]//ngb-alert[1]//div[1]//span[1])[2]")
	WebElement addonemorephoneseconderrormsg;

	@FindBy(xpath = "//div//div[3]//div//input[@formcontrolname='contactNumber']")
	WebElement addonemorephonesecondfield;

	@FindBy(xpath = "//div//button[text()='Add one more phone ']")
	WebElement addonemorephone;

	@FindBy(xpath = "//div[@class='row w-100']//div[2]//div//i")
	WebElement deleteextraphone;

	@FindBy(xpath = "//div[@role='dialog']//div//button[text()='Yes']")
	WebElement confirmdelete;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement savebtn;

	@FindBy(id = "toast-container")
	WebElement toastcontainer;

	@FindBy(xpath = "//button[text()='Edit']")
	WebElement editbtn;

	@FindBy(xpath = "//input[@formcontrolname=\"name\"]")
	WebElement NameField;

	@FindBy(xpath = "//ng-select[@formcontrolname='salontype']//div//span[@class='ng-arrow-wrapper']")
	WebElement salonTypearrow;

	@FindBy(xpath = "//ng-select[@formcontrolname='salontype']//div//span[@title='Clear all']")
	WebElement salonTypeclearall;

	@FindBy(xpath = "//div[@class='ng-dropdown-panel-items scroll-host']//div//div[@role='option'][1]")
	WebElement salontypefirstoption;

	@FindBy(xpath = "//ng-select[@formcontrolname='facilitytype']//div//span[@class='ng-arrow-wrapper']")
	WebElement Facilitiesarrow;

	@FindBy(xpath = "//ng-select[@formcontrolname='facilitytype']//div//span[@title='Clear all']")
	WebElement Facilitiesclearall;

	@FindBy(xpath = "//ng-select[@formcontrolname='facilitytype']//ng-dropdown-panel//div//div//div[@role='option'][1]")
	WebElement Facilitiesfirstoption;

	@FindBy(xpath = "//ng-select[@formcontrolname='taxType']//div//span[@class='ng-arrow-wrapper']")
	WebElement DealerTypearrow;

	@FindBy(xpath = "//ng-select[@formcontrolname='taxType']//div//span[@title='Clear all']")
	WebElement DealerTypeclearall;

	@FindBy(xpath = "//ng-dropdown-panel//div//div//div//span[text()='Exempt Dealer (No VAT)']")
	WebElement DealerTypefirstoption;

	@FindBy(xpath = "//input[@formcontrolname=\"floor\"]")
	WebElement Floor;

	@FindBy(xpath = "//input[@formcontrolname=\"apartment\"]")
	WebElement ApartmentName;

	@FindBy(xpath = "//input[@formcontrolname=\"buildingCode\"]")
	WebElement BuildingCode;

	@FindBy(xpath = "//textarea[@formcontrolname=\"address\"]")
	WebElement Address;

	@FindBy(xpath = "//textarea[@id='salondescription']")
	WebElement SalonDescription;

	@FindBy(xpath = "//input[@formcontrolname=\"landlineNumber\"]")
	WebElement LandLine;
	
	@FindBy(xpath = "//div[@aria-label='Updated Successfully']")
	WebElement updatedsuccesfullymsg;

	public void clickonedit() throws InterruptedException {
		highlight(editbtn);
		Click(editbtn);
		// Thread.sleep(1000);

	}

	public void clickonsave() throws InterruptedException {
		highlight(savebtn);
		Click(savebtn);
		toastcontainer.isDisplayed();
	}

	public boolean checkfieldsenabled() {
		boolean status;
		boolean namefield = NameField.isEnabled();
		boolean salontype = salonTypearrow.isEnabled();
		boolean facilities = Facilitiesarrow.isEnabled();
		boolean dealertype = DealerTypearrow.isEnabled();
		boolean floor = Floor.isEnabled();
		boolean aprtmentname = ApartmentName.isEnabled();
		boolean buildingcode = BuildingCode.isEnabled();
		boolean address = Address.isEnabled();
		boolean description = SalonDescription.isEnabled();
		boolean landline = LandLine.isEnabled();
		status = namefield && floor && aprtmentname && buildingcode && address && salontype && facilities && dealertype
				&& description && landline;
		return status;
	}

	public void editvalidations(List<String> str) {

		edits(NameField, str.get(0));
		edits(Floor, str.get(1));
		edits(ApartmentName, str.get(2));
		edits(BuildingCode, str.get(3));
		edits(Address, str.get(4));
		edits(SalonDescription, str.get(5));
		edits(LandLine, str.get(6));
	}

	public void editdropdownvalidations() throws InterruptedException {
		Stream.of(salonTypeclearall, salonTypearrow, salontypefirstoption, Facilitiesclearall, Facilitiesarrow,
				Facilitiesfirstoption, DealerTypeclearall, DealerTypearrow, DealerTypefirstoption).forEach(s -> {
					try {
						Click(s);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});

	}

	public void deleteExtraPhone() throws InterruptedException {
		Click(deleteextraphone);
		Click(confirmdelete);
	}

	public void edits(WebElement ele, String str) {
		highlight(ele);
		ele.clear();
		ele.sendKeys(str);
	}

	public void clickonaddphone() throws InterruptedException {
		Click(addonemorephone);
	}

	public void addOneMorePhoneNotVisible() {
		waitForElementInvisible(addonemorephone);
	}

	public String enterAdditionalFirstPhoneWithError(String string) throws InterruptedException {
		Enter(addonemorephonefirstfield, string);
		highlight(addonemorephonefirsterrormsg);
		return addonemorephonefirsterrormsg.getText();
	}

	public String enterAdditionalSecondPhoneWithError(String string) throws InterruptedException {
		Enter(addonemorephonesecondfield, string);
		Thread.sleep(2000);
		highlight(addonemorephoneseconderrormsg);
		return addonemorephoneseconderrormsg.getText();

	}

	public void editAdditionalPhoneFirstField(String string) throws InterruptedException {
		Clear(addonemorephonefirstfield);
		Enter(addonemorephonefirstfield, string);
		waitForElementInvisible(addonemorephonefirsterrormsg);
	}

	public void editAdditionalPhoneSecondField(String string) throws InterruptedException {
		Clear(addonemorephonesecondfield);
		Enter(addonemorephonesecondfield, string);
		waitForElementInvisible(addonemorephoneseconderrormsg);
	}

	public void deleteFirstAdditionalPhoneNumber() throws InterruptedException {
		Click(deleteextraphone);
		Click(confirmdelete);
	}

	public void addOneMorePhoneVisible() {
		addonemorephone.isDisplayed();
	}

	public void succesfullyAddedMsg() {
		WaitForElementVisible(updatedsuccesfullymsg);
		waitForElementInvisible(updatedsuccesfullymsg);
	}

}

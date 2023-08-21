package pageobjects;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class EditAboutPageSalonInfo extends CommonMethods{
	public WebDriver driver;

	public EditAboutPageSalonInfo(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement savebtn;

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

	public void clickonedit() throws InterruptedException {
		editbtn.click();

	}

	public void clickonsave() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", savebtn);
        WaitForElementVisible(savebtn);

		savebtn.click();

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

	public void editdropdownvalidations() {

		Stream.of(salonTypeclearall, salonTypearrow, salontypefirstoption, Facilitiesclearall, Facilitiesarrow,
				Facilitiesfirstoption, DealerTypeclearall, DealerTypearrow, DealerTypefirstoption).forEach(s -> s.click());

	}

	public void edits(WebElement ele, String str) {
		ele.clear();
		ele.sendKeys(str);
	}
}

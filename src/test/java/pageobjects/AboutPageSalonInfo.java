package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class AboutPageSalonInfo extends CommonMethods{
	
	public 	WebDriver driver;
	public AboutPageSalonInfo(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	String NameLabel = "//label[text()=\"Salon Name\"]";
	String SalonType = "//label[text()=\"Salon Type\"]";
	String FacititiesLabel= "//label[text()=\"Facilities\"]";
	String DealertypeLabel = "//label[text()=\"Dealer Type\"]";
	String FloorLabel = "//label[text()=\"Floor\"]";
	String AprtmentLabel = "//label[text()=\"Apartment\"]";
	String BuildingCodeLabel = "//label[text()=\"Building Code\"]";
	String SalonAddressLabel = "//label[text()=\"Salon Address\"]";
	String SalonDescriptionLabel = "//label[text()=\"Salon Description\"]";
	String MobileNumberLabel = "//label[text()=\"Mobile number\"]";
	String LandlineNumberLabel = "//label[text()=\"Landline Number\"]";
    String Mobilenumberfield = "input[formcontrolname=\"mobileNumber\"]";
    String locvalue;
	@FindBy (xpath = "//button[text()='Edit']")
	WebElement edit;
	
	@FindBy (xpath = "//div//ul//li//a[text()='Salon-Info']")
	WebElement SalonInfo;
	
	public boolean Labelvalidations() throws InterruptedException {
	boolean Namelabel=	MandateLabels(NameLabel);
	boolean Salontype=	MandateLabels(SalonType);
	boolean Facilitieslabel=	MandateLabels(FacititiesLabel);
	boolean Dealerlabel=	MandateLabels(DealertypeLabel);
	boolean Floorlabel= 	MandateLabels(FloorLabel);
	boolean Apartmentlabel=	MandateLabels(AprtmentLabel);
	boolean buildinglabel=	MandateLabels(BuildingCodeLabel);
	boolean Addresslabel=	MandateLabels(SalonAddressLabel);
	boolean Descriprionlabel=	Labels(SalonDescriptionLabel, "xpath");
	boolean Mobilenumlabel=	MandateLabels(MobileNumberLabel);
	boolean Landlinelabel=	Labels(LandlineNumberLabel, "xpath");
	boolean status = (Namelabel && Salontype && Facilitieslabel && Dealerlabel && Floorlabel && Apartmentlabel && buildinglabel 
			&& Addresslabel && Descriprionlabel && Mobilenumlabel && Landlinelabel);
return status;
	}

	public boolean MandateLabels(String str) throws InterruptedException {
        
		WebElement label = driver.findElement(By.xpath(str));
		boolean labeldisplayed = label.isDisplayed();
		for(int i=1;i<9;i++) {
			 highlight(label);
			}
		WebElement mandatory = driver.findElement(By.xpath(str + "//i"));
		boolean Mandatedisplayed = mandatory.isDisplayed();
		for(int i=1;i<9;i++) {
			 highlight(mandatory);
			}
		
		boolean status = labeldisplayed && Mandatedisplayed;
		return status;
	}

	public boolean Labels(String str, String loctype) throws InterruptedException {
		WebElement label = driver.findElement(By.xpath(str));
		boolean labeldisplayed = label.isDisplayed();
		for(int i=1;i<2;i++) {
		 highlight(label);
		}
		return labeldisplayed;
		
	}
	public String extractmobilenumber() throws InterruptedException {
		Click(SalonInfo);
		locvalue = "cssSelector";
		return getDisabledElements(Mobilenumberfield, locvalue);

	}
		

}

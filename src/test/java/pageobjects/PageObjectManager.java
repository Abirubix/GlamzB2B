package pageobjects;

import org.openqa.selenium.WebDriver;

import utils.TextContextSetup;

public class PageObjectManager {

	public GlamzLandingPage glamzlandingpage;
	public HomePage homepage;
	public LoginPage loginpage;
	public AboutPageSalonInfo aboutpage;
	public EditAboutPageSalonInfo editaboutpage;
	public AboutPagePersonalInfo aboutpersonalinfo;
	TextContextSetup textContextSetup;
	WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public GlamzLandingPage getglamzlandinpage() {
		return glamzlandingpage = new GlamzLandingPage(driver);
	}
	
	public LoginPage getloginpage() {
		return loginpage = new LoginPage(driver);
	}
	
	public HomePage gethomepage() {
		return homepage = new HomePage(driver);
	}
	
	public AboutPageSalonInfo getaboutpage() {
		return aboutpage = new AboutPageSalonInfo(driver);
	}
	
	public EditAboutPageSalonInfo geteditaboutpage() {
		return editaboutpage = new EditAboutPageSalonInfo(driver);
	}
	
	public AboutPagePersonalInfo getaboutpersonalinfo() {
		return aboutpersonalinfo = new AboutPagePersonalInfo(driver);
	}

}

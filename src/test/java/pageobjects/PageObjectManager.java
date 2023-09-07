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
	public RegisterPage registerpage;
	public AboutPagePersonalInfoName aboutpersonalinfonamepage;
	public AboutPagePersonalInfoEmail aboutpersonalinfoemailpage;
	public AboutPagePersonalInfoPhone aboutpersonalinfophonepage;
	public AboutPagePersonalInfoPassword aboutpersonalinfopasswordpage;
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
	
	public RegisterPage getregisterpage() {
		return  registerpage = new RegisterPage(driver);
	}
	
	public AboutPagePersonalInfoName getaboutpersonalinfoname() {
		return  aboutpersonalinfonamepage = new AboutPagePersonalInfoName(driver);
	}
	
	public AboutPagePersonalInfoEmail getaboutpersonalinfoemail() {
		return  aboutpersonalinfoemailpage = new AboutPagePersonalInfoEmail(driver);
	}
	
	public AboutPagePersonalInfoPhone getaboutpersonalinfophone() {
		return  aboutpersonalinfophonepage = new AboutPagePersonalInfoPhone(driver);
	}
	
	public AboutPagePersonalInfoPassword getaboutpersonalinfopassword() {
		return  aboutpersonalinfopasswordpage = new AboutPagePersonalInfoPassword(driver);
	}

}

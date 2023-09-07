package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.AboutPagePersonalInfo;
import pageobjects.AboutPageSalonInfo;
import utils.TextContextSetup;

public class AboutPersonalInfoPageStepDefintions {
	AboutPagePersonalInfo aboutpersonalinfo;
	AboutPageSalonInfo aboutsaloninfo;
	TextContextSetup textContextSetup;
	public  AboutPersonalInfoPageStepDefintions(TextContextSetup textContextSetup) {
		this.textContextSetup=textContextSetup;
	}

	@Then("User clicks on About->PersonalInfo")
	public void user_clicks_on_about_personal_info() throws InterruptedException {
		Thread.sleep(2000);
		aboutpersonalinfo=textContextSetup.pageobjectmanager.getaboutpersonalinfo();
	   aboutpersonalinfo.clickonpersonalinfo();
	}
	
	@Given("User extracts the mobile number from PersonalInfo and compares it with mobile number in SalonInfo")
	public void extract_phone_number_from_About_personalInfo_and_compares_with_saloninfo() throws InterruptedException{
//		aboutsaloninfo=textContextSetup.pageobjectmanager.getaboutpage();
//        AboutPageSalonInfo aboutsaloninfo = textContextSetup.pageobjectmanager.getaboutpage();
//        String saloninfonumber = aboutsaloninfo.extractmobilenumber();
        aboutpersonalinfo = textContextSetup.pageobjectmanager.getaboutpersonalinfo();
        Thread.sleep(3000);
        String personalinfonumber = aboutpersonalinfo.extractmobilenumber();
        System.out.println(personalinfonumber+"::personalinfonumber");
        System.out.println(textContextSetup.mobilenumbersaloninfo+"::textContextSetup.mobilenumbersaloninfo");
		Assert.assertEquals(textContextSetup.mobilenumbersaloninfo,personalinfonumber );
	}
	
	@Given("User verifies all the titles in the page")
	public void user_verifies_all_the_titles_in_the_page() {
		aboutpersonalinfo.verifyTitles();
	}
	@Then("User verifies Recieve sms notification button")
	public void user_verifies_recieve_sms_notification_button() {
		aboutpersonalinfo.verifySms();
	}
	@Then("User verifies all the texts in personal info page")
	public void user_verifies_all_the_texts_in_personal_info_page() throws InterruptedException {
		aboutpersonalinfo.textVerification();
		Thread.sleep(3000);

	}
}

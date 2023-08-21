package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.AboutPageSalonInfo;
import utils.TextContextSetup;

public class AboutSalonInfoPageStepDefinitions {
	TextContextSetup textContextSetup;
	AboutPageSalonInfo aboutpage;
	public String mobilenumbersaloninfo;
	public AboutSalonInfoPageStepDefinitions(TextContextSetup textContextSetup) {
		this.textContextSetup=textContextSetup;
	}
	@Then("User verify about screen is displayed")
	public void user_verify_about_screen_is_displayed() {
	   System.out.println("need to print title of page");
	}
	@Then("User verify all the labels and Edit button are displayed in about screen")
	public void user_verify_all_the_labels_and_edit_button_are_displayed_in_about_screen() throws InterruptedException {
	   aboutpage = textContextSetup.pageobjectmanager.getaboutpage();
	  Assert.assertTrue(aboutpage.Labelvalidations());
	  
	}
	@Given("User extracts the mobile number from SalonInfo")
	public void user_extracts_mobilenumber_from_saloninfo() {
		   aboutpage = textContextSetup.pageobjectmanager.getaboutpage();
		textContextSetup.mobilenumbersaloninfo = aboutpage.extractmobilenumber();
	}
	

}

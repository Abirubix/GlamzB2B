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
	   System.out.println("user is in about screen");
	}
	@Then("User verify all the labels and Edit button are displayed in about screen")
	public void user_verify_all_the_labels_and_edit_button_are_displayed_in_about_screen() throws InterruptedException {
	   aboutpage = textContextSetup.pageobjectmanager.getaboutpage();
	   Thread.sleep(2000);
	  Assert.assertTrue(aboutpage.Labelvalidations());
	  
	}
	@Given("User extracts the mobile number from SalonInfo")
	public void user_extracts_mobilenumber_from_saloninfo() throws InterruptedException {
		   aboutpage = textContextSetup.pageobjectmanager.getaboutpage();
		textContextSetup.mobilenumbersaloninfo = aboutpage.extractmobilenumber();
	}
	
	@Then("User verifies whether message box is dispalyed")
	public void user_verifies_whether_message_box_is_dispalyed() throws InterruptedException {
        aboutpage.verifyMesageBox();
		Thread.sleep(5000);

	}
	

}

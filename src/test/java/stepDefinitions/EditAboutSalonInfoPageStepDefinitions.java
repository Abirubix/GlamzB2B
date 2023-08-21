package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AboutPageSalonInfo;
import pageobjects.EditAboutPageSalonInfo;
import utils.TextContextSetup;

public class EditAboutSalonInfoPageStepDefinitions {
    EditAboutPageSalonInfo editaboutpage;
	TextContextSetup textContextSetup;
	AboutPageSalonInfo aboutpage;
	public EditAboutSalonInfoPageStepDefinitions(TextContextSetup textContextSetup) {
		this.textContextSetup=textContextSetup;
	}
	@When("User clicks edit button and verify all fields are enabled")
	public void user_clicks_edit_button_and_verify_all_fields_are_enabled() throws InterruptedException {
		textContextSetup.genericutils.sleep();
	   editaboutpage=textContextSetup.pageobjectmanager.geteditaboutpage();
		Thread.sleep(2000);

	   editaboutpage.clickonedit();
	   Assert.assertTrue(editaboutpage.checkfieldsenabled());
	}
	@When("User delete old data and enter new valid data in all editable fields in about screen")
	public void user_delete_old_data_and_enter_new_valid_data_in_all_editable_fields_in_about_screen(List<String> values) throws InterruptedException {

		editaboutpage.checkfieldsenabled();
		editaboutpage.editvalidations(values);
		Thread.sleep(3000);
	  
	}
	@When("User deletes the old data in dropdowns and selects the first value in dropdown")
	public void user_deletes_the_old_data_in_dropdowns_and_selects_the_first_value_in_dropdown() {
		editaboutpage.editdropdownvalidations();
	}
	@Then("User clicks on save button")
	public void user_clicks_on_save_button() throws InterruptedException {
	  editaboutpage.clickonsave();
	}
	
	@Then("User clicks on edit button")
	public void user_clicks_on_edit_button() throws InterruptedException {
	 editaboutpage.clickonedit();
	}
	@Then("User clicks on cancel button and checks wether the previously given data is present")
	public void user_clicks_on_cancel_button_and_checks_wether_the_previously_given_data_is_present() throws InterruptedException {
	   editaboutpage.clickonsave();
	}
}

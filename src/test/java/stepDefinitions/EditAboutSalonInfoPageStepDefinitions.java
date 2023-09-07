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
		this.textContextSetup = textContextSetup;
	}

	@When("User clicks edit button and verify all fields are enabled")
	public void user_clicks_edit_button_and_verify_all_fields_are_enabled() throws InterruptedException {
		editaboutpage = textContextSetup.pageobjectmanager.geteditaboutpage();
		Thread.sleep(2000);

		editaboutpage.clickonedit();
		Assert.assertTrue(editaboutpage.checkfieldsenabled());
	}

	@When("User delete old data and enter new valid data in all editable fields in about screen")
	public void user_delete_old_data_and_enter_new_valid_data_in_all_editable_fields_in_about_screen(
			List<String> values) throws InterruptedException {

		editaboutpage.checkfieldsenabled();
		editaboutpage.editvalidations(values);
		Thread.sleep(3000);

	}

	@When("User deletes the old data in dropdowns and selects the first value in dropdown")
	public void user_deletes_the_old_data_in_dropdowns_and_selects_the_first_value_in_dropdown() throws InterruptedException {
		Thread.sleep(3000);
		editaboutpage.editdropdownvalidations();
	}

	@Then("User clicks on save button")
	public void user_clicks_on_save_button() throws InterruptedException {
		editaboutpage.clickonsave();
	}

	@Then("User clicks on edit button")
	public void user_clicks_on_edit_button() throws InterruptedException {
		Thread.sleep(3000);
		editaboutpage.clickonedit();
	}

	@Then("User clicks on cancel button and checks wether the previously given data is present")
	public void user_clicks_on_cancel_button_and_checks_wether_the_previously_given_data_is_present()
			throws InterruptedException {
		editaboutpage.clickonsave();
	}

	@When("User deletes the Additional Mobile Number field")
	public void user_deletes_the_additional_mobile_number_field() throws InterruptedException {
		editaboutpage.deleteExtraPhone();
	}

	@When("User clicks on ADD ONE MORE PHONE button twice")
	public void user_clicks_on_add_one_more_phone_button_twice() throws InterruptedException {
		editaboutpage.clickonaddphone();
		editaboutpage.clickonaddphone();

	}

	@Then("ADD ONE MORE PHONE button should not be visible")
	public void add_one_more_phone_button_should_not_be_visible() {
        editaboutpage.addOneMorePhoneNotVisible();	
	}

	@Then("User enters {string} in the first additional phone number and user is notified with error message")
	public void user_enters_in_the_first_additional_phone_number_and_user_is_notified_with_error_message(
			String string) throws InterruptedException {
		String errormsg = editaboutpage.enterAdditionalFirstPhoneWithError(string);
		Assert.assertEquals(errormsg, "Mobile no starts with 05 and contains 10 digits");
		
	}

	@Then("User enters {string} in the second additional phone number and user is notified with error message")
	public void user_enters_in_the_second_additional_phone_number_and_user_is_notified_with_error_message(
			String string) throws InterruptedException {
		
		String errormsg = editaboutpage.enterAdditionalSecondPhoneWithError(string);
		Assert.assertEquals(errormsg, "Mobile no starts with 05 and contains 10 digits");

		
	}

	@Then("User clears the first additional phone number and enters {string} and the error message is gone")
	public void user_clears_the_first_additional_phone_number_and_enters_and_the_error_message_is_gone(String string) throws InterruptedException {
		editaboutpage.editAdditionalPhoneFirstField(string);
		
	}

	@Then("User clears the second additional phone number and enters {string} and the error message is gone")
	public void user_clears_the_second_additional_phone_number_and_enters_and_the_error_message_is_gone(String string) throws InterruptedException {
		editaboutpage.editAdditionalPhoneSecondField(string);
	}

	@Then("User deletes the first additional phone number")
	public void user_deletes_the_first_additional_phone_number() throws InterruptedException {
		editaboutpage.deleteFirstAdditionalPhoneNumber();
		
	}

	@Then("ADD ONE MORE PHONE button is visible now")
	public void add_one_more_phone_button_is_visible_now() {
		editaboutpage.addOneMorePhoneVisible();
	}
	@Then("Updated succesfully message is obtained")
	public void updated_succesfully_message_is_obtained() {
		editaboutpage.succesfullyAddedMsg();
	}
}

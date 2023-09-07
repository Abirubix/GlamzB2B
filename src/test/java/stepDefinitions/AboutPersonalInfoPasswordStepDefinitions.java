package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageobjects.AboutPagePersonalInfoPassword;
import pageobjects.AboutPagePersonalInfoPhone;
import utils.TextContextSetup;

public class AboutPersonalInfoPasswordStepDefinitions {
	AboutPagePersonalInfoPassword aboutpagepersonalinfopassword;
	TextContextSetup textContextSetup;
	public  AboutPersonalInfoPasswordStepDefinitions(TextContextSetup textContextSetup) {
		this.textContextSetup=textContextSetup;
	}
	@Then("User verifies if password label and edit button is present")
	public void user_verifies_if_password_label_and_edit_button_is_present() {
		aboutpagepersonalinfopassword=textContextSetup.pageobjectmanager.getaboutpersonalinfopassword();
		aboutpagepersonalinfopassword.validateLabelsAndButtons();
	}
	@Then("User verifies that password field is non editable")
	public void user_verifies_that_password_field_is_non_editable() {
		String validation = aboutpagepersonalinfopassword.passwordNonEditable();
		Assert.assertEquals(validation, "true");
	}
	@Then("User then clicks on edit button and edit password pop up is obtained")
	public void user_then_clicks_on_edit_button_and_edit_password_pop_up_is_obtained() throws InterruptedException {
		aboutpagepersonalinfopassword.clickOnEdit();
	}
	@Then("User verifies for all the texts and labels and action buttons are present in edit password popup")
	public void user_verifies_for_all_the_texts_and_labels_and_action_buttons_are_present_in_edit_password_popup() {
		aboutpagepersonalinfopassword.ValidatesLabelsAndFieldsInPopup();
	}
	@Then("User verifies that the password field in popup is non editable")
	public void user_verifies_that_the_password_field_in_popup_is_non_editable() {
		String validation = aboutpagepersonalinfopassword.passwordNonEditableInPopUp();
		Assert.assertEquals(validation, "true");
	}
	@Then("User enters {string} in the new password field and {string} in the Confirm New Password field")
	public void user_enters_in_the_new_password_field_and_in_the_confirm_new_password_field(String string, String string2) throws InterruptedException {
		 aboutpagepersonalinfopassword.enterPasswordFields(string,string2);
	}
	@Then("User click on save and {string} error message is obtained")
	public void user_click_on_save_and_error_message_is_obtained(String string) throws InterruptedException {
		String validation =aboutpagepersonalinfopassword.passwordMustMatchErrorObtaibed();
		Assert.assertEquals(validation, string);
	}
	@Then("User clears the new password field and {string} message is obtained")
	public void user_clears_the_new_password_field_and_message_is_obtained(String string) throws InterruptedException{
		String validation  =aboutpagepersonalinfopassword.errorMessageOnClearNewPassword();
		Assert.assertEquals(validation, string);
	}
	@Then("User clears the Confirm New Password field and {string} message is obtained")
	public void user_clears_the_confirm_new_password_field_and_message_is_obtained(String string) {
	   String validation = aboutpagepersonalinfopassword.errorMessageOnClearConfirmNewPassword();
	   Assert.assertEquals(validation, string);
	   }
	@Then("User enters {string} in the new password field")
	public void user_enters_in_the_new_password_field(String string) throws InterruptedException {
		aboutpagepersonalinfopassword.EnterNewPasswordField(string);
	}
	@Then("{string} message is obtained")
	public void message_is_obtained(String string) {
		String validation = aboutpagepersonalinfopassword.errorMessageOnshorterpswd();
		Assert.assertEquals(validation, string);
	}
	@Then("User clicks on save button and saved toaster message is obtained and the pop up closes")
	public void user_clicks_on_save_button_and_saved_toaster_message_is_obtained_and_the_pop_up_closes() throws InterruptedException {
		aboutpagepersonalinfopassword.clickOnSave();
	}
	@Then("User clicks on cancel in edit password popup and the popup closes and Personal Info page is displayed")
	public void user_clicks_on_cancel_in_edit_password_popup_and_the_popup_closes_and_personal_info_page_is_displayed() throws InterruptedException {
		aboutpagepersonalinfopassword.clickOnCancel();
	}
	@Then("User clicks on cross mark in edit password popup and the popup closes")
	public void user_clicks_on_cross_mark_in_edit_password_popup_and_the_popup_closes() throws InterruptedException {
		aboutpagepersonalinfopassword.clickOnCrossMark();
	}
	
}

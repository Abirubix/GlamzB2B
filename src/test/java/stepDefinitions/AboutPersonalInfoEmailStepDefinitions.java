package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AboutPagePersonalInfoEmail;
import utils.TextContextSetup;

public class AboutPersonalInfoEmailStepDefinitions {
	AboutPagePersonalInfoEmail aboutpagepersonalinfoemail;
	TextContextSetup textContextSetup;
	public  AboutPersonalInfoEmailStepDefinitions(TextContextSetup textContextSetup) {
		this.textContextSetup=textContextSetup;
	}


@Then("User verifies if email label and edit button is present")
public void user_verifies_if_email_label_and_edit_button_is_present() {
	aboutpagepersonalinfoemail=textContextSetup.pageobjectmanager.getaboutpersonalinfoemail();
	aboutpagepersonalinfoemail.validateLabelAndEditButton();
}
@Then("User verifies that email field is non editable")
public void user_verifies_that_email_field_is_non_editable() {
	String validation = aboutpagepersonalinfoemail.emailFieldNonEditable();
	Assert.assertEquals(validation, "true");
}
@Then("User then clicks on edit button and edit email pop up is obtained")
public void user_then_clicks_on_edit_button_and_edit_email_pop_up_is_obtained() throws InterruptedException {
	//Thread.sleep(3000);
	aboutpagepersonalinfoemail.clickOnEdit();
}
@Then("User verifies for all the texts and labels and action buttons are present in edit email popup")
public void user_verifies_for_all_the_texts_and_labels_and_action_buttons_are_present_in_edit_email_popup() {
	aboutpagepersonalinfoemail.validateEmaiLPopup();
}
@Then("User verifies that the email present in pop up is same as the email in Personal info email value")
public void user_verifies_that_the_email_present_in_pop_up_is_same_as_the_email_in_personal_info_email_value() throws InterruptedException {
  List<String> email = new ArrayList<String>();
  email = aboutpagepersonalinfoemail.validateEmailinPopup();
  Assert.assertEquals(email.get(0), email.get(1));
 

}
@Then("User enters the new email value as same as the existing email value and gives the same email in email cofirmation field")
public void user_enters_the_new_email_value_as_same_as_the_existing_email_value_and_gives_the_same_email_in_email_cofirmation_field() throws InterruptedException {
  aboutpagepersonalinfoemail.EnterSameEmail();
}
@Then("User clicks on save button in edit email popup an error message should appear")
public void user_clicks_on_save_button_in_edit_email_popup_an_error_message_should_appear() throws InterruptedException {
	aboutpagepersonalinfoemail.sameEmailValidations();
}
@When("User clears the new email and confirmation email field {string} message should be displayed")
public void user_clears_the_new_email_and_confirmation_email_field_message_should_be_displayed(String string) throws InterruptedException {
    aboutpagepersonalinfoemail.clearingEmailField(string);
}
@Then("User enters {string} in new email and {string} in the confirmation email")
public void user_enters_in_new_email_and_in_the_confirmation_email(String string, String string2) throws InterruptedException {
   aboutpagepersonalinfoemail.enteringEmails(string, string2);
}
@Then("User clicks on save button in edit email popup a confirmation toaster is displayed and the popup closes")
public void user_clicks_on_save_button_in_edit_email_popup_a_confirmation_toaster_is_displayed_and_the_popup_closes() throws InterruptedException {
   aboutpagepersonalinfoemail.successfullyEntered();
}
@Then("User clicks on save button in edit email popup an error message indicating emails are not same should appear")
public void user_clicks_on_save_button_in_edit_email_popup_an_error_message_indicating_emails_are_not_same_should_appear() throws InterruptedException{
	aboutpagepersonalinfoemail.emailsNotSame();
}
@Then("User clicks on save button in edit email popup an error message  {string} should appear")
public void user_clicks_on_save_button_in_edit_email_popup_an_error_message_should_appear(String string) throws InterruptedException {
	aboutpagepersonalinfoemail.invalidEmailErrorDispalyed();
}
@Then("The new email {string} is updated in personal info email field")
public void the_new_email_is_updated_in_personal_info_email_field(String string) throws InterruptedException {
	String value = aboutpagepersonalinfoemail.emailDisplayed();
	Assert.assertEquals(value, string);
}
@When("User clicks on cancel button the edit email popup is closed")
public void user_clicks_on_cancel_button_the_edit_email_popup_is_closed() throws InterruptedException {
	aboutpagepersonalinfoemail.validateCancelButton();
}

@Then("User clicks on cross mark to close the popup")
public void user_clicks_on_cross_mark_to_close_the_popup() throws InterruptedException {
	aboutpagepersonalinfoemail.validateCrossMark();
}
}

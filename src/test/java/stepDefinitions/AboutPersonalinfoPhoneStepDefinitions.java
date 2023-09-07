package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageobjects.AboutPagePersonalInfoEmail;
import pageobjects.AboutPagePersonalInfoPhone;
import utils.TextContextSetup;

public class AboutPersonalinfoPhoneStepDefinitions {
	AboutPagePersonalInfoPhone aboutpagepersonalinfophone;
	TextContextSetup textContextSetup;
	public  AboutPersonalinfoPhoneStepDefinitions(TextContextSetup textContextSetup) {
		this.textContextSetup=textContextSetup;
	}
	

@Then("User verifies if mobile phone for login label and edit button is present")
public void user_verifies_if_mobile_phone_for_login_label_and_edit_button_is_present() {
	aboutpagepersonalinfophone=textContextSetup.pageobjectmanager.getaboutpersonalinfophone();
	aboutpagepersonalinfophone.validateLabelsAndButtons();
   
}
@Then("User verifies that mobile phone field is non editable")
public void user_verifies_that_mobile_phone_field_is_non_editable() {
	String validation = aboutpagepersonalinfophone.mobilePhoneNonEditable();
	Assert.assertEquals(validation, "true");
   
}
@Then("User then clicks on edit button and edit mobile number pop up is obtained")
public void user_then_clicks_on_edit_button_and_edit_mobile_number_pop_up_is_obtained() throws InterruptedException {
	aboutpagepersonalinfophone.clickOnEdit();
}
@Then("User verifies for all the texts and labels and action buttons are present in edit mobile number popup")
public void user_verifies_for_all_the_texts_and_labels_and_action_buttons_are_present_in_edit_mobile_number_popup() {
	aboutpagepersonalinfophone.validateLabelsAndButtonsinPopup();
}
@Then("User verifies if current mobile number in pop up is same as the mobile number in personal info mobile field")
public void user_verifies_if_current_mobile_number_in_pop_up_is_same_as_the_mobile_number_in_personal_info_mobile_field() throws InterruptedException {
	  List<String> phone = new ArrayList<String>();
	phone = aboutpagepersonalinfophone.validateEmailInPopup();
	  Assert.assertEquals(phone.get(0).toString(), phone.get(1).toString());

}
@Then("User enters {string} in the new mobile number field and is notified with an error message")
public void user_enters_in_the_new_mobile_number_field_and_is_notified_with_an_error_message(String string) throws InterruptedException {
	aboutpagepersonalinfophone.enterInvalidPhoneNumber(string);
}
@Then("User enters {string} in the new mobile number field and the error message is gone")
public void user_enters_in_the_new_mobile_number_field_and_the_error_message_is_gone(String string) throws InterruptedException {
	aboutpagepersonalinfophone.enterValidPhoneNumber(string);
}
@Then("User clicks on Send Verification Code button and an otp sent succesfully message toaster is displayed")
public void user_clicks_on_send_verification_code_button_and_an_otp_sent_succesfully_message_toaster_is_displayed() throws InterruptedException {
	aboutpagepersonalinfophone.sendVerificationCode();
}
@Then("User enters the wrong otp {string} and clicks on save button")
public void user_enters_the_wrong_otp_and_clicks_on_save_button(String string) throws InterruptedException {
	aboutpagepersonalinfophone.enterWrongOtp(string);
}
@Then("Invalid Otp message should be displayed")
public void invalid_otp_message_should_be_displayed() {
	aboutpagepersonalinfophone.invalidOtpMsgDisplayed();
    
}
@Then("User should be notified with error message as {string} in the edit mobile number popup")
public void user_should_be_notified_with_error_message_as_in_the_edit_mobile_number_popup(String string) {
	aboutpagepersonalinfophone.otpInstructionMsg();
}
@Then("User clicks on Cancel button in Edit MobileNumber popup and the popup closes")
public void user_clicks_on_cancel_button_in_edit_mobile_number_popup_and_the_popup_closes() throws InterruptedException {
	aboutpagepersonalinfophone.clickOnCancelbutton();
}
@Then("User clicks on cross mark in Edit Mobile Number popup to close the popup")
public void user_clicks_on_cross_mark_in_edit_mobile_number_popup_to_close_the_popup() throws InterruptedException {
	aboutpagepersonalinfophone.clickonCrossMark();
}
@Then("User enters the wrong otp {string}")
public void user_enters_the_wrong_otp(String string) throws InterruptedException {
	aboutpagepersonalinfophone.entersmallerotp(string);
		

}


}

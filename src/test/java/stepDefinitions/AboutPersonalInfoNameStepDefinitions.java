package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageobjects.AboutPagePersonalInfo;
import pageobjects.AboutPagePersonalInfoName;
import pageobjects.AboutPageSalonInfo;
import utils.TextContextSetup;

public class AboutPersonalInfoNameStepDefinitions {
	AboutPagePersonalInfoName aboutpagepersonalinfoname;
	TextContextSetup textContextSetup;
	public  AboutPersonalInfoNameStepDefinitions(TextContextSetup textContextSetup) {
		this.textContextSetup=textContextSetup;
	}


	@Then("User verifies if name label and edit button is present")
	public void user_verifies_if_name_label_and_edit_button_is_present() {
		aboutpagepersonalinfoname=textContextSetup.pageobjectmanager.getaboutpersonalinfoname();
		aboutpagepersonalinfoname.presenceOfLabelAndEdit();

	   
	}
	@Then("User verifies that name field is noneditable")
	public void user_verifies_that_name_field_is_noneditable() {
		boolean validation = aboutpagepersonalinfoname.nameFieldNonEditable();
		Assert.assertEquals(validation, false);
	   
	}
	@Then("User clicks on Edit button in name field")
	public void user_clicks_on_edit_button_in_name_field() throws InterruptedException {
		aboutpagepersonalinfoname.clickonedit();
	   
	}
	@Then("The name field should be editable and the user renames to {string}")
	public void the_name_field_should_be_editable_and_the_user_renames_to(String string) throws InterruptedException {
	   boolean validation = aboutpagepersonalinfoname.editNameField(string);
	   Assert.assertEquals(validation, true);
	}
	@Then("User clicks on save button for name field")
	public void user_clicks_on_save_button_for_name_field() throws InterruptedException {
		Thread.sleep(3000);
	    aboutpagepersonalinfoname.clickOnSave();
	}
	@Then("User clicks on edit button for name field and clicks on cancel button")
	public void user_clicks_on_edit_button_for_name_field_and_clicks_on_cancel_button() throws InterruptedException {
	    aboutpagepersonalinfoname.clickOnEditAndCancel();

	}
	@Then("The User checks if previously entered name {string} is there")
	public void the_user_checks_if_previously_entered_name_is_there(String string) throws InterruptedException {
	  Thread.sleep(3000);

	   String name =  aboutpagepersonalinfoname.extractName();
	   Assert.assertEquals(name, string);
	
	}

}

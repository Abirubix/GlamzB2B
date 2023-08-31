package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.RegisterPage;
import utils.TextContextSetup;

public class RegisterPageStepDefinitions {
	public WebDriver driver;
	public  RegisterPage registerpage;

	TextContextSetup textcontextsetup;
	public RegisterPageStepDefinitions(TextContextSetup textcontextsetup) {
		this.textcontextsetup=textcontextsetup;
	}
	
	@When("Click on register button")
	public void click_on_register_button() throws InterruptedException {

		registerpage = textcontextsetup.pageobjectmanager.getregisterpage();
		registerpage.clickbutton();
        Thread.sleep(500);
	   
	}
	@Then("Register by filling the forms")
	public void register_by_filling_the_forms(List<String> str) throws InterruptedException {
		registerpage.fieldvalidations(str);
        registerpage.dropdownvalidations();
        registerpage.selectCheckbox();
        registerpage.clickRegister();
	    
	}

}

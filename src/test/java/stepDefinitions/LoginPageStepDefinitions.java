package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import utils.TextContextSetup;

public class LoginPageStepDefinitions {
	public LoginPage loginpage;
	public WebDriver driver;
	TextContextSetup textcontextsetup;
	public LoginPageStepDefinitions(TextContextSetup textcontextsetup) {
		this.textcontextsetup=textcontextsetup;
	}

	@When("User enter username {string} and password {string} and logs in")
	public void user_enter_username_and_password_and_logs_in(String string, String string2) throws IOException, InterruptedException {
	   loginpage = textcontextsetup.pageobjectmanager.getloginpage();
	   loginpage.loginwithmail(string, string2);
	}
	

}

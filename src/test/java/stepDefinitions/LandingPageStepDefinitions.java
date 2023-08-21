package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import pageobjects.GlamzLandingPage;
import utils.TextContextSetup;

public class LandingPageStepDefinitions {
	public WebDriver driver;
	public GlamzLandingPage glamzlandingpage;

	TextContextSetup textcontextsetup;
	public LandingPageStepDefinitions(TextContextSetup textcontextsetup) {
		this.textcontextsetup=textcontextsetup;
	}
	@Given("User launch an Glamz web application")
	public void user_launch_an_glamz_web_application() {
	   
	}
	@Given("User click on Login button")
	public void user_click_on_login_button() throws InterruptedException {

		
	   glamzlandingpage = textcontextsetup.pageobjectmanager.getglamzlandinpage();
	   glamzlandingpage.clickloginbtn();
	}

}

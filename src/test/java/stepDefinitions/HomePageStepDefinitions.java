package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import pageobjects.HomePage;
import utils.TextContextSetup;

public class HomePageStepDefinitions {
	public WebDriver driver;
    public HomePage homepage;
	TextContextSetup textcontextsetup;
	public HomePageStepDefinitions(TextContextSetup textcontextsetup) {
		this.textcontextsetup=textcontextsetup;
	}
	@Then("User click Setup->About")
	public void user_click_setup_about() throws InterruptedException {
	   
    homepage = textcontextsetup.pageobjectmanager.gethomepage();
    homepage.clickonabout();
}
	
}

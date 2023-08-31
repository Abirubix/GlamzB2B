package stepDefinitions;

import org.openqa.selenium.By;
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
    Thread.sleep(2000);
}
	@Then("click the gallery module in the left side dashboard")
	public void click_the_gallery_module_in_the_left_side_dashboard() throws InterruptedException {
	    homepage = textcontextsetup.pageobjectmanager.gethomepage();
		homepage.clickGallerybtn();
}
}
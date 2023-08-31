package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class LoginPage extends CommonMethods{
	
	public 	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (css = ".fa.fa-envelope")
	WebElement loginwithmailbtn;
	
	@FindBy (xpath = "//input[@formcontrolname='username']")
	WebElement useremail;
	
	@FindBy (xpath = "//input[@formcontrolname='password']")
	WebElement userpassword;
	
	@FindBy (css = ".btn.btn-primary.loginbtn")
	WebElement loginbtn;
	
	
	public void loginwithmail(String email, String password) throws IOException, InterruptedException {
		clickelement(loginwithmailbtn);
		Enter(useremail, email);
		Enter(userpassword, password);
		Click(loginbtn);
	}
	
	

}

package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TextContextSetup;

public class hooks {
	
	TextContextSetup textcontextsetup;
	public hooks(TextContextSetup textcontextsetup) {
		this.textcontextsetup = textcontextsetup;
	}
	
	@After
	public void afterscenario() throws IOException {
		textcontextsetup.testbase.Webdrivermanager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException  {
		WebDriver driver=textcontextsetup.testbase.Webdrivermanager();
		if(scenario.isFailed()) {
			File sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] filecontent=FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(filecontent, "image/png", "image");
		
		}
	}

}

package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {
public	WebDriver driver;
	
	public WebDriver Webdrivermanager() throws IOException {
		
		
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAURL");
		if(driver == null) {
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
			
		}
			if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
			
		}
			if(prop.getProperty("browser").equalsIgnoreCase("safari")) {
		driver = new SafariDriver();
		driver.get(url);
		driver.manage().window().maximize();
			
		}
			if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
			
		}
		
		
	}
		return driver;

	 
}
}
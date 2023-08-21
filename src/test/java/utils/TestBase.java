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
		System.out.println(url);
		if(driver == null) {
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.out.println(prop.getProperty("browser").toString());
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
			
		}
			if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				System.out.println(prop.getProperty("browser").toString());
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
			
		}
			if(prop.getProperty("browser").equalsIgnoreCase("safari")) {
				System.out.println(prop.getProperty("browser").toString());
		driver = new SafariDriver();
		driver.get(url);
		driver.manage().window().maximize();
			
		}
			if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
				System.out.println(prop.getProperty("browser").toString());
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
			
		}
		
		
	}
		return driver;

	 
}
}
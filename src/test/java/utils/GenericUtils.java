package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	public GenericUtils(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}

	public void switchwindowtochild() {
		 Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
	        String parent =iterator.next();
	        String child = iterator.next();
	        driver.switchTo().window(child);
	}

	public void sleep() throws InterruptedException
{
		Thread.sleep(10000);
		}
}

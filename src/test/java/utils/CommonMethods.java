package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	
	WebDriver driver;
	 public CommonMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sleep() throws InterruptedException {
		Thread.sleep(10000);
	}

	public void Click(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		element.click();
	}

	public void clickelement(WebElement Ele)
	{
		Ele.click();
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	//Method to enter text in text box
	public void EnterInfo(WebElement element, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		element.clear();
		element.sendKeys(value);
	}

	public void Zoom_In(String percentage) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.body.style.zoom = '"+percentage+"';");
	}

	public void Zoom_Out() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.body.style.zoom = '100%';");
	}
	// send value using sendkays.
	public void Sendvalues(WebElement element,String value) {
		element.sendKeys(value);

	}
	//method to delete the default value of text field
	public void clear_default(WebElement element) {

			element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
	}

	//Method to select option from Dropdown
	public void SelectOption(WebElement element,String option, String selectBy) {
		Select s = new Select(element);
		if (selectBy.equalsIgnoreCase("VisibleText")) {
			s.selectByVisibleText(option);
		} else if (selectBy.equalsIgnoreCase("value")) {
			s.selectByValue(option);
		} else if (selectBy.equalsIgnoreCase("Index")) {
			s.selectByIndex(Integer.parseInt(option));
		}
	}
	
	public static void waitForElement(WebDriver driver, WebElement element) {
	    FluentWait<WebDriver> wait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(30))
	            .pollingEvery(Duration.ofMillis(500))
	            .ignoring(NoSuchElementException.class);

	    wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	//Method to wait for pageload

	@SuppressWarnings("deprecation")
	public void Pageload(int numb) {
		driver.manage().timeouts().pageLoadTimeout(numb, TimeUnit.SECONDS);
	}

	//Method to wait - Implicit Wait
	public void Wait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	//Method to wait for Element- Implicit Wait
	public void WaitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void WaitForElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void WaitForElement(By elementLocator, int Size) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(elementLocator, Size));
	}

	public void ScrollpageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
	}
	public void ScrollpageUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(1000,0)");
	}
	public void sleepTime(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void StaticsleepTime(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Method to wait for  list of Element
	public void WaitForElement(By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
	}

	public void WaitForElement1(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	//Method o verify Element is available
	public boolean isElementAvailable(WebElement element) {
		WaitForVisibleElement(element,50);
		return element.isDisplayed();
	}

	//Method to get title
	public String getTitle() {
		return driver.getTitle();
	}

	public void WaitForvisibleElement(By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}

	public void WaitForVisibleElement(WebElement element,int size) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOf( element));
	}


	public void zoomOut(){
		Actions a = new Actions(driver);
		a.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	}
	public void zoomIn(){
		Actions a = new Actions(driver);
		a.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
	}
	//Method to get text
	public String getText(WebElement element) {
		return element.getText();
	}

	public int getsize(List<WebElement> element) {
		return element.size();
	}


	//Method to take screenshot
		public String TakeScreenshot(String screenshotname) throws IOException {
			TakesScreenshot screen = ((TakesScreenshot)driver); // to take screenshot
			File screenshotFile = screen.getScreenshotAs(OutputType.FILE); //to convert it as File
			String screenshotPath = System.getProperty("user.dir") +File.separator+ "FailedScreenShot"+File.separator+screenshotname+generateUniqueID()+".png";
			File screenPath = new File(screenshotPath);
			FileUtils.copyFile(screenshotFile, screenPath);
			return screenshotPath;
		}

		//Method to compare the list of array
		public void Comparelist(List<WebElement> expected,List<WebElement> actual)
		{
			for(WebElement MyeleExpected:expected) {
				Boolean found =false;
				for(WebElement MyeleActual:actual) {
					if(MyeleExpected.getText().equals(MyeleActual.getText())) {
						found=true;
						System.out.println("The Element is found");
					}
				}
			}
		}
		//Method to generate unique random id
		public static String generateUniqueID() {
			OffsetDateTime dateTime = OffsetDateTime.now(ZoneId.of("Europe/Rome"));
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		    String text = dateTime.format(formatter);
			Calendar cal = Calendar.getInstance();
			return  text;

		}

		//Method to generate unique random id
		public static String generateUniqueID2() {
			OffsetDateTime dateTime = OffsetDateTime.now(ZoneId.of("Europe/Rome"));
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		    String text = dateTime.format(formatter);
			Calendar cal = Calendar.getInstance();

			return text;
		}

		//Method to select checkbox
		public void selectCheckbox(WebElement element) {
			if(!element.isSelected())
				element.click();
		}

		//Method to perform double Click
		public void DoubleClick(WebElement element) {
			Actions action = new Actions(driver);
			action.doubleClick(element).build().perform();
		}

		//Method to perform right Click
		public void RightClick(WebElement element) {
			Actions action = new Actions(driver);
			action.contextClick(element).build().perform();
		}

		public void Mouseoveraction(WebElement element) {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}


		public void ComparetheListwithString(List<String> List1,List<String> List2) {

			boolean Match=List2.containsAll(List1);

		System.out.println("Both lists are equal----"+Match);
		}


		public void  clickOnCheckbox(String Material){
			 driver.findElement(By.xpath("//div[contains(text(),'"+Material+"')]/parent::td/preceding-sibling::td/div/div[@class='d-flex']")).click();
		}

		public boolean compareTable(List<WebElement> actual,List<WebElement> expected) {
			return actual.stream().map(WebElement::getText).sorted().collect(Collectors.toList()).containsAll(expected.stream().map(WebElement::getText).sorted().collect(Collectors.toList()));

		}


		public boolean isClickable(WebElement el)
	    {
	        try{
	        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	            wait.until(ExpectedConditions.elementToBeClickable(el));
	            return true;
	        }
	        catch (Exception e){
	            return false;
	        }
	    }
//file format
	boolean flag = false;
	public boolean isFileDownloaded(String downloadPath, String fileName) {

		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		List<File> file_list = Arrays.asList(dir_contents);

		for (int i = 0; i < file_list.size(); i++) {
			System.out.println(file_list.get(i).getName());
			if (file_list.get(i).getName().equals(fileName)) {
				flag = true;
				break;
			}
		}

		return flag;
	}


}

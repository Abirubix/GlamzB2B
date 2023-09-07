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
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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

	public void highlight(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid blue'", ele);
	}

	public void highlight(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid blue'", locator);
	}

	public void stophighlight(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','border:; background;');", ele);
	}

	public String getDisabledElements(String locatorvalue, String locatortype) throws InterruptedException {
		String script = "var input = document.querySelector('" + locatorvalue
				+ "'); if (input) return input.value; else return null ;";
		String value = (String) ((JavascriptExecutor) driver).executeScript(script);

		highlightText(locatorvalue, locatortype);
		return value;
	}

	public void highlightText(String locatorvalue, String locatortype) throws InterruptedException {
		if (locatortype.equalsIgnoreCase("cssSelector")) {
			WebElement element = driver.findElement(By.cssSelector(locatorvalue));
			scrollToElement(element);
		}
		if (locatortype.equalsIgnoreCase("xpath")) {
			WebElement element = driver.findElement(By.xpath(locatorvalue));
			scrollToElement(element);
		}
		if (locatortype.equalsIgnoreCase("id")) {
			WebElement element = driver.findElement(By.id(locatorvalue));
			scrollToElement(element);
		}
		if (locatortype.equalsIgnoreCase("linktext")) {
			WebElement element = driver.findElement(By.linkText(locatorvalue));
			scrollToElement(element);
		}
		if (locatortype.equalsIgnoreCase("classname")) {
			WebElement element = driver.findElement(By.className(locatorvalue));
			scrollToElement(element);
		}
		if (locatortype.equalsIgnoreCase("tagname")) {
			WebElement element = driver.findElement(By.tagName(locatorvalue));
			scrollToElement(element);
		}
		if (locatortype.equalsIgnoreCase("partiallinktext")) {
			WebElement element = driver.findElement(By.partialLinkText(locatorvalue));
			scrollToElement(element);
		}
		if (locatortype.equalsIgnoreCase("name")) {
			WebElement element = driver.findElement(By.name(locatorvalue));
			scrollToElement(element);
		}

	}

	public void sleep() throws InterruptedException {
		Thread.sleep(10000);
	}

	public void Click(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		highlight(element);
		element.click();
	}

	public void clickelement(WebElement Ele) {
		highlight(Ele);
		Ele.click();
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		highlight(element);
	}

	// Method to enter text in text box
	public void Enter(WebElement element, String value) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		highlight(element);
		element.sendKeys(value);
	}

	public void Zoom_In(String percentage) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.body.style.zoom = '" + percentage + "';");
	}

	public void Zoom_Out() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.body.style.zoom = '100%';");
	}

	public void Sendvalues(WebElement element, String value) {
		highlight(element);
		element.sendKeys(value);

	}

	public void Clear(WebElement element) {
		highlight(element);
		element.clear();
	}

	public void clear_default(WebElement element) {
		highlight(element);
		Actions a =new Actions(driver); 
		a.click(element).build().perform();
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.COMMAND + "a");
		element.sendKeys(Keys.DELETE);
	}

	public void isDisplayed(WebElement element) {
		highlight(element);
		element.isDisplayed();
	}

	public void isEnabled(WebElement element) {
		highlight(element);

	   element.isEnabled();
	}

	// Method to select option from Dropdown
	public void SelectOption(WebElement element, String option, String selectBy) {
		Select s = new Select(element);
		if (selectBy.equalsIgnoreCase("VisibleText")) {
			s.selectByVisibleText(option);
			highlight(element);
		} else if (selectBy.equalsIgnoreCase("value")) {
			s.selectByValue(option);
			highlight(element);
		} else if (selectBy.equalsIgnoreCase("Index")) {
			s.selectByIndex(Integer.parseInt(option));
			highlight(element);
		}
	}

	public void waitForElementInvisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForElement(WebDriver driver, WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
		highlight(element);

	}

	// Method to wait for Element- Implicit Wait
	public void WaitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		highlight(element);

	}

	public void WaitForElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		highlight(element);

	}

	public void WaitForPresenceOfWebElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		highlight(locator);

	}

	public void WaitForElement(By elementLocator, int Size) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(elementLocator, Size));
		highlight(elementLocator);

	}

	public void WaitForpresenceElement(By elementLocator, int Size) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(elementLocator, Size));
		highlight(elementLocator);

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
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void StaticsleepTime(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Method to wait for list of Element
	public void WaitForElementby(By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
		highlight(elementLocator);

	}

	public void WaitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		highlight(element);

	}

	// Method o verify Element is available
	public boolean isElementAvailable(WebElement element) {
		WaitForVisibleElement(element, 50);
		highlight(element);
		return element.isDisplayed();
	}

	// Method to get title
	public String getTitle() {
		return driver.getTitle();
	}

	public void WaitForvisibleElement(By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		highlight(elementLocator);

	}

	public void WaitForVisibleElement(WebElement element, int size) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		highlight(element);
	}

	public void zoomOut() {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	}

	public void zoomIn() {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
	}

	// Method to get text
	public String getText(WebElement element) {
		highlight(element);
		return element.getText();
	}

	public int getsize(List<WebElement> element) {
		return element.size();
	}

	// Method to take screenshot
	public String TakeScreenshot(String screenshotname) throws IOException {
		TakesScreenshot screen = ((TakesScreenshot) driver); // to take screenshot
		File screenshotFile = screen.getScreenshotAs(OutputType.FILE); // to convert it as File
		String screenshotPath = System.getProperty("user.dir") + File.separator + "FailedScreenShot" + File.separator
				+ screenshotname + generateUniqueID() + ".png";
		File screenPath = new File(screenshotPath);
		FileUtils.copyFile(screenshotFile, screenPath);
		return screenshotPath;
	}

	// Method to compare the list of array
	public void Comparelist(List<WebElement> expected, List<WebElement> actual) {
		for (WebElement MyeleExpected : expected) {
			Boolean found = false;
			for (WebElement MyeleActual : actual) {
				if (MyeleExpected.getText().equals(MyeleActual.getText())) {
					found = true;
					System.out.println("The Element is found");
				}
			}
		}
	}

	// Method to generate unique random id
	public static String generateUniqueID() {
		OffsetDateTime dateTime = OffsetDateTime.now(ZoneId.of("Europe/Rome"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String text = dateTime.format(formatter);
		Calendar cal = Calendar.getInstance();
		return text;

	}

	// Method to generate unique random id
	public static String generateUniqueID2() {
		OffsetDateTime dateTime = OffsetDateTime.now(ZoneId.of("Europe/Rome"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String text = dateTime.format(formatter);
		Calendar cal = Calendar.getInstance();

		return text;
	}

	// Method to select checkbox
	public void selectCheckbox(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		highlight(element);

	}

	// Method to perform double Click
	public void DoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		highlight(element);
		action.doubleClick(element).build().perform();
	}

	// Method to perform right Click
	public void RightClick(WebElement element) {
		Actions action = new Actions(driver);
		highlight(element);
		action.contextClick(element).build().perform();
	}

	public void moveMouse(int x, int y) {
		Actions action = new Actions(driver);
		action.moveByOffset(x, y).build().perform();
	}

	public void Mouseoveraction(WebElement element) {
		Actions action = new Actions(driver);
		highlight(element);
		action.moveToElement(element).build().perform();
	}

	public void ComparetheListwithString(List<String> List1, List<String> List2) {

		boolean Match = List2.containsAll(List1);

		System.out.println("Both lists are equal----" + Match);
	}

	public boolean compareTable(List<WebElement> actual, List<WebElement> expected) {
		return actual.stream().map(WebElement::getText).sorted().collect(Collectors.toList())
				.containsAll(expected.stream().map(WebElement::getText).sorted().collect(Collectors.toList()));

	}

	public boolean isClickable(WebElement el) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(el));
			highlight(el);
			return true;
		} catch (Exception e) {
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

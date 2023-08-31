package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageobjects.PageObjectManager;

public class TextContextSetup {

	public WebDriver driver;
	
	public PageObjectManager pageobjectmanager;
	public TestBase testbase;
	public GenericUtils genericutils;
	public  String mobilenumbersaloninfo;
	
	public TextContextSetup() throws IOException {
		
		
		testbase = new TestBase();
		pageobjectmanager = new PageObjectManager(testbase.Webdrivermanager()); //driver 
		//genericutils = new GenericUtils(testbase.Webdrivermanager());
	}
	
}

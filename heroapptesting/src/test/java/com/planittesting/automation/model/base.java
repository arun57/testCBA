package com.planittesting.automation.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public WebDriver initilizeDriver() throws IOException
	{
		//Reading property value from data.properties file
		Properties prop=new Properties();
		//data.properties should be in the project directory
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\planittesting\\automation\\model\\data.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		if(browser.equals("Chrome")) //Calling Chrome Driver based on browser value in data.properties
		{
			//System.setProperty("webdriver.chrome.driver", "C://Users//dasar//git//TestNine//selenium//src//main//java//automation//selenium//resource//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//java//com//planittesting//automation//resource//chromedriver.exe");
			driver=new ChromeDriver();
		} 
		else if(browser.equals("Firefox")) //Calling Firefox Driver based on browser value in data.properties
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//java//com//planittesting//automation//resource//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
			System.out.println("Please pass a proper value for browser Chrome,Firefox or IE to the data.");

		return driver;
		
	}

}
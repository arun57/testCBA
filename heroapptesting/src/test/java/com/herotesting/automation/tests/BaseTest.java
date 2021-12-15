package com.herotesting.automation.tests;


import java.util.concurrent.TimeUnit;

import com.herotesting.automation.support.DriverFactory;
import com.herotesting.automation.support.MyScreenRecorder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import io.github.cdimascio.dotenv.Dotenv;



public class BaseTest {
    protected WebDriver driver;
    private Dotenv env = Dotenv.configure().load();

	@BeforeEach
    public void setup() throws Exception{
        var browser = env.get("SELENIUM_BROWSER");
        var wait = Integer.parseInt(env.get("SELENIUM_WAIT"));
        var url = env.get("SELENIUM_URL"); 
        MyScreenRecorder.startRecording("recordSampleTest");
        driver = DriverFactory.getInstance(browser);
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterEach
    public void shutdown() throws Exception{
        System.out.println("Passed");
        MyScreenRecorder.stopRecording();
        driver.quit();
    }

    protected <T> T open(Class<T> clazz)throws Exception {
        return clazz.getConstructor(WebDriver.class).newInstance(driver);
    }
}

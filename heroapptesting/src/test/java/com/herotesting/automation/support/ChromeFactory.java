package com.herotesting.automation.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory implements DriverFactory {

    @Override
    public ChromeOptions getCapabilities() {
        var options = new ChromeOptions();
        options.addArguments("--disable-gpu",
                "--window-size=1920,1200",
                "--ignore-certificate-errors")
        .setExperimentalOption("w3c", true);
        return options;
    }

    @Override
    public WebDriver getDriver() {
        return new ChromeDriver(getCapabilities());
    }
    
}

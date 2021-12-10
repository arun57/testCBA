package com.planittesting.automation.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxFactory implements DriverFactory{

    @Override
    public FirefoxOptions getCapabilities() {
        var options = new FirefoxOptions();
        options.addArguments("-width 1920", "-height 1200");
        return options;
    }

    @Override
    public WebDriver getDriver() {
        return new FirefoxDriver(getCapabilities());
    }
    
}

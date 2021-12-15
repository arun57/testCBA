package com.herotesting.automation.support;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.reflections.Reflections;

public interface DriverFactory {
    public Capabilities getCapabilities();
    public WebDriver getDriver();

    public static WebDriver getInstance(String browser) throws Exception {
        
        var ref = new Reflections(DriverFactory.class.getPackageName()).getSubTypesOf(DriverFactory.class);
        List<Class<? extends DriverFactory>> drivers = new ArrayList<>(ref);
        return drivers.stream().filter(d -> d.getSimpleName().toLowerCase().contains(browser.toLowerCase()))
        .findFirst().orElseThrow(() -> new RuntimeException(browser + " is not a supported browser"))
        .getConstructor().newInstance().getDriver(); 
        
         
    }
}

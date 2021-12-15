package com.herotesting.automation.model.pages;

import org.openqa.selenium.WebDriver;
//abstract - you should not use directly in your code.
public abstract class BasePage<T> {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    

}

package com.planittesting.automation.model.components.dialog;

import com.planittesting.automation.model.pages.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

public class LogoutDialog {
    private WebElement rootElement;

    public LogoutDialog(WebElement rootElement){
        this.rootElement = rootElement;
    }

    public HomePage clickOnLogoutButton(){
        rootElement.findElement(By.className("btn-success")).click();
        var driver = ((WrapsDriver)rootElement).getWrappedDriver();
        return new HomePage(driver);
    }
    
}

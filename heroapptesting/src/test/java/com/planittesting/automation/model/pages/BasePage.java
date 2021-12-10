package com.planittesting.automation.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.planittesting.automation.model.components.dialog.LoginDialog;
import com.planittesting.automation.model.components.dialog.LogoutDialog;
//abstract - you should not use directly in your code.
public abstract class BasePage<T> {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public ContactPage clickOnContactMenu(){
        driver.findElement(By.cssSelector("#nav-contact")).click();
        return new ContactPage(this.driver);
    }

    public ShopPage clickOnShopMenu(){
        driver.findElement(By.cssSelector("#nav-shop")).click();
        return new ShopPage(this.driver);
    }

    public CartPage clickOnCartMenu(){
        driver.findElement(By.cssSelector("#nav-cart")).click();
        return new CartPage(this.driver);
    }

    @SuppressWarnings("unchecked")
    public LoginDialog<T> clickOnLoginMenu(){
        driver.findElement(By.cssSelector("#nav-login")).click();
        return new LoginDialog<T>(driver.findElement(By.className("popup")), (T)this);
    }

    public LogoutDialog clickOnLogoutMenu(){
        driver.findElement(By.cssSelector("#nav-logout")).click();
        return new LogoutDialog (driver.findElement(By.className("popup")));
    }

    public String getUser(){
        var elements = driver.findElements(By.className("user"));
        return elements.isEmpty()?"":elements.get(0).getText();
    }

    public int getCartCount(){
        return Integer.parseInt(driver.findElement(By.className("cart-count")).getText());
    }
    

}

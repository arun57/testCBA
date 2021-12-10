package com.planittesting.automation.model.components.dialog;

import com.planittesting.automation.model.data.LoginData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginDialog<T> {
    private WebElement rootElement;
    private T parent;

    public LoginDialog(WebElement rootElement, T parent){
        this.rootElement = rootElement;
        this.parent = parent;
    }

    public LoginDialog<T> setUsername(String username){
        rootElement.findElement((By.id("loginUserName"))).sendKeys(username);
        return this;
    }

    public LoginDialog<T> setPassword(String password){
        rootElement.findElement((By.id("loginPassword"))).sendKeys(password);
        return this;
    }
    public LoginDialog<T> clickOnTerms(){
        rootElement.findElement((By.id("agree"))).click();
        return this;
    }

    public T clickOnLoginButton(){
        rootElement.findElement((By.className("btn-primary"))).click();
        return parent;
    }

    /*public LoginDialog<T> clickCheckBox(){
        rootElement.findElement(By.id("agree")).click();;
        return this;
    }*/

    public T login(LoginData data){
        return this.setUsername(data.username())
            .setPassword(data.password())
            //.clickCheckBox()
            .clickOnLoginButton();
    }
}

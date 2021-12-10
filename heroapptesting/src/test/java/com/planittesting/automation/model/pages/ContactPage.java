package com.planittesting.automation.model.pages;

import com.planittesting.automation.model.data.ContactData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage<ContactPage>{


    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ContactPage clickOnSubmitButton(){
        driver.findElement(By.className("btn-contact")).click();
        //driver.findElement(By.id("contact-submit-btn")).click();
        return this;
    }

    public String getForenameError(){
        return getErrorText(By.id("forename-err"));
    }

    public String getEmailError(){
        return getErrorText(By.id("email-err"));
    }

    public String getMessageError(){
        return getErrorText(By.id("message-err"));
    }

    public String getErrorText(By locator){
        var elements =   driver.findElements(locator);
        return elements.isEmpty() ? "" : elements.get(0).getText();
    }

    public ContactPage setForename(String name){
        driver.findElement(By.id("forename")).sendKeys(name);
        return this;
    }

    public ContactPage setEmail(String email){
        driver.findElement(By.id("email")).sendKeys(email);
        return this;
    }

    public ContactPage setMessage(String message){
        driver.findElement(By.id("message")).sendKeys(message);
        return this;
    }

    public ContactPage setSurname(String surname){
        driver.findElement(By.id("surname")).sendKeys(surname);
        return this;
    }

    public ContactPage setTelephone(String telephone){
        driver.findElement(By.id("telephone")).sendKeys(telephone);
        return this;
    }

    public ContactPage setContactData(ContactData data){
        if(data.forename()!= null) setForename(data.forename());
        if(data.surname()!= null) setSurname(data.surname());
        if(data.email()!= null) setEmail(data.email());
        if(data.telephone()!= null) setTelephone(data.telephone());
        if(data.message()!= null) setMessage(data.message());     
        return this;
    }

    public String getSuccessMessage(){
        return new WebDriverWait(driver, 60).until(d->d.findElement(By.className("alert-success"))).getText();
    }

    
    
}

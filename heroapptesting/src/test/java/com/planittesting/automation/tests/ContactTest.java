package com.planittesting.automation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.planittesting.automation.model.pages.HomePage;
import com.planittesting.automation.model.data.ContactData;
import com.planittesting.automation.model.pages.ContactPage;

import org.junit.jupiter.api.Test;

public class ContactTest extends BaseTest {

    @Test
    public void validateEroorMessages() throws Exception{
        ContactPage contactPage = open(HomePage.class)
        .clickOnContactMenu()
        .clickOnSubmitButton();
                                    
        assertEquals("Forename is required", contactPage.getForenameError());
        assertEquals("Email is required", contactPage.getEmailError());
        assertEquals("Message is required", contactPage.getMessageError());
    }

    @Test
    public void validateEroorMessagesAreGone() throws Exception{

        var data = new ContactData("sandeep", "shriyan", "a@b.com", "0444444444", "Hello");
        ContactPage contactPage = open(HomePage.class)
        .clickOnContactMenu()
        .clickOnSubmitButton()
        .setContactData(data);
                                    
        assertEquals("", contactPage.getForenameError());
        assertEquals("", contactPage.getEmailError());
        assertEquals("", contactPage.getMessageError());
    }

    @Test
    void validateSuccessMessage() throws Exception{

        var data = new ContactData("sandeep", "shriyan", "a@b.com", "0444444444", "Hello");
        var message = open(HomePage.class)
        .clickOnContactMenu()
        .setContactData(data)
        .clickOnSubmitButton()
        .getSuccessMessage();
                                    
        assertEquals("Thanks "+data.forename()+", we appreciate your feedback.", message);
    }
    
    
}

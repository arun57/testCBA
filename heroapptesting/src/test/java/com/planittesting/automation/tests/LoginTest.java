package com.planittesting.automation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.planittesting.automation.model.data.LoginData;
import com.planittesting.automation.model.pages.HomePage;

import io.github.cdimascio.dotenv.Dotenv;

class LoginTest extends BaseTest{
    private Dotenv env = Dotenv.configure().load();

    @Test
    void validateSuccessfulLogin() throws Exception{
        var username = env.get("USERNAME");
        var password = env.get("PASSWORD");
        var data = new LoginData(username, password);
        var user = open(HomePage.class)
        .clickOnLoginMenu()
        .login(data)
        .getUser();

        assertEquals(username, user);
    }

    @Test
    void validateSuccessfulLogout() throws Exception{
        var username = env.get("USERNAME");
        var password = env.get("PASSWORD");
        var data = new LoginData(username, password);
        var user = open(HomePage.class)
        .clickOnLoginMenu()
        .login(data)
        .clickOnLogoutMenu()
        .clickOnLogoutButton()
        .getUser();

        assertEquals("", user);
    }
    
}

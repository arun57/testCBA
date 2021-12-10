package com.planittesting.automation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.planittesting.automation.model.pages.HomePage;

import org.junit.jupiter.api.Test;

class CartTest extends BaseTest{

    @Test
    void validatePricesinCartPage() throws Exception{
        var shopPage = open(HomePage.class)
                        .clickOnShopMenu();
        var fluffyBunnyPrice = shopPage.getProduct(p->p.getProductTitle().equals("Fluffy Bunny"))
                                    .clickOnBuyButton()
                                    .clickOnBuyButton()
                                    .clickOnBuyButton()
                                    .getProductPrice();

        var smileyBearPrice = shopPage.getProduct(p->p.getProductTitle().equals("Smiley Bear"))
                                    .clickOnBuyButton()
                                    .clickOnBuyButton()
                                    .getProductPrice();

        var funnyCowPrice = shopPage.getProduct(p->p.getProductTitle().equals("Funny Cow"))
                                    .clickOnBuyButton()
                                    .getProductPrice();

        var cartPage = shopPage.clickOnCartMenu();

        assertEquals(fluffyBunnyPrice, cartPage.getPrice("Fluffy Bunny"));
        assertEquals(smileyBearPrice, cartPage.getPrice("Smiley Bear"));
        assertEquals(funnyCowPrice, cartPage.getPrice("Funny Cow"));
                        
    }

    @Test
    void validateTotalPrice() throws Exception {
        var shopPage= open(HomePage.class).clickOnShopMenu();
        shopPage.getProduct(p->p.getProductTitle().equals("Smiley Bear"))
        .clickOnBuyButton()
        .clickOnBuyButton()
        .clickOnBuyButton();

        var cartPage = shopPage.clickOnCartMenu();

        assertEquals(41.97,cartPage.calculatePrice("Smiley Bear"));
    }
    
}

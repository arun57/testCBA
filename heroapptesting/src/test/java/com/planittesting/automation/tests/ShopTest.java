package com.planittesting.automation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.planittesting.automation.model.pages.HomePage;

import org.junit.jupiter.api.Test;

class ShopTest extends BaseTest{

    @Test
    void validateProductPrice()throws Exception{
        var price = open(HomePage.class)
        .clickOnShopMenu()
        .getProduct(p->p.getProductTitle().equals("Teddy Bear"))
        //.getProduct(p->p.getProductTitle().equals("Stuffed Frog"))
        .getProductPrice();

        assertEquals(12.99, price);
        //assertEquals(10.99, price);
    }

    @Test
    void validateProductTitle()throws Exception{
        var title = open(HomePage.class)
        .clickOnShopMenu()
        .getProduct(p->p.getProductPrice()==12.99)
        //.getProduct(p->p.getProductPrice()==10.99)
        .getProductTitle();

        assertEquals("Teddy Bear", title);
        //assertEquals("Stuffed Frog", title);
    }

    @Test
    void validateProductCartCount() throws Exception{
        open(HomePage.class)
                    .clickOnShopMenu()
                    .getProduct(p->p.getStars()==5)
                    .clickOnBuyButton();
        var count = open(HomePage.class).getCartCount();
        assertEquals(1, count);
    } 
    
}

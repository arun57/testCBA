package com.planittesting.automation.model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {
    public WebElement rootElement;

    public Product(WebElement rootElement){
        this.rootElement = rootElement;
    }

    public String getProductTitle(){
        return rootElement.findElement(By.className("product-title")).getText();
    }

    public double getProductPrice(){
        return Double.parseDouble(rootElement.findElement(By.className("product-price")).getText().replaceAll("[^0-9\\.]+", ""));
    }

    public int getStars(){
        return Integer.parseInt(rootElement.findElement(By.className("star-level")).getText());
    }

    public Product clickOnBuyButton(){
        rootElement.findElement(By.className("btn")).click();
        return this;
    }
    
}

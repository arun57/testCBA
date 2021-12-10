package com.planittesting.automation.model.pages;

import com.planittesting.automation.model.components.ui.Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage<CartPage>{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public double getPrice(String productName){
        return Double.parseDouble(getTable().getElement("Item", productName, "Price").getText().replaceAll("[^0-9\\.]+", "")

        );
    }

    public int getQuantity(String productName){
       return Integer.parseInt(getTable().getElement("Item", productName, "Quantity").findElement(By.className("input-mini")).getAttribute("value"));
    }

    public double calculatePrice(String productName) {
       return (Double)(getQuantity(productName)*getPrice(productName));
    }

    public Table getTable(){
        return new Table(driver.findElement(By.className("cart-items")));
    }
    
}

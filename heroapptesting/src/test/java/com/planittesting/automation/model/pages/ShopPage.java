package com.planittesting.automation.model.pages;

import com.google.common.base.Predicate;
import com.planittesting.automation.model.components.Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage extends BasePage<ShopPage>{

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    /*public Product getProductByTitle(String title){
        var elements = driver.findElements(By.className("product"));
        for (var element : elements) {
            var product = new Product(element);
            if(product.getProductTitle().equals(title)){
                return product;
            } 
        }
        throw new RuntimeException("Product not found");

    }

    public Product getProductByPrice(double price){
        var elements = driver.findElements(By.className("product"));
        for (var element : elements) {
            var product = new Product(element);
            if(product.getProductPrice() == price){
                return product;
            } 
        }
        throw new RuntimeException("Product not found");

    }*/

   /* public Product getProduct(Predicate<Product> comparison){
        return driver.findElements(By.className("product"))
        .stream()
        .map(e-> new Product(e))
        .filter(p->comparison.test(p))
        .findFirst()
        .orElseThrow();
    }*/
    public Product getProduct(Predicate<Product> comparison){
        return driver.findElements(By.className("product"))
        .stream()
        .map(Product::new)
        .filter(comparison::test)
        .findFirst()
        .orElseThrow();
    }   

}

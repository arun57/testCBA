package com.planittesting.automation.model.components.ui;

import java.util.stream.IntStream;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table {
    public WebElement rootElement;

    public Table(WebElement rootElement){
        this.rootElement = rootElement;
    }
    
    public WebElement getElement(String searchColumn, String searchValue, String returnColumn){
        var searchColumnIndex = getIndex(searchColumn);
        var returnColumnIndex = getIndex(returnColumn);
        
        var rows = rootElement.findElements(By.cssSelector("tbody tr"));
        for(var row: rows){
            var cells = row.findElements(By.cssSelector("td,th"));
            if(cells.get(searchColumnIndex).getText().equals(searchValue)){
                return cells.get(returnColumnIndex);
            }
        }
        throw new RuntimeException("Cell not found");
    }

    public int getIndex(String column){
        var elements = rootElement.findElements(By.cssSelector("thead th"));
        return IntStream.range(0,elements.size())
        .filter(i->elements.get(i).getText().equals(column))
        .findFirst()
        .getAsInt();
    }
}

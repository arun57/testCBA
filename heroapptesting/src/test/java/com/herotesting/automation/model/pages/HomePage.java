package com.herotesting.automation.model.pages;

import java.util.ArrayList;

import com.herotesting.automation.model.data.QuesAnsData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage<HomePage>{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public HomePage createWorrier(String worrier) {
        driver.findElement(By.id("worrior_username")).sendKeys(worrier);
        driver.findElement(By.id("warrior")).click();
        driver.findElement(By.id("start")).click();
        return this;
    }

    public HomePage startFirstTest() {
        driver.findElement(By.linkText("Are you game?")).click();
        driver.findElement(By.className("btn-primary")).click();
        driver.findElement(By.linkText("Continue reading")).click();
        clickContinue();
        driver.findElement(By.partialLinkText("Research into personal protective equipment")).click();
        clickContinue();
        return this;
    }

    public HomePage startSecondTest() {
        driver.findElement(By.linkText("Take the bus")).click();
        driver.findElement(By.className("btn-primary")).click();
        return this;
    }

    public void clickContinue(){
        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Continue...']"))));
        driver.findElement(By.xpath("//*[text()='Continue...']")).click();
    }

    public void clickTryNext(){
        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Try the next battle']"))));
        driver.findElement(By.xpath("//*[text()='Try the next battle']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Start']"))));
        driver.findElement(By.xpath("//*[text()='Start']")).click();
    }   

    public ArrayList<QuesAnsData> initializeAnswerSet() {
        //Initialise record question with the corresponding correct answer
        var data1 = new QuesAnsData("Your coworker Markus, is constantly coughing in the office, what do you do?","Use your superhero Social Distance","");
        var data2 = new QuesAnsData("You must travel to buy food and medical supplies?", "Cover any sneezes or coughs with your superhero","Use your superheroes Mask and sanitizer");
        var data3 = new QuesAnsData("Someone sits next you, and is beginning to cough, what do you do?","Move to another seat immediately and report it to the driver!","");
        var data4 = new QuesAnsData("You notice a large group of people waiting in line next to each other at a restaurant, what do you do?","Use your super hero sanitizer","");
        var data5 = new QuesAnsData("You notice one of the waiters serving food is ill and handling orders at a restaurant, what do you do?", "Use reasonable logic, keep distance","");
        var data6 = new QuesAnsData("You notice the people at the bar are re-using shot glasses for a group round of drinks, what do you do?","Do not ignore the sign of possible contamination","");
        var data7 = new QuesAnsData("Mary from HR, send a memo advising she is ill and everyone should reach her via email, what do you do?", "Use your superhero Social Distancing","");
        var data8 = new QuesAnsData("Your Manager Alex, tells you his partner recently came back from overseas, and is seen constantly sneezing during the day, what do you do?","Use your superhero Social Distance","");
        var data9 = new QuesAnsData("Fantastic, you have succeeded on all battlefields and have not contracted covid19. A cure is not out there yet so make sure you continue the good work and keep yourself and others safe.", "Yes I know","");

        ArrayList<QuesAnsData> quesAns = new ArrayList<>();
        quesAns.add(data1);
        quesAns.add(data2);
        quesAns.add(data3);
        quesAns.add(data4);
        quesAns.add(data5);
        quesAns.add(data6);
        quesAns.add(data7);
        quesAns.add(data8);
        quesAns.add(data9);
        return quesAns;
    }

    public HomePage answerFirstGame() throws InterruptedException {
        var quesAns = initializeAnswerSet();
        int i=0;
        //Running a loop for number of rounds
        while(i<8) {
            // Fetch the question from the page
            //Short wait for question to load
            Thread.sleep(1000);
            String Ques = driver.findElement(By.id("question")).getText();
            //Navigate through each question and answer record initialised above and find the correct answer
             for (QuesAnsData qa : quesAns) {
                if(qa.question().contains(Ques)) {
                driver.findElement(By.partialLinkText(qa.answer())).click();
                clickContinue();
                }
             } 
             i++;   
            }
            driver.findElement(By.id("leaderboard_link")).click(); 
            return this;     
    }

    public String isElementPresent(By elementLocator) {
        var elements = driver.findElements(elementLocator);
        return elements.size()>0 ? elements.get(0).getText() : "";
    }

    public void getScore() {
        driver.findElement(By.partialLinkText("Go to the leaderboard and check your score.")).click();
    }
    public HomePage answerSecondGame() {
        var quesAns = initializeAnswerSet();
        int i=0;
        //Running a loop for number of rounds
        while(i<9) {
        String Ques = driver.findElement(By.cssSelector("p[class='option-label text-center']")).getText();
        //Navigate through each question and answer record initialised above and find the correct answer
        for (QuesAnsData qa : quesAns) {
            if(qa.question().contains(Ques)) {
                
                String link=isElementPresent(By.partialLinkText(qa.answer())).isBlank() ? qa.answer1() : qa.answer();
                driver.findElement(By.partialLinkText(link)).click();
                
                clickTryNext();
            }
        } 
            i++;   
        }
        return this;
    }
}

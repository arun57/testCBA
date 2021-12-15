package com.herotesting.automation.tests;


import com.herotesting.automation.model.pages.HomePage;

import org.junit.jupiter.api.Test;

public class SampleTest extends BaseTest{

    public void launchingapplication(){
        
    }
  /*  
  @Test
    public void startTest() throws Exception {
        open(HomePage.class).createWorrier("Test");
    }*/

    @Test
    public void answerTest() throws Exception {
        open(HomePage.class).createWorrier("Test2").startFirstTest().answerFirstGame().startSecondTest().answerSecondGame().getScore();
    }
}

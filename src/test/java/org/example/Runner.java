package org.example;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/pranavasree/Downloads/Blibli_Integration-testing/src/test/resoures/Blibli.feature", tags= "")

public class Runner {
    DriverManager driverManager=new DriverManager();
//    @After
//    public  void quit() {
//        WebDriver driver=driverManager.getDriver();
//        driver.quit();
//    }
}

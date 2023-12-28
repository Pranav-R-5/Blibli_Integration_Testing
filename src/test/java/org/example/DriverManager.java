package org.example;

import org.openqa.selenium.WebDriver;
 class DriverManager {
     static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }





}

package org.example;

import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BlibliUi {

    public void navigate(WebDriver driver, String url) throws InterruptedException{
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();
        String title=driver.getTitle();

//        Assert.assertTrue(title.equals("Categoryname Desember 2023 banyak pilihan - Harga Murah | Blibli"));
        try {
            driver.findElement(By.xpath("//button[@class='blu-btn b-secondary']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//div[@class='brz-popup2__close']")).click();

        } catch (Exception e) {
            System.out.println("No pop up");
        }
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='brz-popup2__close']"))));


    }
    public void loginbutton(WebDriver driver){
        driver.findElement(By.xpath("//button[@class='blu-btn btn__login b-outline b-small btn__login--festive']")).click();
    }

    public void usernameLogin(String username,WebDriver driver) throws InterruptedException{
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//input[@value='localValue']"));
        email.click();
        email.sendKeys(username);
    }

    public void  passwordLogin(String pass,WebDriver driver) {
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.click();
        password.sendKeys(pass);
    }

    public void login(WebDriver driver) {

        WebElement loginButton = driver.findElement(By.xpath("//div[@class='login__button']/button"));
        loginButton.click();
    }
    public void otpverification(WebDriver driver,String otp) throws InterruptedException{
        Thread.sleep(2000);
        WebElement enter=driver.findElement(By.xpath("//div[@class='otp-type-selection__send']/button"));
        enter.click();
        Thread.sleep(1000);
        List<WebElement> otpfield=driver.findElements(By.xpath("//ul[@class='otp__codeField']/li"));
        for(WebElement ele:otpfield){
            WebElement key=ele.findElement(By.xpath("//input[@class='otp__textField space active']"));
            key.click();
            key.sendKeys(otp);
        }

    }

    public void searchKeyword(String keyword,WebDriver driver) throws InterruptedException{
//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='searchbox']"))));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='search']")));
        Thread.sleep(3000);
        WebElement search=driver.findElement(By.xpath("//input[@name='search']"));
        search.click();
        search.sendKeys(keyword);
        driver.findElement(By.xpath("//button[@class='searchbox__search']")).click();
    }

    public void applyFilter(WebDriver driver) throws InterruptedException{
//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//button[@class='blu-btn b-secondary b-small']"))));
        Thread.sleep(7000);
            driver.findElement(By.xpath("//button[@class='blu-btn b-secondary b-small']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='QUICK_blibli']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='blu-btn b-secondary b-small']")).click();
    }

    public void selectProduct(WebDriver driver){
        driver.findElement(By.xpath("//div[@class='blu-product product__card']")).click();
    }

    public void addQuantity(WebDriver driver,int quantity) throws  InterruptedException{
        Thread.sleep(4000);

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));
        WebElement addQuantity = driver.findElement(By.xpath("//*[contains(text(), 'Tambah ke Bag')]//preceding::*[@class='blu-input-stepper']//button[@class='blu-btn blu-input-stepper__plus b-ghost b-secondary']"));
        while (quantity>1) {
            addQuantity.click();
            quantity--;
        }
        driver.findElement(By.xpath("//button[@class='blu-btn b-secondary btn-checkout']")).click();

    }

    public void addAddress(WebDriver driver,String address)throws  InterruptedException{
        Thread.sleep(13000);
        driver.findElement(By.xpath("//button[@data-testid='onboardingSkipButton']")).click();
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='address__section__label-and-button-container__button']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='blu-btn b-outline has-left-icon b-secondary b-small']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='dropdown-menu__header']")).click();
        Thread.sleep(1000);
        WebElement location=driver.findElement(By.xpath("//input[@type='search']"));
        location.click();
        Thread.sleep(1000);
        location.sendKeys(address);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='address-search__error-loc']")).click();
        location.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='autocomplete__item']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")).click();

//        South Tanjung Duren
        Thread.sleep(2000);
        List<WebElement> textField=driver.findElements(By.xpath("//input[@type='text']"));
        for (WebElement input:textField){
            input.click();
            input.sendKeys("Testing");
        }
        WebElement phoneNo=driver.findElement(By.xpath("//input[@type='tel']"));
        phoneNo.click();
        phoneNo.sendKeys("08213450");
        js.executeScript("document.getElementsByClassName('blu-btn footer__button b-full-width b-secondary')[0].scrollIntoView(true);");
        driver.findElement(By.xpath("//button[@class='blu-btn footer__button b-full-width b-secondary']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='blu-btn b-secondary']")).click();

    }

    public void changePayment(WebDriver  driver) throws InterruptedException{
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[@class='payment-item__detail__name__button']")).click();
        List<WebElement> methods=driver.findElements(By.xpath("//div[@class='payment-option__content--container']/div"));
        for (WebElement method:methods){
            System.out.println(method.getText());
            if(method.getText().equals(" Bank BNI ")){
               method.click();
               break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")).click();
    }

    public void placeOrder(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("document.getElementsByClassName('blu-btn summary__button pay-button has-left-icon b-full-width b-secondary')[0].scrollIntoView(true);");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='blu-btn summary__button pay-button has-left-icon b-full-width b-secondary']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='blu-btn b-secondary']")).click();

    }
    public void cancelOrder(WebDriver driver) throws InterruptedException{
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='blu-btn cancel-order__button b-outline b-secondary']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='blu-btn b-secondary']")).click();
    }

    public void verify(WebDriver driver) throws InterruptedException{
        Thread.sleep(4000);
        String status =driver.findElement(By.xpath("//div[@class='payment-section-header__title']")).getText();
        System.out.println(status);
        Assert.assertTrue(status.equals("Pesanan dibatalkan"));
    }

}

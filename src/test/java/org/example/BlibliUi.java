package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class BlibliUi{
    WebDriver driver ;
    WebDriverWait wait;


    public void navigate(String url){
        driver = DriverManager.getDriver();
        wait =new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get(url);
        driver.manage().window().maximize();
        String title=driver.getTitle();
        System.out.println(title);
        title = title.replace("\u00a0", " ");
        Assert.assertTrue(title.equals("Categoryname Desember 2023 banyak pilihan - Harga Murah | Blibli"));
        try {
            driver.findElement(By.xpath("//button[@class='blu-btn b-secondary']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='brz-popup2__close']")));
            driver.findElement(By.xpath("//div[@class='brz-popup2__close']")).click();

        } catch (Exception e) {
            System.out.println("No pop up");
        }


    }
    public void loginbutton(){
        WebElement loginButton=driver.findElement(By.xpath("//button[@class='blu-btn btn__login b-outline b-small btn__login--festive']"));
        loginButton.click();
        String name=loginButton.getText();
        System.out.println(name);
        Assert.assertEquals(name,"Masuk");
    }

    public void usernameLogin(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='localValue']")));
        WebElement email = driver.findElement(By.xpath("//input[@value='localValue']"));
        email.click();
        email.sendKeys(username);
    }

    public void  passwordLogin(String pass) {
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.click();
        password.sendKeys(pass);
    }

    public void login() {

        WebElement loginButton = driver.findElement(By.xpath("//div[@class='login__button']/button"));
        loginButton.click();
    }
    public void otpverification(String otp) throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='otp-type-selection__send']/button")));
        WebElement enter=driver.findElement(By.xpath("//div[@class='otp-type-selection__send']/button"));
        enter.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='otp__codeField']/li")));
        List<WebElement> otpfield=driver.findElements(By.xpath("//ul[@class='otp__codeField']/li"));
        for(WebElement ele:otpfield){
            WebElement key=ele.findElement(By.xpath("//input[@class='otp__textField space active']"));
            key.click();
            key.sendKeys(otp);
        }

    }

    public void verifyLogin(String name){
        WebElement profile =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='b-flex b-ai-center'])[2]")));
        String profileName=profile.getText();
        System.out.println(profileName);
        Assert.assertEquals(profileName,name);

    }

    public void searchKeyword(String keyword) throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='search']")));
        Thread.sleep(3000);
        WebElement search=driver.findElement(By.xpath("//input[@name='search']"));
        search.click();
        search.sendKeys(keyword);
        driver.findElement(By.xpath("//button[@class='searchbox__search']")).click();
    }

    public void applyFilter(String filtername) throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-secondary b-small']")));
            driver.findElement(By.xpath("//button[@class='blu-btn b-secondary b-small']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='blu-chip b-secondary']")));
        List<WebElement> filters=driver.findElements(By.xpath("//label[@class='blu-chip b-secondary']"));
        for(WebElement filter:filters)
        {
            if(filter.getText().equals(filtername))
            {
                wait.until(ExpectedConditions.visibilityOf(filter));
                filter.click();
                break;
            }
        }
        try{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-secondary b-small']")));
        driver.findElement(By.xpath("//button[@class='blu-btn b-secondary b-small']")).click();}catch (Exception e){}

    }

    public void selectProduct(String keyword){
        WebElement product=driver.findElement(By.xpath("//div[@class='blu-product product__card']"));
        String productName=driver.findElement(By.xpath("//div[@class='blu-product__name']")).getText();
//        keyw();
//        System.out.println(keyword);
//        System.out.println(productName);
//        Assert.assertTrue(productName.contains(keyword));
        product.click();
    }

    public void addQuantity(int quantity) throws  InterruptedException{

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Tambah ke Bag')]//preceding::*[@class='blu-input-stepper']//button[@class='blu-btn blu-input-stepper__plus b-ghost b-secondary']")));
        WebElement addQuantity = driver.findElement(By.xpath("//*[contains(text(), 'Tambah ke Bag')]//preceding::*[@class='blu-input-stepper']//button[@class='blu-btn blu-input-stepper__plus b-ghost b-secondary']"));
        while (quantity>1) {
            addQuantity.click();
            quantity--;
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='blu-btn b-secondary btn-checkout']")).click();

    }

    public void addAddress(String address,String name,String mobileNo)throws  InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='onboardingSkipButton']")));
        driver.findElement(By.xpath("//button[@data-testid='onboardingSkipButton']")).click();
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='address__section__label-and-button-container__button']")));
        driver.findElement(By.xpath("//span[@class='address__section__label-and-button-container__button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-outline has-left-icon b-secondary b-small']")));
        driver.findElement(By.xpath("//button[@class='blu-btn b-outline has-left-icon b-secondary b-small']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dropdown-menu__header']")));
        driver.findElement(By.xpath("//div[@class='dropdown-menu__header']")).click();
        WebElement location=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search']")));
        location.click();
        location.sendKeys(address);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='address-search__error-loc']")));
        driver.findElement(By.xpath("//div[@class='address-search__error-loc']")).click();
        location.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autocomplete__item']")));
        driver.findElement(By.xpath("//div[@class='autocomplete__item']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
        List<WebElement> textField=driver.findElements(By.xpath("//input[@type='text']"));
        for (WebElement input:textField){
            input.click();
            input.sendKeys(name);
        }
        WebElement phoneNo=driver.findElement(By.xpath("//input[@type='tel']"));
        phoneNo.click();
        phoneNo.sendKeys(mobileNo);
        js.executeScript("document.getElementsByClassName('blu-btn footer__button b-full-width b-secondary')[0].scrollIntoView(true);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn footer__button b-full-width b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn footer__button b-full-width b-secondary']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn b-secondary']")).click();

    }

    public void changePayment(String bankname) throws InterruptedException{
        Thread.sleep(7000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='payment-item__detail__name']")));
        driver.findElement(By.xpath("//span[@class='payment-item__detail__name__button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='payment-option__content']")));
        List<WebElement> methods=driver.findElements(By.xpath("//div[@class='payment-option__content']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement method:methods){

            if(method.getText().equals(bankname)){
                js.executeScript("window.scrollTo(0, 300);");
                System.out.println(bankname);
                Thread.sleep(2000);
                wait.until(ExpectedConditions.visibilityOf(method));
               method.click();
               break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")).click();
    }

    public void changeShipment(String type) throws InterruptedException{
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='shipment__header__change-button']")));
        driver.findElement(By.xpath("//div[@class='shipment__header__change-button']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='shipping-option__header__name']")));
        List<WebElement> shippingMethod=driver.findElements(By.xpath("//span[@class='shipping-option__header__name']"));
        for(WebElement shipmentType:shippingMethod)
        {
            if(shipmentType.getText().equals(type))
            {
                js.executeScript("window.scrollTo(0, 300);");
                System.out.println();
                wait.until(ExpectedConditions.visibilityOf(shipmentType));
                shipmentType.click();
                break;
            }
        }
//        Thread.sleep(2000);

    }

    public void placeOrder() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.getElementsByClassName('blu-btn summary__button pay-button has-left-icon b-full-width b-secondary')[0].scrollIntoView(true);");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn summary__button pay-button has-left-icon b-full-width b-secondary']")));

        driver.findElement(By.xpath("//button[@class='blu-btn summary__button pay-button has-left-icon b-full-width b-secondary']")).click();
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-secondary']")));
            driver.findElement(By.xpath("//button[@class='blu-btn b-secondary']")).click();}
        catch (Exception e){}

    }
    public void cancelOrder() throws InterruptedException{
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn cancel-order__button b-outline b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn cancel-order__button b-outline b-secondary']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn b-secondary']")).click();
    }

    public void verify() throws InterruptedException{
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='payment-section-header__title']")));
        String status =driver.findElement(By.xpath("//div[@class='payment-section-header__title']")).getText();
        System.out.println(status);
        Assert.assertTrue(status.equals("Pesanan dibatalkan"));
    }

}

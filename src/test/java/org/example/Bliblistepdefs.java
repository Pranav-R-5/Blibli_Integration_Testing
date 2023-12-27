package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.BlibliApi;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AddWebDriverSpecHeaders;

public class Bliblistepdefs {

    String keyword="";
    Response response;
    BlibliApi blibliApi=new BlibliApi();

    ChromeDriver driver;
    BlibliUi blibliUi=new BlibliUi();

    @Given("user fetch response from the api {string}")
    public void userFetchResponseFromTheApi(String url) {
        response=blibliApi.getResponse(url);
    }

    @And("get the keyword from the response")
    public void getTheKeywordFromTheResponse() {
        keyword=blibliApi.getKeyword(response);
    }


    @When("user navigates to blibli site {string}")
    public void userNavigatesToBlibliSite(String url) throws InterruptedException {
        driver=new ChromeDriver();
        blibliUi.navigate(driver,url);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        blibliUi.loginbutton(driver);
    }

    @And("user enter username {string}")
    public void userEnterUsername(String username) throws InterruptedException {
        blibliUi.usernameLogin(username,driver);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        blibliUi.passwordLogin(password,driver);
    }

    @And("user clicks login")
    public void userClicksLogin() {
        blibliUi.login(driver);
    }

    @And("user enters the OTP {string}")
    public void userEntersTheOTP(String otp) throws InterruptedException {
        blibliUi.otpverification(driver,otp);
    }

    @When("user search the keyword fetched")
    public void userSearchTheKeywordFetched() throws InterruptedException {
        blibliUi.searchKeyword(keyword,driver);
    }

    @And("user apply distekan blibli filter")
    public void userApplyDistekanBlibliFilter() throws InterruptedException {
        blibliUi.applyFilter(driver);
    }


    @And("user select a product")
    public void userSelectAProduct() {
        blibliUi.selectProduct(driver);
    }


    @And("user add quantity {int}")
    public void userAddQuantity(int quantity) throws InterruptedException {
        blibliUi.addQuantity(driver,quantity);
    }

    @And("user add the address {string}")
    public void userAddTheAddress(String address) throws InterruptedException {
        blibliUi.addAddress(driver,address);
    }

    @And("user change payment method")
    public void userChangePaymentMethod() throws InterruptedException {
        blibliUi.changePayment(driver);
    }

    @And("user place order")
    public void userPlaceOrder() throws InterruptedException {
        blibliUi.placeOrder(driver);
    }

    @And("user cancel the order")
    public void userCancelTheOrder() throws InterruptedException {
        blibliUi.cancelOrder(driver);
    }


    @And("user verify the cancellation")
    public void userVerifyTheCancellation() throws InterruptedException {
        blibliUi.verify(driver);
    }
}

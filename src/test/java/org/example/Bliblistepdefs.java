package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Bliblistepdefs extends DriverManager{

    String keyword="";
    Response response;
    BlibliApi blibliApi=new BlibliApi();

    ChromeOptions options;
    DriverManager driverManager;
    WebDriver driver = driverManager.getDriver();


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
    public void userNavigatesToBlibliSite(String url){
        options = new ChromeOptions();
        driver = new ChromeDriver(options.addArguments("--disable-notifications"));
        new DriverManager().setDriver(driver);
        blibliUi.navigate(url);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        blibliUi.loginbutton();
    }

    @And("user enter username {string}")
    public void userEnterUsername(String username){
        blibliUi.usernameLogin(username);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        blibliUi.passwordLogin(password);
    }

    @And("user clicks login")
    public void userClicksLogin() {
        blibliUi.login();
    }

    @And("user enters the OTP {string}")
    public void userEntersTheOTP(String otp) throws InterruptedException {
        blibliUi.otpverification(otp);
    }
    @Then("user {string} logged successfully")
    public void userLoggedSuccessfully(String profileName) {
        blibliUi.verifyLogin(profileName);
    }

    @When("user search the keyword fetched")
    public void userSearchTheKeywordFetched() throws InterruptedException {
        blibliUi.searchKeyword(keyword);
    }

    @And("user apply {string} filter")
    public void userApplyFilter(String filter) throws InterruptedException {
        blibliUi.applyFilter(filter);
    }


    @And("user select a product")
    public void userSelectAProduct() {
        blibliUi.selectProduct(keyword);
    }


    @And("user add quantity {int}")
    public void userAddQuantity(int quantity) throws InterruptedException {
        blibliUi.addQuantity(quantity);
    }

    @And("user add the address {string} with label {string} ,mobile: {string}")
    public void userAddTheAddressWithLabelMobile(String address, String name, String mobileNo) throws InterruptedException {
        blibliUi.addAddress(address,name,mobileNo);
    }

    @And("user change payment method to {string}")
    public void userChangePaymentMethodTo(String method) throws InterruptedException {
        blibliUi.changePayment(method);
    }

    @And("user place order")
    public void userPlaceOrder() throws InterruptedException {
        blibliUi.placeOrder();
    }

    @And("user cancel the order")
    public void userCancelTheOrder() throws InterruptedException {
        blibliUi.cancelOrder();
    }


    @And("user verify the cancellation")
    public void userVerifyTheCancellation() throws InterruptedException {
        blibliUi.verify();
    }

    @And("user change the shipment to {string}")
    public void userChangeTheShipmentTo(String type) throws InterruptedException {
        blibliUi.changeShipment(type);
    }


}

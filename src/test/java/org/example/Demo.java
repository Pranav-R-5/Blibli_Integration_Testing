//package org.example;
//
//import io.restassured.response.Response;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class Demo {
//    public static void main(String[] args) throws InterruptedException {
//        BlibliApi blibliApi=new BlibliApi();
//        String url="https://wwwpreprod.gdn-app.com/backend/search/getSeedKeyword";
//        Response response=blibliApi.getResponse(url);
//        String  keyword=blibliApi.getKeyword(response);
//        System.out.println(keyword);
//
//        String blibliUrl="https://wwwpreprod.gdn-app.com/";
//        String email="+6281234500001";
//        String password="Test@1234";
//        ChromeOptions options = new ChromeOptions();
//        WebDriver driver = new ChromeDriver(options.addArguments("--disable-notifications"));
//        BlibliUi blibliUi=new BlibliUi();
//        blibliUi.navigate(driver,blibliUrl);
//        blibliUi.loginbutton(driver);
//        blibliUi.usernameLogin(email,driver);
//        blibliUi.passwordLogin(password,driver);
//        blibliUi.login(driver);
//        blibliUi.otpverification(driver,"3");
//        blibliUi.searchKeyword(keyword,driver);
//        blibliUi.applyFilter(driver);
//        blibliUi.selectProduct(driver);
//        blibliUi.addQuantity(driver,2);
//        blibliUi.addAddress(driver,"South Tanjung Duren");
//        blibliUi.changePayment(driver);
//        blibliUi.placeOrder(driver);
//        blibliUi.cancelOrder(driver);
//        blibliUi.verify(driver);
//
//
//    }
//}

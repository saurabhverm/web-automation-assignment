package amazonTest;

import annotations.Author;
import annotations.Tester;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.CartPage;
import pages.ProductPage;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.Map;

public class addToCartTestMobileView{

    public WebDriver driver1;
    protected AmazonHomePage amazonHomePage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected ConfigReader configReader;

    @BeforeTest
    public void launchMobileEmulationMode() throws Exception {
        WebDriverManager.chromedriver().setup();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver1 = new ChromeDriver(chromeOptions);
        amazonHomePage = new AmazonHomePage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        configReader = new ConfigReader();

    }

    @Author(name = Tester.Saurabh)
    @Test
    public void userShouldAbleToAddPhoneToCartOnAmazonMobileView(){
        driver1.get(configReader.getAmazonBaseUrl());
        amazonHomePage.enterSearchItem();
        productPage.selectIphoneWrtSearch();
        productPage.clickAddToCart();
        cartPage.goToCart();
        cartPage.verifyPhoneNameWrtSearch();
        cartPage.verifyPriceDisplaying();
        cartPage.verifyQuantity();
    }

    @AfterTest
    public void quit(){
        if(driver1!=null){
            driver1.quit();
        }
    }
}

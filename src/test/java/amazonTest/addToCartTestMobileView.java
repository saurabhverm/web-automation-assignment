package amazonTest;

import annotations.Author;
import annotations.Tester;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import testbase.TestBase;

import java.util.HashMap;
import java.util.Map;

public class addToCartTestMobileView extends TestBase {

    public WebDriver driver1;

    @BeforeTest
    public void launchMobileEmulationMode(){
        WebDriverManager.chromedriver().setup();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver1 = new ChromeDriver(chromeOptions);
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
}

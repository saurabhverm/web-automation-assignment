package testbase;

import drivers.DriverInitializer;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import pages.AmazonHomePage;
import pages.CartPage;
import pages.ProductPage;
import utilities.ConfigReader;

import java.util.concurrent.TimeUnit;


public class TestBase {

    public static WebDriver driver;
    protected ConfigReader configReader;
    protected AmazonHomePage amazonHomePage;
    protected ProductPage productPage;
    protected CartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {
        driver = new DriverInitializer("chrome").init();
        configReader = new ConfigReader();
        amazonHomePage = new AmazonHomePage();
        productPage = new ProductPage();
        cartPage = new CartPage();
    }

    protected void navigateTo(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

   // @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
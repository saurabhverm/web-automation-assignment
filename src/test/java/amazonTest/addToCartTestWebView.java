package amazonTest;

import annotations.Author;
import annotations.Tester;
import org.testng.annotations.Test;
import testbase.TestBase;

public class addToCartTestWebView extends TestBase {

    @Author(name = Tester.Saurabh)
    @Test
    public void userShouldAbleToAddPhoneToCartOnAmazonWebView(){
        navigateTo(configReader.getAmazonBaseUrl());
        amazonHomePage.enterSearchItem();
        productPage.selectIphoneWrtSearch();
        productPage.clickAddToCart();
        cartPage.goToCart();
        cartPage.verifyPhoneNameWrtSearch();
        cartPage.verifyPriceDisplaying();
        cartPage.verifyQuantity();
    }
}

package pages;

import drivers.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends BasePage {

    int QUANTITY_IN_THE_CART;

    @FindBy(id =  "hlb-view-cart-announce")
    private WebElement cartButton;

    @FindBy(css = ".a-size-medium.sc-product-title.a-text-bold")
    private WebElement name;

    @FindBy(css = ".a-size-medium.a-color-price.sc-price.sc-white-space-nowrap.sc-product-price.sc-price-sign.a-text-bold")
    private WebElement price;

    @FindBy(css = ".a-dropdown-prompt")
    private WebElement quantity;


    public CartPage(){
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void goToCart(){
        cartButton.click();
    }

    public void verifyPhoneNameWrtSearch(){
        Assert.assertTrue(name.getText().contains("Midnight Green"));
    }

    public void verifyPriceDisplaying(){
        Assert.assertTrue(price.isDisplayed());
    }

    public void verifyQuantity(){
        QUANTITY_IN_THE_CART = Integer.parseInt(quantity.getText());

        Assert.assertEquals(QUANTITY_IN_THE_CART, 1);
    }
}

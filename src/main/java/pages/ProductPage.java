package pages;

import drivers.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class ProductPage extends BasePage {

    SoftAssert softAssert = new SoftAssert();

    @FindBy(css = ".a-size-medium.a-color-base.a-text-normal")
    private List<WebElement> iPhoneList;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;


    public ProductPage(){
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void selectIphoneWrtSearch(){

        for(int iPhone = 0; iPhone<iPhoneList.size(); iPhone++){
            if(iPhoneList.get(iPhone).getText().contains("Midnight Green")){
                iPhoneList.get(iPhone).click();
                break;
            }
        }

        for(int iPhone = 0; iPhone<iPhoneList.size(); iPhone++){
            if(iPhoneList.get(iPhone).getText().contains("Midnight Green")){
                iPhoneList.get(iPhone).click();
                break;
            }
        }
    }

    public void clickAddToCart(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        addToCartButton.click();
    }
}

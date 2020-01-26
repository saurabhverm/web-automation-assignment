package pages;

import drivers.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import searchkey.SearchItem;

import java.util.List;

public class AmazonHomePage extends BasePage {

    @FindBy(css = ".nav-input")
    private List<WebElement> searchField;

    public AmazonHomePage(){
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void enterSearchItem(){
        searchField.get(1).sendKeys(SearchItem.IPHONE);
        searchField.get(0).click();
    }
}

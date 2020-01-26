package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;


public class BasePage {

	public static WebDriver driver;

	public void acceptAlertPopUp(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert(){
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

}


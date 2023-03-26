package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout {

	
private static WebElement element = null;
	
	public static WebElement click_on_checkout(WebDriver driver) {
		element = driver.findElement(By.id("checkoutButton"));
		return element;
	}
	
}

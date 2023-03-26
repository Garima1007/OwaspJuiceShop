package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

	private static WebElement element = null;

	public static WebElement navbar_acount(WebDriver driver) {
		element = driver.findElement(By.id("navbarAccount"));
		return element;
	}

	public static WebElement navbar_login(WebDriver driver) {
		element = driver.findElement(By.id("navbarLoginButton"));
		return element;
	}

	public static WebElement textbox_email(WebDriver driver) {
		element=driver.findElement(By.id("email"));
		return element;
	}

	public static WebElement textbox_password(WebDriver driver) {
		element= driver.findElement(By.id("password"));
		return element;
	}

	public static WebElement button_login(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@id='loginButton']"));
		return element;

	}


}

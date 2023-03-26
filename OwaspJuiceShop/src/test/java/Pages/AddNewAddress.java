package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewAddress {

	static WebElement element = null;

	//	By button_add_new_address = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-address-select[1]/div[1]/app-address[1]/mat-card[1]/div[1]/button[1]/span[1]/span[1]");
	//	
	//	
	//	By address_form = By.id("address-form");
	//	
	//	By add_country_name = By.xpath("//body/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-address-create[1]/div[1]/mat-card[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]");
	//	
	//	public AddNewAddress(WebDriver driver) {
	//		this.driver=driver;
	//		
	//	}
	//	
	//	public void clickaddnewaddressbutton() {
	//		driver.findElement(button_add_new_address).click();
	//	}
	//	
	//	public void clickCountryTextbox() {
	//		driver.findElement(add_country_name).click();
	//	}
	//	
	//	public void setTextinCountry(String text) {
	//		driver.findElement(add_country_name).sendKeys(text);
	//	}

	public static WebElement button_add_new_address(WebDriver driver) {
		element= driver.findElement(By.xpath("//*[@id=\"card\"]/app-address/mat-card/div/button"));
		return element;

	}
//	public static WebElement address_form(WebDriver driver) {
//		element=driver.findElement(By.id("address-form"));
//		return element;
//
//	}
	public static WebElement add_country_name(WebDriver driver) {
		element=driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]"));
		return element;

	}
		public static WebElement name(WebDriver driver) {
			element=driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]"));
			return element;
	
		}
		public static WebElement mobile_number(WebDriver driver) {
			element=driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]"));
			return element;
	
		}
		public static WebElement zip_code(WebDriver driver) {
			element=driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]"));
			return element;
	
		}
		public static WebElement add_address(WebDriver driver) {
			element=driver.findElement(By.id("address"));
			return element;
	
		}
		public static WebElement add_city(WebDriver driver) {
			element=driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]"));
			return element;
	
		}
		public static WebElement add_state(WebDriver driver) {
			element=driver.findElement(By.xpath("//*[@id=\"mat-input-9\"]"));
			return element;
	
		}
		public static WebElement clickSubmitbutton(WebDriver driver) {
			element = driver.findElement(By.id("submitButton"));
			return element;
		}



}

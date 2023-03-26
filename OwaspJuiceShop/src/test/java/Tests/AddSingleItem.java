package Tests;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.Login;
import Pages.Checkout;
import Pages.AddNewAddress;

public class AddSingleItem {


	private static WebDriver driver = null;
	//	public static void main(String[] args) {

	
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver.get("https://salaryhero-qa-challenge.herokuapp.com");
		driver.manage().window().maximize();

	


		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//      Wait for Pop-up to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//mat-dialog-container[@id='mat-dialog-0']")));
		//      Fetch a web element on the pop-up
		WebElement dismiss = driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]"));
		//		WebElement dismiss = driver.findElement(
		//				By.cssSelector("body.mat-app-background.bluegrey-lightgreen-theme:nth-child(2) div.cdk-overlay-container.bluegrey-lightgreen-theme:nth-child(8) div.cdk-global-overlay-wrapper div.cdk-overlay-pane mat-dialog-container.mat-dialog-container.cdk-dialog-container.ng-tns-c37-10.ng-trigger.ng-trigger-dialogContainer.ng-star-inserted:nth-child(2) app-welcome-banner.ng-star-inserted div.mat-typography div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted:nth-child(2)"));

		System.out.println("pop-up element fetched");
		//      Take action on the fetched web element on the pop-up
		dismiss.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pop-up closed");
	}
	@BeforeClass
	public void login() {
		Login.navbar_acount(driver).sendKeys(Keys.RETURN);

		Login.navbar_login(driver).sendKeys(Keys.RETURN);

		Login.textbox_email(driver).sendKeys("sharma.garima1007@gmail.com");

		Login.textbox_password(driver).sendKeys("Owasp@2023");

		Login.button_login(driver).sendKeys(Keys.RETURN);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Login Successful");

	}
	@Test
	public void addItems() {
		driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[2]/div/mat-card/div[2]/button")).click();
		//code to add a single item into basket
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-search-result[1]/div[1]/div[1]/div[2]/mat-grid-list[1]/div[1]/mat-grid-tile[2]/div[1]/mat-card[1]/div[2]/button[1]/span[1]/span[1]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("One item added to basket");
		//code to view basket with added item
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-navbar[1]/mat-toolbar[1]/mat-toolbar-row[1]/button[4]/span[1]/span[1]")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Checkout.click_on_checkout(driver).sendKeys(Keys.RETURN);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("User redirected to checkout page");

		AddNewAddress.button_add_new_address(driver).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("User redirected to add new address page");


		AddNewAddress.add_country_name(driver).sendKeys("Thailand");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AddNewAddress.name(driver).sendKeys("Garima Sharma");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AddNewAddress.mobile_number(driver).sendKeys("9928455276");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AddNewAddress.zip_code(driver).sendKeys("10110");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddNewAddress.add_address(driver).sendKeys("26th Floor, Fullerton, Sukhumvit");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddNewAddress.add_city(driver).sendKeys("Bangkok");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddNewAddress.add_state(driver).sendKeys("Bangkok");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddNewAddress.clickSubmitbutton(driver).sendKeys(Keys.RETURN);

	}



	@AfterTest
	public void close_browser() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}

}

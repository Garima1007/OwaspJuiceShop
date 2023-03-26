package Pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

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
		WebElement dismiss = driver.findElement(
				By.cssSelector("body.mat-app-background.bluegrey-lightgreen-theme:nth-child(2) div.cdk-overlay-container.bluegrey-lightgreen-theme:nth-child(8) div.cdk-global-overlay-wrapper div.cdk-overlay-pane mat-dialog-container.mat-dialog-container.cdk-dialog-container.ng-tns-c37-10.ng-trigger.ng-trigger-dialogContainer.ng-star-inserted:nth-child(2) app-welcome-banner.ng-star-inserted div.mat-typography div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted:nth-child(2)"));

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
		
		//Code for login
		driver.findElement(By.id("navbarAccount")).click();
		driver.findElement(By.id("navbarLoginButton")).click();
		driver.findElement(By.name("email")).sendKeys("sharma.garima1007@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Owaspjuice1@2023");
		driver.findElement(By.xpath("//button[@id='loginButton']")).click();

		System.out.println("Login Successful");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();

	}
}

















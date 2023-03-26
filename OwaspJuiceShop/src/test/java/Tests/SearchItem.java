package Tests;

import java.time.Duration;
import java.util.List;
import org.junit.Assert;
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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchItem {

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
	@Test
	public void search() {
		//code to expand search bar
		driver.findElement(By.xpath("//*[@id=\"searchQuery\"]/span/mat-icon[2]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("apple");
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys(Keys.RETURN);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		List <WebElement> result = driver.findElements(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list"));

		result.size();

		for(int i=0;i<result.size();i++)
		{

			String listItem = result.get(i).getText();

			System.out.println(listItem);

			//			System.out.println("Total result count: " + resultCount);
			String itemName1 = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[1]/div[2]/div[1]")).getText();
			Assert.assertEquals(listItem.contains("apple"), itemName1.contains("apple"));
			System.out.println("first assertion passed");

			String itemName2 = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[1]/div[2]/div[1]")).getText();
			Assert.assertEquals(listItem.contains("banana"), itemName2.contains("apple"));

			System.out.println("second assertion passed");

			String itemName3 = driver.findElement(By.xpath("//html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[2]/div/mat-card/div[1]/div[2]/div[1]")).getText();
			Assert.assertEquals(listItem.contains("apple"), itemName3.contains("apple"));

			System.out.println("third assertion passed");

			String itemName4 = driver.findElement(By.xpath("//html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[2]/div/mat-card/div[1]/div[2]/div[1]")).getText();
			Assert.assertEquals(listItem.contains("banana"), itemName4.contains("apple"));

			System.out.println("fourth assertion passed");
		}


	}
	@AfterTest
	public void close_browser() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}



}




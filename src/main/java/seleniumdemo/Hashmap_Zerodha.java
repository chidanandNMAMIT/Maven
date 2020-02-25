package seleniumdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.HashMapInSelenium;

public class Hashmap_Zerodha {

	public static WebDriver driver;
	public static Actions action;

	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "F:\\chidanand\\software downloaded\\chromedriver.exe");
		options.addArguments("--desable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com");
	}

	@Test(priority = 1)
	public void AddToCart() throws InterruptedException {

		WebElement profileimage = driver.findElement(By.xpath("//span[text()='Profile']"));
		action = new Actions(driver);
		action.moveToElement(profileimage).perform();
		driver.findElement(By.xpath("//a[text()='log in']")).click();
		driver.findElement(By.name("email")).sendKeys("aravindcr11@gmail.com");
		driver.findElement(By.name("password")).sendKeys("aravind");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Roadster Shoes");
		driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();
		WebElement element = driver.findElement(By.xpath("//ul[@class='results-base']//li[1]"));
		action.moveToElement(element).build().perform();
		driver.findElement(By.xpath("(//span[text()='Add to bag'])[1]")).click();
		driver.findElement(By.xpath("(//button[@class='product-sizeButton'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Bag']")).click();
		driver.findElement(By.xpath(
				"(//div[@class='itemContainer-base-item '])[1]/child::div[2]//div[@class='itemComponents-base-quantity']"))
				.click();
		
		int no_ofQuantuty=HashMapInSelenium.Quantity_select().get("Nine");
		WebElement locality = driver.findElement(By.xpath("//div[@class='dialogs-base-list']/child::div["+no_ofQuantuty+"]"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", locality);
		locality.click();

	}
}
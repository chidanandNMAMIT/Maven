package seleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mongodb.client.model.ReturnDocument;

public class AddAddress {

	public static Actions action;
	public static WebDriver driver;

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

	@DataProvider
	public Object[][] getMyntraTestData() {
		Object data[][] = ExceldataProvider.getTestdata("AddAddress");
		return data;
	}

	@Test(priority = 1, dataProvider = "getMyntraTestData")
	public void AddToCart(String name, String Mobileno, String pincode, String Address) throws InterruptedException {

				WebElement profileimage = driver.findElement(By.xpath("//span[text()='Profile']"));
		action = new Actions(driver);
		action.moveToElement(profileimage).perform();
		driver.findElement(By.xpath("//a[text()='log in']")).click();
		driver.findElement(By.name("email")).sendKeys("aravindcr11@gmail.com");
		driver.findElement(By.name("password")).sendKeys("aravind");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("mobiles");
		driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();
		WebElement element = driver.findElement(By.xpath("//ul[@class='results-base']//li[1]"));
		action.moveToElement(element).build().perform();
		driver.findElement(By.xpath("(//span[text()='Add to bag'])[1]")).click();
		driver.findElement(By.xpath("(//button[@class='product-sizeButton'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Bag']")).click();
		driver.findElement(By.xpath("//div[text()='Place Order']")).click();

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("mobile")).sendKeys(Mobileno);
		driver.findElement(By.id("pincode")).sendKeys(pincode);
		driver.findElement(By.id("streetAddress")).sendKeys(Address);
		driver.findElement(By.id("locality")).click();

		WebElement locality = driver.findElement(By.id("locality-4"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", locality);
		locality.click();
		
	}

}

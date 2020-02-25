package seleniumDemo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyntraLogin {

	public static WebDriver driver;
	
	
	 @Test
		public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","F:\\chidanand\\software downloaded\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			WebDriverWait wait = new WebDriverWait(driver, 30);
			Actions action = new Actions(driver);
			WebElement profile = driver.findElement(By.xpath("//span[text()='Profile']"));
			wait.until(ExpectedConditions.visibilityOf(profile));
			action.moveToElement(profile).perform();
			driver.findElement(By.xpath("//a[text()='log in']")).click();
			
			 driver.findElement(By.name("email")).sendKeys("chidanand5531@gmail.com");
			
			driver.findElement(By.name("password")).sendKeys("chidanand");
			driver.findElement(By.xpath("//button[text()='Log in']")).click();
			
			Thread.sleep(5000);
			
			WebElement searchBar = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
			wait.until(ExpectedConditions.visibilityOf(searchBar));
			searchBar.sendKeys("Nike shoes");
			driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']"))
					.click();
			WebElement product = driver.findElement(By.xpath("(//ul[@class='results-base']//li)[1]"));
			wait.until(ExpectedConditions.visibilityOf(product));
			action.moveToElement(product);
			product.click();
			
			String ParentWndow = driver.getWindowHandle();
			
			Set<String> allWindows = driver.getWindowHandles();
			Iterator<String> it = allWindows.iterator();
			while (it.hasNext()) {
				String childWindow = it.next();
				if (!ParentWndow.equals(childWindow)) {
					driver.switchTo().window(childWindow);
					driver.findElement(By.xpath("(//div[@class='size-buttons-buttonContainer'])[3]")).click();
					driver.findElement(By.xpath(
							"//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']"))
							.click();
			driver.findElement(By.xpath("//span[text()='Bag']")).click();
			driver.findElement(By.xpath("//button[text()='Remove']")).click();
			driver.close();
			driver.switchTo().window(ParentWndow).close();;
				}
			
			
			}
	}
	
}


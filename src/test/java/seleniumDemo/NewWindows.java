package seleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewWindows {

	public static void main(String[] args) throws Exception {
		
		ChromeOptions options =new ChromeOptions();
		System.setProperty("webdriver.chrome.driver","F:\\chidanand\\software downloaded\\chromedriver.exe");
		options.addArguments("--desable-notifications");
		WebDriver driver=new ChromeDriver(options);
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
			driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//ul[@class='results-base']/li[1]")).click();
			driver.findElement(By.xpath("//ul[@class='results-base']/li[2]")).click();
			
			String originalHandle=driver.getWindowHandle();
			
			 for(String handle : driver.getWindowHandles()) {
			        if (!handle.equals(originalHandle)) {
			            driver.switchTo().window(handle);
			            driver.close();
			        }
			    }
			    driver.switchTo().window(originalHandle);

	}

}

package seleniumDemo;

import java.util.List;
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

public class Amazon_5Star {

	
	
	public static Actions action;
	public static WebDriver driver;
	public static JavascriptExecutor je;

	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "F:\\chidanand\\software downloaded\\chromedriver.exe");
		options.addArguments("--desable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");
	}
	
	@Test
	public void search() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple laptop");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.id("a-autoid-0-announce")).click();
		
		List<WebElement> options=driver.findElements(By.xpath("//div[@class='a-popover-inner']/ul/li"));
		int size=options.size();
		
		for (int i = 0; i < size; i++) {
			String temp=options.get(i).getText();
			if(temp.contains("Price: High to Low")) {
				options.get(i).click();
				break;
			}
		}
		
		List<WebElement> Staroptions=driver.findElements(By.xpath("//div[@class='s-include-content-margin s-border-bottom']//span[contains(@aria-label,'out of 5 stars')]"));
		 je=(JavascriptExecutor)driver;
		int size1=Staroptions.size();
		
		for (int i = 0; i < size1; i++) {
			String temp=Staroptions.get(i).getAttribute("aria-label");
			System.out.println(temp);
			if(temp.contains("5.0")) {
				Staroptions.get(i).click();
				break;
			}
		}
		
		
	}	
}


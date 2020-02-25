package seleniumDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Amazonassinment {

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
		driver.get("https://www.amazon.in");
	}
	
	@Test
	public void search() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple iPhone XR (64GB) - Yellow");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String elements="//span[@cel_widget_id='SEARCH_RESULTS-SEARCH_RESULTS']//div[@class='s-include-content-margin s-border-bottom']//a[@class='a-link-normal a-text-normal']";
		List<WebElement> options=driver.findElements(By.xpath(elements));
		int size1=options.size();
		
		for (int i = 0; i < size1; i++) {
			String temp=options.get(i).getText();
			System.out.println("Mobile name : "+temp);
			if(temp.contains("Apple iPhone XR (64GB) - Yellow")) {
				String price=driver.findElement(By.xpath("//div[@data-index='"+i+"']//span[@class='a-price-whole']")).getText();
				System.out.println("Mobile Price : "+price);
				break;
			}
		}	
	}
	
}

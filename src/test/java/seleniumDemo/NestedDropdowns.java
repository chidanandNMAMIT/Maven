package seleniumDemo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedDropdowns {

	public static WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\chidanand\\software downloaded\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.toolsqa.com");

	}
	
	@Test
	public void DuplicatedropDown()
	{
		WebElement element=driver.findElement(By.xpath("(//span[text()='DEMO SITES'])[1]"));
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		WebElement element1=driver.findElement(By.xpath("(//span[text()='Automation Practice Form'])[1]"));
		action.moveToElement(element1).build().perform();
		element1.click();
		WebElement Continets=driver.findElement(By.id("continents"));
		Select select=new Select(Continets);
		
		List<WebElement> options=select.getOptions();
		System.out.println(options.size());
		
		Set<WebElement> set=new HashSet<WebElement>();
		set.addAll(options);
		
		
		//Assert.assertEquals(options.size(), options.size());
		
	}
}

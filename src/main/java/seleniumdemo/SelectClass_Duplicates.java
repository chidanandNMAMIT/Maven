package seleniumdemo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass_Duplicates {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "F:\\chidanand\\software downloaded\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.gcrit.com/build3/create_account.php");
		
		WebElement country=driver.findElement(By.name("country"));
		Select select=new Select(country);
		List<WebElement> options=select.getOptions();
		System.out.println("Total countries in dropdown are "+ options.size());
		
		Set<WebElement> hSet=new HashSet<WebElement>();
		hSet.addAll(options);
		System.out.println("Total countries in dropdown are "+hSet.size());
		
		driver.close();
	}

}

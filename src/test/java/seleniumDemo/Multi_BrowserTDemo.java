package seleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Multi_BrowserTDemo {
	
	WebDriver driver=null;
	
	
	@BeforeTest
	@Parameters("browserName")
	public void setUp(String browserName) {
		System.out.println("BrowserName is :"+browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","F:\\chidanand\\software downloaded\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","F:\\chidanand\\software downloaded\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver","F:\\chidanand\\software downloaded\\IEDriverServer.exe.exe");
			driver=new InternetExplorerDriver();
		}
	}
	
	@Test
	public void test1() {
		driver.get("https://www.myntra.com");
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}

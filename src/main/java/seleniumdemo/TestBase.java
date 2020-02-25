package seleniumdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	public static WebDriver driver;

public static void initialization(String BrowserName, String URL) {
		
		try {
		switch(BrowserName.toLowerCase()) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "F:\\chidanand\\software downloaded\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "F:\\chidanand\\software downloaded\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "IE":
			System.setProperty("webdriver.InternetExplorer.driver",
					"F:\\chidanand\\software downloaded\\InternetExplorerDriver.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("browser : " + BrowserName + " is invalid");
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(URL);

		}
}

package seleniumDemo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Notification_PopUp {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","F:\\chidanand\\software downloaded\\chromedriver.exe");		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.redbus.in");

	}

}

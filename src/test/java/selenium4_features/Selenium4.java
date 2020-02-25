package selenium4_features;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4 {

	@Test
	public void Launch() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");

		WebElement Myntralogo = driver
				.findElement(By.xpath("//a[@class='myntraweb-sprite desktop-logo sprites-headerLogo']"));
		File file = Myntralogo.getScreenshotAs(OutputType.FILE);
		File destinFile = new File("logo.png");
		try {
			FileUtils.copyFile(file, destinFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		driver.quit();
	}

	@Test
	public void openNewTab_NewWindow() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\chidanand\\software downloaded\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");

		 driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("http://www.newtours.demoaut.com/");
		Thread.sleep(5000);
		driver.quit();
	}

}

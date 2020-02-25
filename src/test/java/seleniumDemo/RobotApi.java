package seleniumDemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotApi {

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver", "F:\\chidanand\\software downloaded\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.irctcbuddhisttrain.com/");
		driver.findElement(By.id("dropdownDownload")).click();
		
		Robot robo=new Robot();
/*		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_ENTER);*/
	
		robo.mouseMove(630, 420); 	
		robo.delay(1500);
		robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
	}

}

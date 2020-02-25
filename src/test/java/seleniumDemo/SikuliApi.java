package seleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliApi {

	public static void main(String[] args) throws FindFailed {
		System.setProperty("webdriver.chrome.driver", "F:\\chidanand\\software downloaded\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.seleniumhq.org/");
		
		Screen s=new Screen();
		
		Pattern downloadtext=new Pattern("F:\\chidanand\\javanaveenautomationlabs\\maven\\download.png");
		s.wait(downloadtext,2000);
		s.click();
	
		
		Pattern seleniumVrs=new Pattern("F:\\chidanand\\javanaveenautomationlabs\\maven\\seleniunVersion.png");
		s.wait(seleniumVrs,2000);
		s.click();
		
		Pattern Discard=new Pattern("F:\\chidanand\\javanaveenautomationlabs\\maven\\discard.png");
		s.wait(Discard,2000);
		s.click();
		
	}

}

package seleniumdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import edu.emory.mathcs.backport.java.util.Collections;
import edu.emory.mathcs.backport.java.util.TreeSet;

public class SortDropDown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\chidanand\\software downloaded\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.gcrit.com/build3/create_account.php");
		
		WebElement country=driver.findElement(By.name("country"));
		Select select=new Select(country);
		List<String> originalList = new ArrayList();
		List<String> tempList = new ArrayList();
		
		for (WebElement e : select.getOptions()) {
			originalList.add(e.getText());
			tempList.add(e.getText());
		}
/*		
		System.out.println("Before sorting "+originalList);
		Collections.sort(tempList);
		System.out.println("After sorting "+tempList);
		Assert.assertEquals(originalList, tempList);
	*/
		//By using TreeSet
		Set<String> treeset = new TreeSet(originalList);
		Assert.assertEquals(originalList, treeset);
		driver.close();
	}
}

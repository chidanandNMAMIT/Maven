package seleniumdemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartHashMap {

	public static String text = "Apple iPhone XR (64GB) - Yellow";

	public static void main(String[] args) {

		String url = "https://www.flipkart.com";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(url);
		// Checking page is navigated with the expected title
		String actual = driver.getTitle();
		String expected = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(actual, expected);

		// Clicking on Cross button
		WebElement sign_in_cross = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		sign_in_cross.click();

		// Check Search Box is Displayed
		WebElement searchbx = driver.findElement(By.xpath("//input[@name ='q' and @type='text']"));
		Assert.assertEquals(searchbx.isDisplayed(), true);
		searchbx.sendKeys(text);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement txtbx_search_result_text = driver.findElement(
				By.xpath("//div[@class='_3UEiDE']//span[contains(text(),'Showing 1 – 9 of 9 results for')]"));
		Assert.assertEquals(txtbx_search_result_text.isDisplayed(), true);

		List<WebElement> MobilesName = driver.findElements(By.xpath("//div[@class='_3O0U0u']//div[@class='_3wU53n']"));
		System.out.println("MobileName in flipkart is :" + MobilesName);
		List<WebElement> Mobilesprice = driver
				.findElements(By.xpath("//div[@class='_3O0U0u']//div[@class='_1vC4OE _2rQ-NK']"));

		Map<String, Integer> map = new HashMap<String, Integer>();

		if (MobilesName.size() == Mobilesprice.size()) {
			for (int i = 0; i < MobilesName.size(); i++) {
				String mobilename = MobilesName.get(i).getText();
				String mobprice = Mobilesprice.get(i).getText().replaceAll("[^0-9]", "");
				int MobilePrice = Integer.parseInt(mobprice);
				map.put(mobilename, MobilePrice);
			}
		}

		for (Map.Entry e : map.entrySet()) {

			if (e.getKey().equals(text)) {
				String mobprice = (String) e.getKey();
				int price = (int) e.getValue();
				System.out.println("Mobile name : " + mobprice + "And Mobile price is :" + price);
				//div[@class='_1HmYoV _35HD7C col-8-12']//div[@class='_1vC4OE _3qQ9m1']
			}

		}
	}
	


}

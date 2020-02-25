package seleniumdemo;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

     public static double m=0,r=0;
	
	public static void main(String[] args) throws ParseException {

		System.setProperty("webdriver.chrome.driver", "F:\\chidanand\\software downloaded\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/gainers");
		
		List<WebElement>TotalNoOfColums=driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		System.out.println("Total no of Column Size ---> "+TotalNoOfColums.size());
		
		List<WebElement>TotalNoOfRows=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		System.out.println("Total no of Row Size --->"+TotalNoOfRows.size());
		
		
		for(double i=1; i<TotalNoOfRows.size(); i++) {
			
			String max=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+(i+1)+"]/td[4]")).getText();
			NumberFormat f =NumberFormat.getNumberInstance(); 
            max = f.parse(max).toString();
            m = Double.parseDouble(max);
            if(m>r)
             {    
                r=m;
             }

        }
        System.out.println("Maximum current price of is ---> : " + r);
       
	}

}

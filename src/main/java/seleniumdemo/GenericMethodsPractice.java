package seleniumdemo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GenericMethodsPractice extends TestBase{
	
	@BeforeMethod
	public void setUp() {
	initialization("chrome", "https://demoqa.com/");
	}
	
	@Test(priority=1)
   public void brokenLinkTest() throws MalformedURLException, IOException {
		Utils.BrokenLinks();
	}
   
   @Test(priority=2)
   public void newWindowTest() throws InterruptedException {
	  
	   Utils.scrollDown();
	   driver.findElement(By.xpath("//a[text()='Automation Practice Switch Windows']")).click();
	   driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();
	   Utils.switchToNewWindow();
		driver.findElement(By.xpath("(//span[text()='Tutorial' ])[1]")).click();
	  Utils.switchToParentWindow();
	  Utils.refresh();
	  driver.findElement(By.xpath("//a[text()='Interactions']")).click();
	  driver.findElement(By.xpath("//a[text()='Sortable']")).click();
	  WebElement DragElement=driver.findElement(By.xpath("//ul[@id='sortable']/li[7]"));
	  WebElement DropElement=driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
	  Thread.sleep(3000);
	  Utils.dragAndDrop(DragElement, DropElement);
	 
   }
   
   @Test(priority=3)
   public void DropDownTest() throws InterruptedException {
	   Utils.scrollDown();
	   driver.findElement(By.xpath("//a[text()='Selectmenu']")).click();
	   driver.findElement(By.xpath("(//span[@class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s'])[1]")).click();
	   WebElement alloptions=driver.findElement(By.name("speed"));
	   Thread.sleep(3000);
	   Utils.selectByVisibleText(alloptions,"Slower");
	   
   }
   
   
  // @Test(priority=4)
   public void FileUploadTest() throws FindFailed, InterruptedException {
	   driver.findElement(By.xpath("//a[text()='Keyboard Events']")).click();
	   driver.findElement(By.id("browseFile")).click();
	   Thread.sleep(5000);
	   Utils.SikuliFileUploadload("F:\\chidanand\\javanaveenautomationlabs\\maven\\SikuliImages\\cowphoto.png");
	   Utils.SikuliFileUploadload("F:\\chidanand\\javanaveenautomationlabs\\maven\\SikuliImages\\OpenBtn.png");
	   driver.findElement(By.id("uploadButton")).click();
   }
   
   @AfterMethod
   public void tearDown() {
	   driver.quit();
   }
	

	
   
}

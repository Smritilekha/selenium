package Source;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class HDFCBank {

	public static void main(String[] args) throws IOException {
		
		//Desired Capabilities is used to set the type of browser and OS that we will automate
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.WIN8_1);
		
		//Remote WEbdriver is used to set which node (or machine) that our test will run against
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.82:4444/wd/hub"), dc);
		
		
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement mouseover=  driver.findElement(By.xpath("//li[4]/div/span"));
		WebElement mouseclick=driver.findElement(By.xpath("//li[4]/div[2]/div[2]/div/ul/li[8]/a"));
		
		String parentwindow = driver.getWindowHandle();
	     Actions act = new Actions(driver);
	     act.moveToElement(mouseover).perform();
	     act.click(mouseclick).perform();
	     
	     for(String window: driver.getWindowHandles())
	     {
	    	 driver.switchTo().window(window);
	     }
	     
	     System.out.println(driver.getTitle());
	     WebElement ele = driver.findElement(By.id("eForm_form_propertyCity_value"));
			
			Select ele1 = new Select(ele);
			//ele1.selectByIndex(0);
			ele1.selectByValue("AHMEDABAD");
			//ele1.selectByVisibleText(text);
			WebElement drop2 = driver.findElement(By.id("eForm_form_details_property_propertyPurchaseType"));
			Select ele2 = new Select(drop2);
			ele2.selectByVisibleText("Transfer your existing home loan");
			driver.close();
			driver.switchTo().window(parentwindow);
		
	     
	     
	     

	}

}

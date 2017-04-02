package source1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HDFCBank {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("http://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement mouseover=driver.findElement(By.xpath("//*[@id='']/div/div[2]/div[2]/ul/li[4]/div/span"));
		WebElement mouseclick=driver.findElement(By.xpath("//*[@id='']/div/div[2]/div[2]/ul/li[4]/div[2]/div[2]/div/ul/li[8]/a"));
		Actions act=new Actions(driver);
		act.moveToElement(mouseover).perform();
		act.moveToElement(mouseclick).click().perform();
		driver.getWindowHandle();
		for(String window: driver.getWindowHandles())
	     {
	    	 driver.switchTo().window(window);
	     }
	     
	     System.out.println(driver.getTitle());
		
	     WebElement element =driver.findElement(By.xpath("//*[@id='']/label"));
	    
	     Select element1 = new Select(element);

		
		
		
		
				}
}

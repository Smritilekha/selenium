package functions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WrapperMethods {
	
	 WebDriver driver;
	
	public static  String timestamp()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	public  void takeSnap()
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("snap_"+timestamp()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void launchBrowser(String url)
	{
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public void enterById(String loc,String value)
	{
		driver.findElement(By.id(loc)).sendKeys(value);
	}
	
	public void clickByClassName(String loc)
	{
		driver.findElement(By.className(loc)).click();
	}
	
	public String title()
	{
		String tit = driver.getTitle();
		return tit;
	}
	public void closeApp()
	{
		driver.close();
	}
	
	public void cssSelector(String loc)
	{
		driver.findElement(By.cssSelector("loc")).click();
	}
	
	public void clickById(String loc)
	{
		driver.findElement(By.id("loc")).click();;
	}
	
	public void clickByXpath(String loc)
	{
		driver.findElement(By.xpath("loc")).click();;
	}
	
	public void clickByPartialLink(String loc)
	{
		driver.findElement(By.partialLinkText("loc")).click();;
	}
	
	public void clickByLinkText(String loc)
	{
		driver.findElement(By.linkText("loc")).click();;
	}
	
	public void selectByIndexUsingName(String loc,String value)
	{
		WebElement drop2 = driver.findElement(By.id(loc));
		Select ele2 = new Select(drop2);
		ele2.selectByVisibleText(value);
	}
}















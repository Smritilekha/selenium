package source1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Coordinates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.navigate().to("https://jqueryui.com/droppable/");
		
	WebElement ele = 	driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[2]/a"));
	
	System.out.println(ele.getSize().getHeight());
	System.out.println(ele.getSize().getWidth());
	driver.findElement(By.xpath(".//*[@id='menu-top']/li[2]/a")).click();
	driver.navigate().back();
	WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='menu-top']/li[3]/a")));
	
	
	
	
		}

}

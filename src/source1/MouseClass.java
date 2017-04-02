package source1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseClass {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.navigate().to("https://jqueryui.com/droppable/");
		
	    WebElement ele = driver.findElement(By.xpath(".//*[@id='content']/iframe"));
		
		driver.switchTo().frame(ele);
		
		WebElement box1= driver.findElement(By.xpath(".//*[@id='draggable']"));
		WebElement box2=driver.findElement(By.xpath(".//*[@id='droppable']"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(box1, box2).build().perform();
		driver.switchTo().defaultContent();
		//driver.findElement(By.xpath(".//*[@id='menu-top']/li[2]/a")).click();
		driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[5]/a")).click();;
		
	    WebElement ele1 = driver.findElement(By.xpath(".//*[@id='content']/iframe"));
		
		driver.switchTo().frame(ele1);
		
		WebElement item1 = driver.findElement(By.xpath(".//*[@id='sortable']/li[1]"));
		Point coordinates = driver.findElement(By.xpath(".//*[@id='sortable']/li[5]")).getLocation();
		System.out.println(coordinates);
		//builder.dragAndDrop(item1, item5).build().perform();
		builder.dragAndDropBy(item1, 11, 172).build().perform();
		driver.switchTo().defaultContent();
		
		
		
		
	}

}

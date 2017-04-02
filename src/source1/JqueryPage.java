package source1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class JqueryPage {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("https://jqueryui.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement mouseclick=driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[2]/a"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseclick).click().perform();
		
		WebElement f1=driver.findElement(By.xpath(".//*[@id='content']/iframe"));
		driver.switchTo().frame(f1);
		WebElement box1 = driver.findElement(By.xpath(".//*[@id='draggable']"));
		WebElement box2 = driver.findElement(By.xpath(".//*[@id='droppable']"));
		
		act.dragAndDrop(box1, box2).build().perform();
		
		driver.switchTo().defaultContent();
		driver.navigate().back();
		
		driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[5]/a")).click();
		
	    WebElement ele1 = driver.findElement(By.xpath(".//*[@id='content']/iframe"));
		
		driver.switchTo().frame(ele1);		
		WebElement item1=driver.findElement(By.xpath(".//*[@id='sortable']/li[1]"));
		Point item2coordinates=   driver.findElement(By.xpath(".//*[@id='sortable']/li[6]")).getLocation();
		System.out.println(item2coordinates);
		act.dragAndDropBy(item1, 11, 213).build().perform();
		driver.switchTo().defaultContent();
		driver.navigate().back();
		
		driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[4]/a")).click();
		
		WebElement ele2 = driver.findElement(By.xpath(".//*[@id='content']/iframe"));
			
		driver.switchTo().frame(ele2);	
		
		WebElement i1=driver.findElement(By.xpath(".//*[@id='selectable']/li[1]"));
		WebElement i2=driver.findElement(By.xpath(".//*[@id='selectable']/li[2]"));
		WebElement i3=driver.findElement(By.xpath(".//*[@id='selectable']/li[3]"));
		WebElement i4=driver.findElement(By.xpath(".//*[@id='selectable']/li[4]"));
		
		Actions act1 = new Actions(driver);

		act1.clickAndHold(i1).clickAndHold(i4).perform();
		act1.release(i1).release(i4).build().perform();
		//driver.switchTo().defaultContent();
		
		driver.navigate().back();
		
		driver.close();
		
		
	}

}

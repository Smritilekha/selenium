package source1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertClass {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		
		WebElement ele = driver.findElement(By.id("iframeResult"));
		
		driver.switchTo().frame(ele);
		
		driver.findElement(By.xpath("//*[text()='Try it']")).click();
		
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		
		a.accept();
		
		
	String alertmessage = 	driver.findElement(By.xpath(".//*[@id='demo']")).getText();
	
	String alertexpected = "You pressed OK!";
	
	if(alertmessage.equalsIgnoreCase(alertexpected))
	{
		System.out.println("Test is passed");
		
	}
	else
	{
		System.out.println("Test is failed");
		
	}
	
	
	}
	
	}



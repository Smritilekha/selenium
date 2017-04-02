package source1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class W3Schools {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("https://www.w3schools.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> divtag = driver.findElements(By.tagName("div"));
		System.out.println(divtag.size());
		
	}

}

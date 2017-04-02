package Source;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ICICIBank {

	public static void main(String[] args) throws IOException {
		
		FileReader fr=new FileReader("fileproperty2.properties");
		Properties pr=new Properties();
		pr.load(fr);
		
	
		
		WebDriver driver= new FirefoxDriver();
		driver.navigate().to(pr.getProperty("url"));;
		driver.manage().window().maximize();
		WebElement mouseover=driver.findElement(By.xpath(pr.getProperty("xpath1")));
		WebElement mouseclick=driver.findElement(By.xpath(pr.getProperty("xpath2")));
		Actions act=new Actions(driver);
		act.moveToElement(mouseover).perform();
		act.click(mouseclick).perform();
		WebElement mouseclick1=driver.findElement(By.xpath(pr.getProperty("xpath3")));
		act.click(mouseclick1).perform();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.id(pr.getProperty("xpath4")).sendKeys(pr.getProperty("value1"));
		driver.findElement(( By.id(pr.getProperty("xpath5"))).sendKeys(pr.getProperty("value2")));
		WebElement mouseclick3=driver.findElement(By.id(pr.getProperty("value6")));
		act.click(mouseclick3).perform();

		
	}

}

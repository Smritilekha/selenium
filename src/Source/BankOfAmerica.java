package Source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class BankOfAmerica {
                   
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.bankofamerica.com/");
		driver.manage().window().maximize();
		WebElement mouseover = driver.findElement(By.xpath(".//*[@id='hp-section-2']/form/ul/li[1]/a"));
	     WebElement mouseclick =     driver.findElement(By.xpath("//div[@id='pm-submenu-first']/div[1]/a"));
	     
	     Actions act = new Actions(driver);
	     act.moveToElement(mouseover).perform();
	     act.click(mouseclick).perform();
	     
	     
	     
	}

}
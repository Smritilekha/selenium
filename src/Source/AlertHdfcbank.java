package Source;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertHdfcbank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.icicibank.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='push-modal-close']"));
		Alert alert = driver.switchTo().alert();
		
		String aler = alert.getText();
		System.out.println(aler);
		alert.accept();
		

	}

}

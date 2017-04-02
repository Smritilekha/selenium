package Source;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class HdfcDropdown {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		
		
		//String driverpath = ".\\driver\\chromedriver.exe";
		String driverpath = ".\\driver\\IEDriverServer.exe";
		//String driverpath = ".\\driver\\MicrosoftWebDriver.exe";
		
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver;
		
			/*DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			*/
			System.setProperty("webdriver.ie.driver", driverpath);
			//System.setProperty("webdriver.chrome.driver", driverpath);
			//WebDriver driver= new FirefoxDriver();
			
			driver = new InternetExplorerDriver();
		
		FileReader fre;
		
			fre = new FileReader("fileproperty.properties");
		
		Properties prop = new Properties();
		prop.load(fre);
		

		driver.navigate().to(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.id(prop.getProperty("xpath1")));
		
		Select ele1 = new Select(ele);
		//ele1.selectByIndex(0);
		ele1.selectByValue(prop.getProperty("value"));
		//ele1.selectByVisibleText(text);
		WebElement drop2 = driver.findElement(By.id(prop.getProperty("xpath2")));
		Select ele2 = new Select(drop2);
		ele2.selectByVisibleText(prop.getProperty("visibletext"));

		
	}

}

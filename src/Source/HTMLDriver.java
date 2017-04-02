package Source;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;


public class HTMLDriver {

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\smrity\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		
		System.getProperty("phantomjs.binary.path", file.getAbsolutePath());
		
		WebDriver driver = new PhantomJSDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		String title=driver.getTitle();
		System.out.println(title);
	}

}

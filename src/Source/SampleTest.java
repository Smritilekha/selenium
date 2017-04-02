package Source;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import functions.WrapperMethods;



public class SampleTest {

	public static  String timestamp()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	public  static void main(String args[]) throws IOException
	{
		WrapperMethods wm = new WrapperMethods();
		wm.launchBrowser("https://www.amazon.in/");
		System.out.println(wm.title());
		wm.enterById("twotabsearchtextbox", "refrigerator");
		wm.clickByClassName("nav-input");
		wm.takeSnap();
		wm.closeApp();		
	}

}



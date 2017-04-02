package Source;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTCCromeDriver {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\smrity\\workspace\\Selenium\\driver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		FileInputStream file= new FileInputStream(new File("C:\\Users\\smrity\\workspace\\Selenium\\data\\logindata.xlsx"));
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rowcount= sheet.getLastRowNum();
		
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow row=sheet.getRow(i);
			XSSFCell cell=row.getCell(0);
			String un=cell.getStringCellValue();
			
			XSSFCell cell1=row.getCell(1);
			String ps=cell1.getStringCellValue();
			
			XSSFCell cell2=row.getCell(2);
			String cf=cell2.getStringCellValue();   
			
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:userName']")).sendKeys(un);
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:password']")).sendKeys(ps);
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:confpasword']")).sendKeys(cf);
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:userName']")).clear();
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:password']")).clear();
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:confpasword']")).clear();
		}
	}

}

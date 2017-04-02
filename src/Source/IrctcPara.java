package Source;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IrctcPara {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		FileInputStream file = new FileInputStream(new File("C:\\Users\\smrity\\workspace\\Selenium\\data\\logindata.xlsx"));
		
		XSSFWorkbook workbook;

			workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		
		for (int i = 1; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			
			XSSFCell cell = row.getCell(0);
			String un = cell.getStringCellValue();
			
			XSSFCell cell1 = row.getCell(1);
			String pw = cell1.getStringCellValue();
			
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:userName']")).sendKeys(un);
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:password']")).sendKeys(pw);
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:userName']")).clear();
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:password']")).clear();
			
		}
		
		
		
		
		
		
	}

}

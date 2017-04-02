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
import org.openqa.selenium.support.ui.Select;

public class IrctcMultipleLogin {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		FileInputStream file = new FileInputStream(new File("C:\\Users\\smrity\\workspace\\Selenium\\data\\logindata.xlsx"));
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		
		
		for(int i=1;i<=rowcount;i++){
		XSSFRow row = sheet.getRow(i);
		
		XSSFCell cell = row.getCell(0);
		String un = cell.getStringCellValue();

		XSSFCell cell1 = row.getCell(1);
		String pw = cell1.getStringCellValue();
		
		XSSFCell cell2 = row.getCell(2);
		String cpw = cell2.getStringCellValue();
		



		
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:userName']")).sendKeys(un);
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:password']")).sendKeys(pw);
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:confpasword']")).sendKeys(cpw);
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:userName']")).clear();
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:password']")).clear();
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:confpasword']")).clear();
		

		XSSFCell cell3 = row.getCell(3);
		String sq = cell3.getStringCellValue();
		WebElement sel = driver.findElement(By.xpath(".//*[@id='userRegistrationForm:securityQ']"));

		Select ele1 = new Select(sel);
		ele1.selectByVisibleText(sq);
		
		XSSFCell cell4=row.getCell(4);
		String sa=cell4.getStringCellValue();
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:securityAnswer']")).sendKeys(sa);
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:securityAnswer']")).clear();
		
		XSSFCell cell5= row.getCell(5);
		String pf=cell5.getStringCellValue();
		
		WebElement sel2=driver.findElement(By.xpath(".//*[@id='userRegistrationForm:prelan']"));
		
		Select ele2=new Select(sel2);
		ele2.selectByVisibleText(pf);
		
		XSSFCell cell6=row.getCell(6);
		String fn=cell6.getStringCellValue();
		
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:firstName']")).sendKeys(fn);
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:firstName']")).clear();
		
		XSSFCell cell7=row.getCell(7);
		String mn=cell7.getStringCellValue();
		
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:middleName']")).sendKeys(mn);
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:middleName']")).clear();
		
		XSSFCell cell8=row.getCell(8);
		String ln=cell8.getStringCellValue();
		
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:lastName']")).sendKeys(ln);
		driver.findElement(By.xpath(".//*[@id='userRegistrationForm:lastName']")).clear();

		XSSFCell cell9=row.getCell(9);
		String gender=cell9.getStringCellValue();
		
		if(gender.equals("Male"))
		{
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:gender:0']")).click();
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:gender:1']")).click();
		}
		
		XSSFCell cell10=row.getCell(10);
		String maritalstatus=cell10.getStringCellValue();
		
		if(maritalstatus.equals("Married"))
		{
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:maritalStatus:0']")).click();
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='userRegistrationForm:maritalStatus:1']")).click();
		}
		
		XSSFCell cell11=row.getCell(11);
		String date= cell11.getStringCellValue();
		
		WebElement d=driver.findElement(By.xpath(".//*[@id='userRegistrationForm:dobDay']"));
		Select ele3=new Select(d);
		ele3.selectByValue(date);
		
		
		
		}
		
	}

}

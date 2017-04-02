package Source;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//create a blank sheet
		
		XSSFSheet sheet = workbook.createSheet("Employee Info");
		
		
		Map<String,Object[]> empinfo = new TreeMap <String, Object[]>();
		
		empinfo.put("1", new Object[] {"Empid","Emp Name", "Designation"});
		empinfo.put("2", new Object[] {"A001","Sadha","QA Engineer"});
		empinfo.put("3", new Object[] {"A002","Smriti","Mainframe dev"});
		
		
		  Set<String> keyid =  empinfo.keySet();
		  
		  int rowid = 0;
		  
		  for(String key : keyid)
		  {
			  XSSFRow row = sheet.createRow(rowid++);
			  
			  Object[] objarr = empinfo.get(key);
			  
			  int cellid = 0;
			  
			  for(Object obj : objarr)
			  {
				  XSSFCell cell = row.createCell(cellid++);
				  cell.setCellValue((String)obj);
				  
			  }
			  			  
		  }
		  
		  //write the work book in file system
		  
		  
		  
		  FileOutputStream out = new FileOutputStream(new File("Writesheet.xlsx"));
		  
		  workbook.write(out);
		  out.close();
		  
		  System.out.println("file written successfully");
		  

		  
		
		
		
	}

}

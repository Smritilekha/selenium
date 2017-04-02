package Source;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet =   workbook.createSheet("sample");
		
		XSSFRow row = sheet.createRow(0);
	
		XSSFCellStyle style = workbook.createCellStyle();
	
		//cell2.setCellStyle(Style);
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		
		
		XSSFCell cell = row.createCell(0);
		
		cell.setCellValue("SAdhasivam");
		
		cell.setCellStyle(style);
		
		XSSFCell cell2 = row.createCell(1);
		
		cell2.setCellValue("QA Engineer");

		cell2.setCellStyle(style);

		
		
		FileOutputStream out = new FileOutputStream(new File("datasheet.xlsx"));
		
		workbook.write(out);
		
		out.close();
		
		System.out.println("File written successfully");
		
		
		
	}

	private static Object getFillBackgroundXSSFColor() {
		// TODO Auto-generated method stub
		return null;
	}

}

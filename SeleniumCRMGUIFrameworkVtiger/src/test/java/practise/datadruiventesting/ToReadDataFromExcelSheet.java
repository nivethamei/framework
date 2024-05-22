package practise.datadruiventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataFromExcelSheet {

	public static void main(String[] args) throws Throwable, IOException {
		
		//get the excel sheet path location and create java object from the physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\Nivetha Shanmugam\\eclipse-workspace\\SeleniumCRMGUIFramework\\testdata\\TestScriptData.xlsx");
		
		Workbook workbook = WorkbookFactory.create(fis);
		
		//String data = workbook.getSheet("org").getRow(1).getCell(2).toString();
		//System.out.println(data);
		
	  Sheet sh = workbook.getSheet("org");
	  
	  Row row = sh.getRow(1);
	  String data = row.getCell(2).getStringCellValue();
	  
	    String num = workbook.getSheet("org").getRow(1).getCell(3).getStringCellValue();
	  System.out.println(data);
	  System.out.println(num);
		
	

	}

}

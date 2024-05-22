package practise.datadruiventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataFRomMultipleRow {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Nivetha Shanmugam\\eclipse-workspace\\SeleniumCRMGUIFramework\\testdata\\TestScriptData.xlsx");
   
		
		Workbook workbook = WorkbookFactory.create(fis);
		 Sheet sh = workbook.getSheet("Sheet1");
		 int rowcount = sh.getLastRowNum();
		
		for(int i=1; i<=rowcount;i++)
		{
		      Row row = sh.getRow(i);
		
		String column1 =row.getCell(0).toString();
		String column2= row.getCell(1).toString();
		System.out.println(column1+" "+column2);
	
		}
	}

}

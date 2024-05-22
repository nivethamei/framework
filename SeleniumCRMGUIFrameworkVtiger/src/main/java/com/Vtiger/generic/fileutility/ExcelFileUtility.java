package com.Vtiger.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String getDataFromExcelfile(String sheet,int row,int cell) throws Throwable {
		FileInputStream fis=new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getRowCount(String sheet) throws Throwable { 
		FileInputStream fis=new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheet).getLastRowNum();
		wb.close();
		return rowcount;
	}
	
	public void setBackDataToExcel(String sheet,int row,int cell,String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell);
		
	   FileOutputStream fos=new FileOutputStream("./testdata/TestScriptData.xlsx");
	   wb.write(fos);
	   wb.close();
		
	}
	
	

}

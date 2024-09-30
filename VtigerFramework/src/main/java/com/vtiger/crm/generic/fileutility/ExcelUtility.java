package com.vtiger.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./testscriptdata/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	
	public int getRowCount(String sheetName) throws Throwable, Throwable {
		
		FileInputStream fis=new FileInputStream("./testscriptdata/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		wb.close();
		return row;
	}
public int getCellCount(String sheetName) throws Throwable, Throwable {
		
		FileInputStream fis=new FileInputStream("./testscriptdata/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int cellcount = sheet.getRow(0).getLastCellNum();
		wb.close();
		return cellcount;
	}
	
	
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum,String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./testscriptdata/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
	
	FileOutputStream fos=new FileOutputStream("./testscriptdata/Testdata.xlsx");
	wb.write(fos);
	wb.close();
	}
	
	public void writeMultipleDataIntoExcel(String sheetname,Object[][] data) throws Throwable {
		FileInputStream fis=new FileInputStream("./testscriptdata/TestdataExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetname);
		for(int i=0;i<
				data.length;i++) {
			Row row = sh.createRow(i);
			for(int j=0;j<=data[i].length;j++) {
				 row.createCell(j).setCellValue(data[i][j].toString());
			}
		}
		FileOutputStream fos=new FileOutputStream("./testscriptdata/TestdataExcel.xlsx");
		wb.write(fos);
		wb.close();
		
	}


}



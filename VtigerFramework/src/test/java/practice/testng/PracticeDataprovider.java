package practice.testng;

import java.io.IOException;

import org.testng.annotations.DataProvider;


import com.vtiger.crm.generic.fileutility.ExcelUtility;

public class PracticeDataprovider  {
	
	@DataProvider
	public Object[][] getData() throws IOException, Throwable {
	
	ExcelUtility elib=new ExcelUtility();
	int rowcount = elib.getRowCount("price");
	int cellcount = elib.getCellCount("price");
			
	 Object[][] objArr = new Object[rowcount][cellcount];
	 for(int i=0;i<rowcount;i++) {
		 for(int j=0;j<cellcount;j++) {
		 
	objArr[i][0]=elib.getDataFromExcelFile("price", i+1, j);//--for brand name
	objArr[i][1]=elib.getDataFromExcelFile("price", i+1, j);//--for product name
	 }
	 }

	return objArr;
	
	
	}
}

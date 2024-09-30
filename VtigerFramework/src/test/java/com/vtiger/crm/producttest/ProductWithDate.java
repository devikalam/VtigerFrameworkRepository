package com.vtiger.crm.producttest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
import com.vtiger.crm.objectrepositoryutility.CreateNewProductPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;
import com.vtiger.crm.objectrepositoryutility.ProductInfoPage;
import com.vtiger.crm.objectrepositoryutility.ProductPage;

public class ProductWithDate extends BaseClass {
@Test
	public void productWithDate() throws Throwable, Throwable {
		
		/*FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		
		WebDriverUtility wlib=new WebDriverUtility();
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		//generate random num
             jlib.getRandomNumber();*/

		//read test script data from excel
             String productname = elib.getDataFromExcelFile("product", 1, 2)+jlib.getRandomNumber();
             

		/*WebDriver driver=null;
		if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();

		}
		else if(BROWSER.equals("firefox")){
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("chrome")){
			driver=new ChromeDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTextField().sendKeys("admin");
		lp.getPasswordTextField().sendKeys("admin");
		lp.getLoginButton().click();*/

		HomePage hp=new HomePage(driver);
		hp.clikOnProductlink();
	
		ProductPage p=new ProductPage(driver);
		p.productSymbol();
		
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.productName(productname);
		
		String sdate = jlib.getSystemDate();
		String edate = jlib.getDaysLater(60);
		
		cnp.productDate(sdate, edate);
		cnp.saveButton();
		
		//cnp.getSaveBtn().click();
		
		ProductInfoPage pip=new ProductInfoPage(driver);
		pip.verifyStartDate(sdate);
		pip.verifyEndDate(edate);
		/*String stdate = pip.getStDateVer().getText();
		String enDate = pip.getSaleEndDateVer().getText();
		//verification 
		 if(stdate.contains(sdate)) {
				System.out.println(sdate+"is created==pass");
			      }
			      else {
			    	  System.out.println(sdate+"is not created==fail");
			      }
		 
		 if(enDate.contains(edate)) {
				System.out.println(edate+"is created==pass");
			      }
			      else {
			    	  System.out.println(edate+"is not created==fail");
			      }
		*/
		
		
		
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Products\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		
		//clicking the calendar
		driver.findElement(By.id("jscal_trigger_sales_start_date")).click();
		
		
		
		
		
		String startDate = jlib.getSystemDate();
		String endDate = jlib.getDaysLater(30);
		
		driver.findElement(By.id("jscal_field_sales_start_date")).sendKeys(startDate);
		driver.findElement(By.id("jscal_field_sales_end_date")).sendKeys(endDate);
		
		driver.findElement(By.name("button")).click();
		
		//verify product name
		String name = driver.findElement(By.xpath("//tr[@style=\"height:25px\"]/td[@id=\"mouseArea_Product Name\"]")).getText();
		
      if(name.contains(productname)) {
	System.out.println(productname+"is created==pass");
      }
      else {
    	  System.out.println(productname+"is not created==fail");
      }
      
      
     
     String startdt = driver.findElement(By.id("dtlview_Sales Start Date")).getText();
     
      String enddt = driver.findElement(By.id("dtlview_Sales End Date")).getText();

if(startdt.contains(productname)) {
	System.out.println(startDate+"is created==pass");
     }
     else {
   	  System.out.println(startDate+"is not created==fail");
     }

if(enddt.contains(endDate)) {
	System.out.println(endDate+"is created==pass");
     }
     else {
   	  System.out.println(endDate+"is not created==fail");
     }
*/
	}

}

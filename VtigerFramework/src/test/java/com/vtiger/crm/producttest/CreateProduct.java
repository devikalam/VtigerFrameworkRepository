package com.vtiger.crm.producttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class CreateProduct extends BaseClass{

	@Test
	public void createproduct() throws Throwable, Throwable {
		
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
             String productname = elib.getDataFromExcelFile("product", 1, 2);
             
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
		//hp.getProductsLink().click();
		
		ProductPage p=new ProductPage(driver);
		p.productSymbol();
		//p.getCreateProductSymbol().click();
		
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.productName(productname);
		cnp.saveButton();
		//cnp.getProductNameTF().sendKeys(productname);
		//cnp.getSaveBtn().click();
		
		ProductInfoPage pi=new ProductInfoPage(driver);
		pi.verifyHeaderText(productname);
		pi.verifyProductName(productname);
		
		
		/*String header = pi.getHeaderTXT().getText();
		String name = pi.getProdNameVer().getText();
		
		  if(name.contains(productname)) {
				System.out.println(productname+"is created==pass");
			      }
			      else {
			    	  System.out.println(productname+"is not created==fail");
			      }
		
		
		  if(header.contains(productname)) {
				System.out.println(header+"is created==pass");
			      }
			      else {
			    	  System.out.println(header+"is not created==fail");
			      }*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Products\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.name("button")).click();
		
		//verify product name
		String name = driver.findElement(By.xpath("//tr[@style=\"height:25px\"]/td[@id=\"mouseArea_Product Name\"]")).getText();
		
      if(name.contains(productname)) {
	System.out.println(productname+"is created==pass");
      }
      else {
    	  System.out.println(productname+"is not created==fail");
      }*/


	}

}

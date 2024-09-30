package com.vtiger.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganizationwithPhoneNo extends BaseClass {
	@Test
	public void CreateOrganizationwithPhoneNo() throws Throwable, Throwable {

		String orgname = elib.getDataFromExcelFile("organization", 1, 2)+jlib.getRandomNumber();
		String phNo = elib.getDataFromExcelFile("organization", 1, 4);


		HomePage hp=new HomePage(driver);
		hp.getOrganizationLink().click();
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganization().click();
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrgWithPhone(orgname, phNo);
		OrganizationInfoPage oi=new OrganizationInfoPage(driver);
		oi.verifyOrgName(orgname);
		oi.verifyPhNo(phNo);		






		/*JavaUtility jlib=new JavaUtility();

		FileInputStream fis=new FileInputStream("./configAppData/data.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		//generate random num

		jlib.getRandomNumber();
		 */
		//read test script data from excel
		/*FileInputStream fis1=new FileInputStream("./testscriptdata/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("organization");
		Row row = sh.getRow(1);*/

		//String orgname = elib.getDataFromExcelFile("organization", 1, 2)+jlib.getRandomNumber();
		//String phNo = elib.getDataFromExcelFile("organization", 1, 4);
		//row.getCell(2).toString()+jlib.getRandomNumber();
		//String orgnamewithphoneno =row.getCell(4).toString();


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
		}*/

		//step1: login to app
		/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTextField().sendKeys("admin");
		lp.getPasswordTextField().sendKeys("admin");
		lp.getLoginButton().click();*/


		//cop.getOrgName().sendKeys(orgname);
		//cop.getPhoneTextField().sendKeys(orgnamewithphoneno);
		//cop.getSaveButton().click();



		/*String phoneno = driver.findElement(By.id("dtlview_Phone")).getText();
		if(phoneno.contains(orgnamewithphoneno)) {
			System.out.println(orgnamewithphoneno+" is created==pass");
		}
		else {
			System.out.println(orgnamewithphoneno+"is not created==Fail");
		}



		driver.quit();*/
	}


}



package com.vtiger.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
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
import com.vtiger.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage;

public class DeleteOrganization  extends BaseClass{
	@Test
	public void DeleteOrganization() throws Throwable, Throwable {
		
		/*JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");*/


		//generate random num

		//jlib.getRandomNumber();


		//read test script data from excel

		String orgname = elib.getDataFromExcelFile("organization",1,2);
		String searchDD = elib.getDataFromExcelFile("organization",3,2);


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

		//step1: login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTextField().sendKeys("admin");
		lp.getPasswordTextField().sendKeys("admin");
		lp.getLoginButton().click();*/

		HomePage hp=new HomePage(driver);
		hp.orgLink();
		//hp.getOrganizationLink().click();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.createOrgLink();
		
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrg(orgname);
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		
		oip.verifyHeadertxt(orgname);
		oip.verifyOrgName(orgname);
		//go back to org page and search for organization and in dynamic web table select and delete organization name
		hp.orgLink();
		op.searchOrgName(orgname, searchDD);
		//hp.getOrganizationLink().click();
		
		//op.searchDropdown(searchDD);
		//wlib.selectByText(op.getSearchDB(), searchDD);
		//op.searchOrgName(orgname);
		//op.clickOnSearchNowBtn();
		//op.getSearchTF().sendKeys(orgname);
		//wlib.selectByText(op.getSearchDB(), "Organization Name");
		//op.getSearchNow().click();
		//driver.findElement(By.xpath("//a[text()='"+orgname+"']/ancestor::tr[@class=\"lvtColData\"]/td[8]/a[text()=\"del\"]")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();

	// wlib.switchToAlertOnAccept(driver);
	op.handleAlert(driver);
	}
	
}








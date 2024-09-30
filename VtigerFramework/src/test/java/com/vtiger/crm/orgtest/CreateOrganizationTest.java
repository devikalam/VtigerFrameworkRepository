package com.vtiger.crm.orgtest;


import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
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

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void CreateOrgTest() throws IOException, Throwable {
		

		String orgname = elib.getDataFromExcelFile("organization",1,2)+jlib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.orgLink();
		OrganizationPage op=new OrganizationPage(driver);
		op.createOrgLink();
		//op.getCreateOrganization().click();
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrg(orgname);
		//cop.getOrgName().sendKeys(orgname);
		//cop.getSaveButton().click();
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);

		oip.verifyOrgName(orgname);
		oip.verifyHeadertxt(orgname);
	}
	
	@Test
	public void CreateOrganizationWithIndustryType() throws Throwable, Throwable {
		
		//read test script data from excel
				String orgname = elib.getDataFromExcelFile("organization", 1, 2)+jlib.getRandomNumber();
				String industry = elib.getDataFromExcelFile("organization", 1, 5);
				String type = elib.getDataFromExcelFile("organization", 1, 6);

				HomePage hp=new HomePage(driver);
				hp.orgLink();
				//hp.getOrganizationLink().click();
				OrganizationPage op=new OrganizationPage(driver);
				op.createOrgLink();
				CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
				//cop.createOrgwithIndustry(driver, orgname, industry, type);
				cop.createOrgwithIndustry(driver, orgname, industry, type);

				OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				oip.verifyIndustry(industry);
				oip.verifyType(type);


	}
	
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
	}
	}
	
	
	
	

		





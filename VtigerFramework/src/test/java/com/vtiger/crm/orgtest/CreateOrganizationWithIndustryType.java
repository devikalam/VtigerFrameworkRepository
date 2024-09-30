package com.vtiger.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganizationWithIndustryType extends BaseClass{
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


	}}







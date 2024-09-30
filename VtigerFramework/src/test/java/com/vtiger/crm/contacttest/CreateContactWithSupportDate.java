package com.vtiger.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
import com.vtiger.crm.objectrepositoryutility.ContactInfoPage;
import com.vtiger.crm.objectrepositoryutility.ContactPage;
import com.vtiger.crm.objectrepositoryutility.CreateNewContactPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;

public class CreateContactWithSupportDate  extends BaseClass{
	@Test
public void CreateContactWithSupportDate() throws Throwable, Throwable {
	
		 String contactname = elib.getDataFromExcelFile("organization", 6, 7)+jlib.getRandomNumber();
	        String phoneno = elib.getDataFromExcelFile("organization", 1,4)+jlib.getRandomNumber();
	        String startDate = jlib.getSystemDate();
			String endDate = jlib.getDaysLater(30);

		
			HomePage hp=new HomePage(driver);
			hp.getContactLink().click();
			ContactPage cp=new ContactPage(driver);
			cp.getCreateContactBtn().click();
	CreateNewContactPage cnp=new CreateNewContactPage(driver);
	cnp.contactOrg(contactname, phoneno);

	//cnp.getLastNameField().sendKeys(contactname);

	cnp.dateField(startDate, endDate);
	cnp.saveButton();
	//cnp.getSavebtn().click();
	ContactInfoPage cin=new ContactInfoPage(driver);
	cin.verifyContactName(contactname);
	cin.verifyStartDate(startDate);
	cin.verifyEndDate(endDate);
		
	}


	}



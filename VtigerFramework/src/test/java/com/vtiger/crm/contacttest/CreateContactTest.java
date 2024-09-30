package com.vtiger.crm.contacttest;

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
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
import com.vtiger.crm.listenerutility.ListenerImpClass;
import com.vtiger.crm.objectrepositoryutility.ContactInfoPage;
import com.vtiger.crm.objectrepositoryutility.ContactPage;
import com.vtiger.crm.objectrepositoryutility.CreateNewContactPage;
import com.vtiger.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;
import com.vtiger.crm.objectrepositoryutility.OrgSelectPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage;

public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable, Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		/*read test script data from excel*/
		String contactname = elib.getDataFromExcelFile("organization", 1, 7)+jlib.getRandomNumber();
		String phno = elib.getDataFromExcelFile("organization", 1, 4);

		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact link");
		/*Navigate To Contact Module*/
		HomePage hp=new HomePage(driver);
		hp.clickcontactLink();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to  create contact link");
		/*navigate to create contact link*/
		ContactPage cp=new ContactPage(driver);
		cp.clickOncreateContact();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to  new contact page");
		/*Create a contact*/
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createContactName(contactname);
		//cnp.saveButton();

		UtilityClassObject.getTest().log(Status.INFO ,contactname+ "==> create contact name");
		/*Verify the contact*/
		ContactInfoPage cip=new ContactInfoPage(driver);
		cip.verifyContactName(contactname);

	}

	@Test(groups = "regressionTest")
	public void CreateContactWithSupportDate() throws Throwable, Throwable {
		//read data from excel
		String contactname = elib.getDataFromExcelFile("organization", 6, 7)+jlib.getRandomNumber();
		String phoneno = elib.getDataFromExcelFile("organization", 1,4);
		String startDate = jlib.getSystemDate();
		String endDate = jlib.getDaysLater(30);

		//Navigate To Contact Module
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		///*navigate to create contact link
		ContactPage cp=new ContactPage(driver);
		cp.getCreateContactBtn().click();
		//Create Contact with phone no and give details of startDate and EndDate
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.contactOrg(contactname, phoneno);

		//cnp.getLastNameField().sendKeys(contactname);

		cnp.dateField(startDate, endDate);
		cnp.saveButton();
		//cnp.getSavebtn().click();
		///*Verify the contact with phone no
		ContactInfoPage cin=new ContactInfoPage(driver);
		cin.verifyContactName(contactname);
		cin.verifyStartDate(startDate);
		cin.verifyEndDate(endDate);

	}


}




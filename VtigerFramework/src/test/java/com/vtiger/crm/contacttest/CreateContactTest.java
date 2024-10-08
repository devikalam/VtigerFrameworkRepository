package com.vtiger.crm.contacttest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.objectrepositoryutility.Contactspage.ContactInfoPage;
import com.vtiger.crm.objectrepositoryutility.Contactspage.ContactPage;
import com.vtiger.crm.objectrepositoryutility.Contactspage.CreateNewContactPage;
import com.vtiger.crm.objectrepositoryutility.HomePage.HomePage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage.OrganizationInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage.OrganizationPage;

public class CreateContactTest extends BaseClass {
	/*@Test
	public void createContactTest() throws Throwable, Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		/*read test script data from excel*/
		/*String contactname = elib.getDataFromExcelFile("organization", 1, 7)+jlib.getRandomNumber();
		String phno = elib.getDataFromExcelFile("organization", 1, 4);

		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact link");
		/*Navigate To Contact Module*/
		/*HomePage hp=new HomePage(driver);
		hp.clickContactLink();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to  create contact link");
		/*navigate to create contact link*/
		/*ContactPage cp=new ContactPage(driver);
		cp.clickOncreateContact();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to  new contact page");
		/*Create a contact*/
		/*CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createContactName(contactname);
		//cnp.saveButton();

		UtilityClassObject.getTest().log(Status.INFO ,contactname+ "==> create contact name");
		/*Verify the contact*/
		/*ContactInfoPage cip=new ContactInfoPage(driver);
		cip.verifyContactName(contactname);

	}*/
	@Test(groups = "RegressionTest")
	public void createContactWithOrganization() throws Throwable, Throwable {
		///read test script data from excel
		String contactname = elib.getDataFromExcelFile("organization", 1, 7)+jlib.getRandomNumber();
		String switchToChildWin = elib.getDataFromExcelFile("organization", 1, 10);
		String switchToMainWin = elib.getDataFromExcelFile("organization", 1, 9);
		String phno = elib.getDataFromExcelFile("organization", 1, 4);
		String orgName = elib.getDataFromExcelFile("organization",1,2)+jlib.getRandomNumber();


		HomePage hp=new HomePage(driver);
		hp.orgLink();
		///hp.getOrganizationLink().click();
		OrganizationPage op=new OrganizationPage(driver);
		op.createOrgLink();
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrg(orgName);

		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		wlib.elementTobeVisisble(driver, oip.getHeadertext());
		hp.clickContactLink();

		ContactPage cp=new ContactPage(driver);
		cp.clickOncreateContact();

		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createContactWithOrg(driver, contactname, orgName, switchToChildWin, switchToMainWin);

		ContactInfoPage cip=new ContactInfoPage(driver);
		cip.verifyContactName(contactname);
	}

	@Test(groups = "RegressionTest")
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
		cnp.dateField(startDate, endDate);
		cnp.saveButton();
		///cnp.getSavebtn().click();
		///*Verify the contact with phone no
		ContactInfoPage cin=new ContactInfoPage(driver);
		cin.verifyContactName(contactname);
		cin.verifyStartDate(startDate);
		cin.verifyEndDate(endDate);

	}


}




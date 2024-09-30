package com.vtiger.crm.oppurtunitytest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.objectrepositoryutility.ContactInfoPage;
import com.vtiger.crm.objectrepositoryutility.ContactPage;
import com.vtiger.crm.objectrepositoryutility.ContactSelectPage;
import com.vtiger.crm.objectrepositoryutility.CreateNewContactPage;
import com.vtiger.crm.objectrepositoryutility.CreateNewOppurtunityPage;
import com.vtiger.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.OppurtunityInfoPage;
import com.vtiger.crm.objectrepositoryutility.OpputunitiesPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage;


public class CreateOppurtunityWithContact  extends BaseClass{
	@Test
	public void CreateOppurtunityWithContact() throws Throwable, Throwable {
		

		String opponame = elib.getDataFromExcelFile("Oppurtunity", 1, 3)+jlib.getRandomNumber();
		String salesdrop = elib.getDataFromExcelFile("Oppurtunity", 1, 4);
		String assign = elib.getDataFromExcelFile("Oppurtunity", 1, 5);
		String relatedToContact = elib.getDataFromExcelFile("Oppurtunity", 1, 6);
		String orgname = elib.getDataFromExcelFile("organization", 1, 2);
		String contactname = elib.getDataFromExcelFile("Oppurtunity", 1, 7);
	
		HomePage hp=new HomePage(driver);
		//create contact should be mandatory
		hp.clickcontactLink();

		ContactPage c=new ContactPage(driver);
		c.clickOncreateContact();

		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createContactName(contactname);
		cnp.saveButton();

		ContactInfoPage cip=new ContactInfoPage(driver);
		cip.verifyContactName(contactname);
		
		
		hp.clickOnOppurtunity();

		OpputunitiesPage op=new OpputunitiesPage(driver);
		op.getCreateOPPoBtn().click();
		
		CreateNewOppurtunityPage cp=new CreateNewOppurtunityPage(driver);
		cp.getOppoNameTF().sendKeys(opponame);
		cp.getRelatedToContact().click();
		cp.contactRelated(relatedToContact);
		cp.getRelatedOppoBtn().click();

		wlib.switchToNewTabOnCurrentUrl(driver, "Accounts&action");
		
		ContactSelectPage cs=new ContactSelectPage(driver);
	    cs.contactSelectPageInfo(contactname);
driver.findElement(By.xpath("//a[text()='"+contactname+"']")).click();
		wlib.switchToNewTabOnCurrentUrl(driver, "Contacts&action");
		cp.groupRadioBtn();

		cp.assignedDropDown(assign);
		
		cp.salesDropDown(salesdrop);

		cp.getSaveBTN().click();
		
		OppurtunityInfoPage oip=new OppurtunityInfoPage(driver);
		//oip.verifyOppoInfo(opponame, orgname, assign, salesdrop);
		oip.verifyRelatedContact(relatedToContact);
		
	}

}

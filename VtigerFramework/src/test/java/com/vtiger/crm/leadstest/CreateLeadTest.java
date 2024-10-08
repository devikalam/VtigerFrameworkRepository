package com.vtiger.crm.leadstest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.objectrepositoryutility.HomePage.HomePage;
import com.vtiger.crm.objectrepositoryutility.LeadPage.CreateLeadPage;
import com.vtiger.crm.objectrepositoryutility.LeadPage.LeadInfoPage;
import com.vtiger.crm.objectrepositoryutility.LeadPage.LeadsDetailsPage;

public class CreateLeadTest extends BaseClass{
	@Test(groups = "SmokeTest")
	public void createLeadTest() throws Throwable, Throwable {
       //read test script data from excel
		String leadname = elib.getDataFromExcelFile("lead", 1, 2)+jlib.getRandomNumber();
		String lastName = elib.getDataFromExcelFile("lead", 1, 4)+jlib.getRandomNumber();
		String companyName = elib.getDataFromExcelFile("lead", 1, 3)+jlib.getRandomNumber();
		String nameOfLead= elib.getDataFromExcelFile("lead", 1, 5);

		HomePage hp=new HomePage(driver);
		//hp.getQuickCreateDB().click();
		wlib.selectByValue(hp.getQuickCreateDB(), "Leads");
		CreateLeadPage cl=new CreateLeadPage(driver);
		cl.leadpagetextfields(leadname, lastName,companyName);
		//cl.getSaveButton().click();
		hp.getLeadsLink().click();
		LeadsDetailsPage ldp=new LeadsDetailsPage(driver);
		ldp.leadsDetails(lastName, nameOfLead);
		driver.findElement(By.xpath("//a[text()='"+lastName+"']")).click();
		LeadInfoPage lip=new LeadInfoPage(driver);
		lip.firstNmaeVerification(leadname);
		lip.lastNameVerification(lastName);
		lip.comapanyVerification(companyName);
		lip.leadslink();
	}
	}





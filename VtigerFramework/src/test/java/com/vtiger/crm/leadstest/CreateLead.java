package com.vtiger.crm.leadstest;

import java.io.IOException;
import java.time.Duration;

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
import com.vtiger.crm.objectrepositoryutility.CreateLeadPage;
import com.vtiger.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.CreateProjectPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LeadInfoPage;
import com.vtiger.crm.objectrepositoryutility.LeadsDetailsPage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage;
import com.vtiger.crm.objectrepositoryutility.ProjectInfoPage;

public class CreateLead extends BaseClass{
	@Test(invocationCount = 2,threadPoolSize = 2)
	public void createLead() throws Throwable, Throwable {
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





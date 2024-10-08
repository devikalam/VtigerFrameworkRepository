package com.vtiger.crm.orgtest;


import java.io.IOException;

import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.objectrepositoryutility.HomePage.HomePage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage.OrganizationInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage.OrganizationPage;

public class CreateOrganizationTest extends BaseClass {
	@Test(groups = "SmokeTest")
	public void CreateOrgTest() throws IOException, Throwable {


		String orgname = elib.getDataFromExcelFile("organization",1,2)+jlib.getRandomNumber();

		HomePage hp=new HomePage(driver);
		hp.orgLink();
		OrganizationPage op=new OrganizationPage(driver);
		op.createOrgLink();
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrg(orgname);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);

		oip.verifyOrgName(orgname);
		oip.verifyHeadertxt(orgname);
	}

	@Test(groups = "RegressionTest")
	public void CreateOrganizationWithIndustryType() throws Throwable, Throwable {

		//read test script data from excel
		String orgname = elib.getDataFromExcelFile("organization", 1, 2)+jlib.getRandomNumber();
		String industry = elib.getDataFromExcelFile("organization", 1, 5);
		String type = elib.getDataFromExcelFile("organization", 1, 6);

		HomePage hp=new HomePage(driver);
		hp.orgLink();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.createOrgLink();
		
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrgwithIndustry(driver, orgname, industry, type);

		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		oip.verifyIndustry(industry);
		oip.verifyType(type);
}

	@Test(groups = "RegressionTest")
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

/*@Test
	public void DeleteOrganization() throws Throwable, Throwable {

		String orgname = elib.getDataFromExcelFile("organization",1,2);
		String searchDD = elib.getDataFromExcelFile("organization",3,2);
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

		//driver.findElement(By.xpath("//a[text()='"+orgname+"']/ancestor::tr[@class=\"lvtColData\"]/td[8]/a[text()=\"del\"]")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();

	// wlib.switchToAlertOnAccept(driver);
	op.handleAlert(driver);
	}*/












package com.vtiger.crm.oppurtunitytest;



import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.objectrepositoryutility.HomePage.HomePage;
import com.vtiger.crm.objectrepositoryutility.OppurtunityPage.CreateNewOppurtunityPage;
import com.vtiger.crm.objectrepositoryutility.OppurtunityPage.OppurtunityInfoPage;
import com.vtiger.crm.objectrepositoryutility.OppurtunityPage.OpputunitiesPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage.OrgSelectPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage.OrganizationInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage.OrganizationPage;

public class CreateOppurtunityWithOrganization extends BaseClass {
	@Test(groups = "RegressionTest")
	public void createOppurtunity() throws Throwable, Throwable {
		
	
	String opponame = elib.getDataFromExcelFile("Oppurtunity", 1, 3)+jlib.getRandomNumber();
	String salesdrop = elib.getDataFromExcelFile("Oppurtunity", 1, 4);
	String assign = elib.getDataFromExcelFile("Oppurtunity", 1, 5);
	String orgname = elib.getDataFromExcelFile("organization", 1, 2)+jlib.getRandomNumber();
	String childwin = elib.getDataFromExcelFile("organization", 1, 10);
	String mainwin = elib.getDataFromExcelFile("organization", 1, 9);
	String enddt = jlib.getDaysLater(30);
	
	HomePage hp=new HomePage(driver);
	hp.orgLink();
	//hp.getOrganizationLink().click();
	OrganizationPage op=new OrganizationPage(driver);
	op.createOrgLink();
	CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
	cop.createOrg(orgname);

	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	wlib.elementTobeVisisble(driver, oip.getHeadertext());
	
	hp.clickOnOppurtunity();

OpputunitiesPage opp=new OpputunitiesPage(driver);
opp.getCreateOPPoBtn().click();

CreateNewOppurtunityPage cnp=new CreateNewOppurtunityPage(driver);
cnp.getOppoNameTF().sendKeys(opponame);

cnp.getRelatedOppoBtn().click();

wlib.switchToNewTabOnCurrentUrl(driver,childwin);
OrgSelectPage osp=new OrgSelectPage(driver);
osp.getSelectOrgName().sendKeys(orgname);
osp.getSearchNowBtn().click();
driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
wlib.switchToNewTabOnTitle(driver, mainwin);


cnp.groupRadioBtn();

cnp.assignedDropDown(assign);
cnp.dateField(enddt);
cnp.salesDropDown(salesdrop);

cnp.getSaveBTN().click();
OppurtunityInfoPage oipp=new OppurtunityInfoPage(driver);
oipp.verifyOppoInfo(opponame, assign, salesdrop);
//oipp.verifyOrg(driver, orgname);

/*@Test
public void CreateOppurtunityWithContact() throws Throwable, Throwable {
	

	String opponame = elib.getDataFromExcelFile("Oppurtunity", 1, 3)+jlib.getRandomNumber();
	String salesdrop = elib.getDataFromExcelFile("Oppurtunity", 1, 4);
	String assign = elib.getDataFromExcelFile("Oppurtunity", 1, 5);
	
	String relatedToContact = elib.getDataFromExcelFile("Oppurtunity", 1, 6);
	String orgname = elib.getDataFromExcelFile("organization", 1, 2);
//	String contactname = elib.getDataFromExcelFile("organization", 1, 7)+jlib.getRandomNumber();
	String switchToChildWin = elib.getDataFromExcelFile("Oppurtunity", 2, 3);
	String switchToMainWin = elib.getDataFromExcelFile("Oppurtunity", 2, 2);
	
	String contactname = elib.getDataFromExcelFile("organization", 1, 7)+jlib.getRandomNumber();
	String phno = elib.getDataFromExcelFile("organization", 1, 4);


	HomePage hp=new HomePage(driver);
	hp.clickContactLink();

	ContactPage c=new ContactPage(driver);
	c.clickOncreateContact();
	//hp.clickContactLink();
	//HomePage hp=new HomePage(driver);
	//create contact should be mandatory
	//hp.clickContactLink();
	

	//ContactPage c=new ContactPage(driver);
	//c.clickOncreateContact();

	CreateNewContactPage cnp=new CreateNewContactPage(driver);
	cnp.contact(contactname);

	//cnp.saveButton();

	ContactInfoPage cip=new ContactInfoPage(driver);
	cip.verifyContactName(contactname);
	
	
	hp.clickOnOppurtunity();

	OpputunitiesPage op=new OpputunitiesPage(driver);
	op.getCreateOPPoBtn().click();
	
	CreateNewOppurtunityPage cp=new CreateNewOppurtunityPage(driver);
	cp.oppurtunityWithContact(driver, salesdrop, contactname, assign, switchToChildWin, switchToMainWin, contactname, opponame);
	
	
}*/

















	}
}

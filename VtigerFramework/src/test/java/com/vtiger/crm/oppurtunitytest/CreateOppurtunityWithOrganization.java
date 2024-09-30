package com.vtiger.crm.oppurtunitytest;



import java.io.IOException;

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
import com.vtiger.crm.objectrepositoryutility.CreateNewOppurtunityPage;
import com.vtiger.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;
import com.vtiger.crm.objectrepositoryutility.OppurtunityInfoPage;
import com.vtiger.crm.objectrepositoryutility.OpputunitiesPage;
import com.vtiger.crm.objectrepositoryutility.OrgSelectPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage;

public class CreateOppurtunityWithOrganization extends BaseClass {
	@Test
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
oipp.verifyOrg(driver, orgname);




/*Set<String> allwin = driver.getWindowHandles();
for (String win1 : allwin) {
	driver.switchTo().window(win1);
	String title = driver.getTitle();
	System.out.println(title);
	if(title.contains("Contacts&action")) {
		break;
	}}*/
//wlib.switchToNewTabOnCurrentUrl(driver, URL);//switch back to window again
//cnp.getRadioBtn().click();
//wlib.selectByText(cnp.getAssignedToDD(), assign);
//cnp.assignedDropDown(assign);

//System.out.println("print");
//cnp.dateField(enddt);
//cnp.salesDropDown(salesdrop);

//cnp.getSaveBTN().click();
















	}
}

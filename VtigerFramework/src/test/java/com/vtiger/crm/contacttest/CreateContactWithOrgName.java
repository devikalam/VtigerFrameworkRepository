package com.vtiger.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
import com.vtiger.crm.objectrepositoryutility.ContactInfoPage;
import com.vtiger.crm.objectrepositoryutility.ContactPage;
import com.vtiger.crm.objectrepositoryutility.CreateNewContactPage;
import com.vtiger.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;
import com.vtiger.crm.objectrepositoryutility.OrgSelectPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInfoPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationPage;

public class CreateContactWithOrgName extends BaseClass{
	@Test
	public void CreateContactWithOrgName() throws Throwable, Throwable {


		//read test script data from excel
		String contactname = elib.getDataFromExcelFile("organization", 1, 7)+jlib.getRandomNumber();
		String switchToChildWin = elib.getDataFromExcelFile("organization", 1, 10);
		String switchToMainWin = elib.getDataFromExcelFile("organization", 1, 9);
		String phno = elib.getDataFromExcelFile("organization", 1, 4);
		String orgName = elib.getDataFromExcelFile("organization",1,2)+jlib.getRandomNumber();


		HomePage hp=new HomePage(driver);
		hp.orgLink();
		//hp.getOrganizationLink().click();
		OrganizationPage op=new OrganizationPage(driver);
		op.createOrgLink();
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrg(orgName);

		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		wlib.elementTobeVisisble(driver, oip.getHeadertext());
		hp.clickcontactLink();

		ContactPage cp=new ContactPage(driver);
		cp.clickOncreateContact();

		CreateNewContactPage cnp=new CreateNewContactPage(driver);

		cnp.createContactName(contactname);

		OrgSelectPage osp=new OrgSelectPage(driver);
		osp.selectOrgPageName(driver, switchToChildWin, orgName, switchToMainWin);
		//osp.switchBacktoMainWin(switchToMainWin);
		cnp.saveButton();
		ContactInfoPage cip=new ContactInfoPage(driver);
		cip.verifyContactName(contactname);






		/*JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		WebDriverUtility wlib=new WebDriverUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");*/
		//generate random num

		//jlib.getRandomNumber();

		/*WebDriver driver;
		if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();

		}
		else if(BROWSER.equals("firefox")){
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("chrome")){
			driver=new ChromeDriver();
		}else {
			driver=new ChromeDriver();
		}*/

		//step1: login to app
		/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTextField().sendKeys("admin");
		lp.getPasswordTextField().sendKeys("admin");
		lp.getLoginButton().click();*/

		/*WebDriver driver;
		if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();

		}
		else if(BROWSER.equals("firefox")){
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("chrome")){
			driver=new ChromeDriver();
		}else {
			driver=new ChromeDriver();
		}*/

		//step1: login to app
		/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTextField().sendKeys("admin");
		lp.getPasswordTextField().sendKeys("admin");
		lp.getLoginButton().click();*/










		//cnp.contactOrg(contactname, phno);
		//cnp.getCreateOrgBtn().click();


		/*Set<String> allwin = driver.getWindowHandles();
for (String win1 : allwin) {
	driver.switchTo().window(win1);
	String title = driver.getTitle();
	System.out.println(title);
	if(title.contains("Accounts&action")) {
		break;
	}

}*/
		//wlib.switchToNewTabOnCurrentUrl(driver, URL);

		/*OrgSelectPage osp=new OrgSelectPage(driver);
osp.getSelectOrgName().sendKeys(orgname);
osp.getSearchNowBtn().click();
osp.getSelOrgName().click();*/


		/*//atleast one org name should present
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		//step4: enter all details and create organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		//save it

		driver.findElement(By.name("button")).click();

		Thread.sleep(5000);


		//contacts page



		driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		//step2:click on Contact module
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();

		driver.findElement(By.name("lastname")).sendKeys(contactname);

		driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();

		//after this child window opens(switch to child window)

		wlib.switchToNewTabOnTitle(driver, "Accounts&action");




	driver.findElement(By.id("search_txt")).sendKeys(orgname);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();//------->dynamic xpath

//switch to parent window
	wlib.switchToNewTabOnTitle(driver, "Contacts&action");

		driver.findElement(By.name("button")).click();
		String headerinfo = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		String con = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();


		//verify the header msg and expected result
				if(con.contains(contactname)) {
					System.out.println(contactname+" is created==pass");
				}
				else {
					System.out.println(contactname+"is not created==Fail");
				}


				//verify the contact and expected result
				if(headerinfo.contains(orgname)) {
					System.out.println(orgname+" is created==pass");
				}
				else {
					System.out.println(orgname+"is not created==Fail");
				}


		//logout*/

		//driver.quit();
	}


}



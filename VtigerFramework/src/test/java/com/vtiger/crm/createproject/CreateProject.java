package com.vtiger.crm.createproject;

import java.io.FileInputStream;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
import com.vtiger.crm.objectrepositoryutility.CreateProjectPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;
import com.vtiger.crm.objectrepositoryutility.ProjectInfoPage;

public class CreateProject extends BaseClass{
	@Test
	public void createProject() throws Throwable, Throwable {

		//read test script data from excel
		ExcelUtility elib=new ExcelUtility();

		String projname=elib.getDataFromExcelFile("organization", 1, 8)+jlib.getRandomNumber();
		String newProject=elib.getDataFromExcelFile("organization", 6, 2);	

		HomePage hp=new HomePage(driver);
		hp.createProject(newProject);
		CreateProjectPage cp=new CreateProjectPage(driver);
		cp.getProjectName().sendKeys(projname);

		String startdt = jlib.getSystemDate();
		String enddt = jlib.getDaysLater(60);

		cp.projectDate(startdt, enddt);
		cp.getSaveButton().click();

		ProjectInfoPage pi=new ProjectInfoPage(driver);
		pi.verifyheaderinfo(projname);
		pi.verifyProjectinfo(projname);
		/*String header = pi.getProjectHeadetText().getText();
	String proName = pi.getProjectNameVerification().getText();
	if(proName.contains(projname)) {
		System.out.println(projname+" is created==pass");
	}
	else {
		System.out.println(projname+"is not created==Fail");
	}

	if(header.contains(projname)) {
		System.out.println(projname+" is created==pass");
	}
	else {
		System.out.println(projname+"is not created==Fail");
	}*/
























		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();

	WebElement quickcreate = driver.findElement(By.id("qccombo"));
	WebDriverUtility wlib=new WebDriverUtility();
	wlib.selectByText(quickcreate, "New Project");*/
		/*Select sel=new Select(quickcreate);
	sel.selectByVisibleText("New Project");*/
		/*driver.findElement(By.name("projectname")).sendKeys(projname);

	String startdate = jlib.getSystemDate();

	String enddate = jlib.getDaysLater(60);



	driver.findElement(By.name("startdate")).clear();
	driver.findElement(By.name("startdate")).sendKeys(startdate);
	driver.findElement(By.name("targetenddate")).clear();
	driver.findElement(By.name("targetenddate")).sendKeys(enddate);
	driver.findElement(By.name("button")).click();

	/*driver.findElement(By.xpath("//a[text()=\"Projects\"]")).click();
	driver.findElement(By.name("search_text")).sendKeys("tekp123");
	driver.findElement(By.xpath("//input[@value=\" Search Now \"]")).click();
	String projectname = driver.findElement(By.xpath("//a[text()=\"tekp123\"]")).getText();*/
		/*String projectname = driver.findElement(By.id("mouseArea_Project Name")).getText();
	if(projectname.contains(projname)) {
		System.out.println(projname+" is created==pass");
	}
	else {
		System.out.println(projname+"is not created==Fail");
	}
	/*Thread.sleep(5000);
	 String startdt = driver.findElement(By.xpath("//tr[@style=\"height:25px\"]/descendant::td[@class=\"dvtCellInfo\"]")).getText();

	if(startdt.contains(startdate)) {
		System.out.println(startdate+" is created==pass");
	}
	else {
		System.out.println(startdate+"is not created==Fail");
	}

	String enddt = driver.findElement(By.xpath("//tr[@style=\"height:25px\"]/descendant::/td[@class=\"dvtCellInfo\"]")).getText();
	if(enddt.contains(enddate)) {
	System.out.println(enddate+" is created==pass");
	}else {
		System.out.println(enddate+" is created==pass");
		}*/
	}

}



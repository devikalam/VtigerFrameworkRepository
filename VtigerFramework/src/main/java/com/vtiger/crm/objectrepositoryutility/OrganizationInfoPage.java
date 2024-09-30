package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility{
SoftAssert sa=new SoftAssert();
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement headertext;
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgNameCreated;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryDBVerification;
	
	@FindBy(id = "dtlview_Type")
	private WebElement typeDropDownVerification;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement verifyPhone;
	
	public WebElement getIndustryDBVerification() {
		return industryDBVerification;
	}

	public WebElement getTypeDropDownVerification() {
		return typeDropDownVerification;
	}

	public WebElement getHeadertext() {
		return headertext;
	}

	public WebElement getOrgNameCreated() {
		return orgNameCreated;
	}
	
	public void handleAlert(WebDriver driver) {
		 Alert alt = driver.switchTo().alert();
		 alt.accept();
		 
	}

	
	public void verifyOrgName(String orgname) {
		boolean flag = headertext.getText().contains(orgname);
		Assert.assertTrue(flag);
		
	}
	public void verifyHeadertxt(String orgname) {
		boolean flag = orgNameCreated.getText().contains(orgname);
		Assert.assertTrue(flag);
	
	}
	
	public void verifyIndustry(String industry) {
		boolean flag = industryDBVerification.getText().contains(industry);
		sa.assertTrue(flag);
		sa.assertAll();
		
	}
	
	public void verifyType(String type) {
		boolean flag = typeDropDownVerification.getText().contains(type);
		sa.assertTrue(flag);
		sa.assertAll();
		
	}
	public void verifyPhNo(String no) {
		boolean phno = verifyPhone.getText().contains(no);
		Assert.assertTrue(phno);
		sa.assertAll();
		
		if(verifyPhone.getText().contains(no)) {
			System.out.println(no+"is verified ==pass");
		}
		else {
			System.out.println(no+"is not verified ==fail");
			
		}
		
	}

	

	
	
	
	
	}



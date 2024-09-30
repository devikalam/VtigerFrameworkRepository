package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class ContactInfoPage extends WebDriverUtility{
	public ContactInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "dtlview_Mobile")
	private WebElement phoneNumberVer;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameVer;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDtVerification;
	
	public WebElement getStartDtVerification() {
		return startDtVerification;
	}

	public WebElement getEndDtVerification() {
		return endDtVerification;
	}
	@FindBy(id = "dtlview_Support End Date")
	private WebElement endDtVerification;
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement headercontact;
	
	public WebElement getHeaderOrg() {
		return headercontact;
	}

	public WebElement getPhoneNumberVer() {
		return phoneNumberVer;
	}

	public WebElement getLastNameVer() {
		return lastNameVer;
	}
	public void verifyContactName(String contactname) {
		if(lastNameVer.getText().contains(contactname)) {
			System.out.println(contactname+" is created==pass");
		}
		else {
			System.out.println(contactname+"is not created==Fail");
		}

	}
	public void verifyPhNo(String phno) {
		if(phoneNumberVer.getText().contains(phno)) {
			System.out.println(phno+" is created==pass");
		}
		else {
			System.out.println(phno+"is not created==Fail");
		}
	}
	
	public void verifyOrgNamewithContact(String contactname) {
		if(headercontact.getText().contains(contactname)) {
			System.out.println(contactname+" is created==pass");
		}
		else {
			System.out.println(contactname+"is not created==Fail");
		}
	}
	
public void verifyStartDate(String startDate) {
	if(startDtVerification.getText().contains(startDate)) {
		System.out.println(startDate+" is created==pass");
	}
	else {
		System.out.println(startDate+"is not created==Fail");
	}}
	
	public void verifyEndDate(String endDate) {
		if(endDtVerification.getText().contains(endDate)) {
			System.out.println(endDate+" is created==pass");
		}
		else {
			System.out.println(endDate+"is not created==Fail");
		}

	}

}

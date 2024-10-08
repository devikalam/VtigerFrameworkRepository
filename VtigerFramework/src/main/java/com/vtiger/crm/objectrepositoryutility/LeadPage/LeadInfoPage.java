package com.vtiger.crm.objectrepositoryutility.LeadPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LeadInfoPage {
	SoftAssert sa=new SoftAssert();
	WebDriver driver;
	public LeadInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	public WebElement getLeadsLink() {
		return leadsLink;
	}
	@FindBy(id = "dtlview_First Name")
		private WebElement verifyFirstName;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement verifyLastName;
	
	@FindBy(id ="dtlview_Company" )
	private WebElement verifyComany;
	
	public void leadslink() {
		leadsLink.click();
	}
	
	public WebElement getVerifyFirstName() {
		return verifyFirstName;
	}

	public WebElement getVerifyLastName() {
		return verifyLastName;
	}

	public WebElement getVerifyComany() {
		return verifyComany;
	}

	public void firstNmaeVerification(String firstname) {
		boolean flag = verifyFirstName.getText().contains(firstname);
		Assert.assertTrue(flag);
	}
	
		public void lastNameVerification(String lastname) {
		boolean flag = verifyLastName.getText().contains(lastname);
		Assert.assertTrue(flag);
		}
public void comapanyVerification(String company) {
		boolean flag = verifyComany.getText().contains(company);
	
		sa.assertTrue(flag);
		sa.assertAll();
}	
		
	}



package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {
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
		if(verifyFirstName.getText().contains(firstname)) {
			System.out.println(firstname+" is present==pass");
		}
		else {
			System.out.println(firstname+" is not present==fail");
		}}
	
		public void lastNameVerification(String lastname) {
		if(verifyLastName.getText().contains(lastname)) {
			System.out.println(lastname+" is present==pass");
		}
		else {
			System.out.println(lastname+" is not present==fail");
		}
		}
public void comapanyVerification(String company) {
		if(verifyComany.getText().contains(company)) {
			System.out.println(company+" is present==pass");
		}
		else {
			System.out.println(company+" is not present==fail");
		}
		
}	
		
	}



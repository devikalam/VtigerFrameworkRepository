package com.vtiger.crm.objectrepositoryutility.LeadPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage {
	WebDriver driver;
	public CreateLeadPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "firstname")
	private WebElement FirstNameTF;
	
	public WebElement getFirstNameTF() {
		return FirstNameTF;
	}

	public WebElement getCompanyTF() {
		return companyTF;
	}

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getPhoneNoTF() {
		return phoneNoTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	@FindBy(name = "search_field")
	private WebElement searchNameField;

	public WebElement getSearchNameField() {
		return searchNameField;
	}

	@FindBy(name = "company")
	private WebElement companyTF;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTF;
	
	@FindBy(id = "phone")
	private WebElement phoneNoTF;
	
	@FindBy(name = "button")
	private WebElement saveButton;
	
	public void leadpagetextfields(String firstname,String lastname,String companyname) {
		FirstNameTF.sendKeys(firstname);
		lastNameTF.sendKeys(lastname);
		//phoneNoTF.sendKeys(phno);
		companyTF.sendKeys(companyname);
		saveButton.click();
		}
	

	
	
	

}

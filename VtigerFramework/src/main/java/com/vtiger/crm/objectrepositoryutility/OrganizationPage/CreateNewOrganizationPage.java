package com.vtiger.crm.objectrepositoryutility.OrganizationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdit;

	public WebElement getOrgName() {
		return orgNameEdit;
	}

	@FindBy(id = "phone")
	private WebElement phoneTextField;

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	@FindBy(name = "industry")
	private WebElement industryDD;
	
	@FindBy(name = "accounttype")
	private WebElement typeDD;

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	@FindBy(name = "button")
	private WebElement saveButton;

	public void createOrg(String orgName) {
		orgNameEdit.sendKeys(orgName);
		saveButton.click();
	}

	public void createOrgwithIndustry(WebDriver driver, String OrgName, String Industry, String Type) {
		orgNameEdit.sendKeys(OrgName);
		selectByValue(industryDD, Industry);
		selectByValue(typeDD, Type);
		saveButton.click();
	}

	public void createOrgWithPhone(String orgName, String phone) {
		orgNameEdit.sendKeys(orgName);
		phoneTextField.sendKeys(phone);
		saveButton.click();
	}
}

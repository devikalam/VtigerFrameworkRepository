package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{


	public CreateNewContactPage(WebDriver driver) {
     PageFactory.initElements(driver, this);
	}

	@FindBy(id = "mobile")
	private WebElement phoneField;

	@FindBy(name = "button")
	private WebElement savebtn;

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}

	@FindBy(xpath = "//input[@name=\"account_name\"]/following-sibling::img")
	private WebElement createOrgBtn;

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getPhoneField() {
		return phoneField;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	@FindBy(name = "lastname")
	private WebElement lastNameField;

	@FindBy(name = "support_start_date")
	private WebElement startDtField;

	@FindBy(name = "support_end_date")
	private WebElement endDtField;

	public WebElement getStartDtField() {
		return startDtField;
	}

	public WebElement getEndDtField() {
		return endDtField;
	}



	public void contactOrg(String lastname,String phno) {
		lastNameField.sendKeys(lastname);
		phoneField.sendKeys(phno);
	}
	public void dateField(String startdate,String enddate) {
		startDtField.clear();
		startDtField.sendKeys(startdate);
		endDtField.clear();
		endDtField.sendKeys(enddate);
	}

	public void createContactName(String contactname) {
		lastNameField.sendKeys(contactname);
		createOrgBtn.click();
		savebtn.click();
	}

	public void saveButton() {
		savebtn.click();
	}



}

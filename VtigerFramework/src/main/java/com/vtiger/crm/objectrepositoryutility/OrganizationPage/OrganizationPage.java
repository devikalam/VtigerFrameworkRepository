package com.vtiger.crm.objectrepositoryutility.OrganizationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility {

	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrganizationLink;
	
	@FindBy(name = "search_text")
	private WebElement searchTF;
	
	@FindBy(name = "search_field")
	private WebElement searchDB;
	
	@FindBy(name = "submit")
	private WebElement searchNow;
	
	public WebElement getSearchNow() {
		return searchNow;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchDB() {
		return searchDB;
	}

	public WebElement getCreateOrganization() {
		return createOrganizationLink;
	}
	public void createOrgLink() {
		createOrganizationLink.click();
	}
	
	public void searchOrgName(String orgname,String text) {
		searchTF.sendKeys(orgname);
		selectByText(searchDB, text);
		searchNow.click();
	}

	public void handleAlert(WebDriver driver) {
		switchToAlertOnAccept(driver);
	}

}
	
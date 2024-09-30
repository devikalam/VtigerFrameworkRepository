package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class ContactSelectPage extends WebDriverUtility{
	public ContactSelectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name = "search_text")
	private WebElement searchField;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = " //a[text()=' devika']")
	private WebElement contactName;
	
	public WebElement getSearchField() {
		return searchField;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getContactName() {
		return contactName;
	}
	
	public void contactSelectPageInfo(String contact) {
		searchField.sendKeys(contact);
		searchBtn.click();
		//contactName.click();
	}

}

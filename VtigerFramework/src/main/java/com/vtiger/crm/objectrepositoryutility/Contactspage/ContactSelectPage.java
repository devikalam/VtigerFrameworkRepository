package com.vtiger.crm.objectrepositoryutility.Contactspage;

import org.openqa.selenium.By;
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
	
	public void contactSelectPageInfo(WebDriver driver,String contactname,String name,String mainwin,String childwin) {
		//switchToNewTabOnCurrentUrl(driver, childwin);
		searchField.sendKeys(contactname);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		switchToNewTabOnCurrentUrl(driver, mainwin);
		//contactName.click();
	}
}


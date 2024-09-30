package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {
	public CreateVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	@FindBy(name = "vendorname")
	private WebElement vendorName;
	
	public WebElement getVendorName() {
		return vendorName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	@FindBy(name = "button")
	private WebElement saveBtn;
	
	public void createVendor(String name) {
		vendorName.sendKeys(name);
		saveBtn.click();
	}

}

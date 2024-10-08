package com.vtiger.crm.objectrepositoryutility.VendorPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class VendorSelectPage extends WebDriverUtility{
	public VendorSelectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text")
	private WebElement searchTF;
	@FindBy(name = "search")
	private WebElement searchNowBtn;
	@FindBy(xpath = "//a[text()='janaki']")
	private WebElement vendorNameLink;
	
	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getVendorNameLink() {
		return vendorNameLink;
	}

	public void selectVendor(WebDriver driver,String partialurl,String vendorname) {
		switchToNewTabOnCurrentUrl(driver, partialurl);
		searchTF.sendKeys(vendorname);
		searchNowBtn.click();
		vendorNameLink.click();
		switchToNewTabOnCurrentUrl(driver, partialurl);
	}

}

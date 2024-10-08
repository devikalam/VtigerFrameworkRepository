package com.vtiger.crm.objectrepositoryutility.VendorPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VendorInfoPage {
	public VendorInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class=\"lvtHeaderText\"]")
	private WebElement headerText;
	
	@FindBy(id = "dtlview_Vendor Name")
	private WebElement vendorname;

	public WebElement getHeaderText() {
		return headerText;
	}

	public WebElement getVendorname() {
		return vendorname;
	}
	
	
	public void verifyVendorName(String name) {
		boolean flag = vendorname.getText().contains(name);
		Assert.assertTrue(flag);
	
	}
	
	public void verifyHeadeText(String header) {
		boolean flag = headerText.getText().contains(header);
		Assert.assertTrue(flag);
	}

}

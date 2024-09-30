package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		if(vendorname.getText().contains(name)) {
			System.out.println(name+"is created==pass");
		}
		else {
			System.out.println(name+"is not created==fail");
		}
	}
	
	public void verifyHeadeText(String header) {
		if(headerText.getText().contains(header)) {
			System.out.println(header+"is created==pass");
		}
		else {
			System.out.println(header+"is not created==fail");
		}
	}

}

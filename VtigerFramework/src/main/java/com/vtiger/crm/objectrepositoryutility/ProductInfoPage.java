package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	WebDriver driver;
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class=\"lvtHeaderText\"]")
	private WebElement headerTXT;

	@FindBy(id = "dtlview_Product Name")
	private WebElement prodNameVer;
	
	@FindBy(id = "dtlview_Sales Start Date")
	private WebElement stDateVer;
	
	@FindBy(id = "dtlview_Sales End Date")
	private WebElement saleEndDateVer;
	

	public WebElement getStDateVer() {
		return stDateVer;
	}

	public WebElement getSaleEndDateVer() {
		return saleEndDateVer;
	}

	public WebElement getProdNameVer() {
		return prodNameVer;
	}

	public WebElement getHeaderTXT() {
		return headerTXT;
	}
	public void verifyHeaderText(String productname) {
		if(headerTXT.getText().contains(productname)) {
			System.out.println(productname+"is created==pass");
		}
		else {
			System.out.println(productname+"is not created==fail");
		}
	}
	
	public void verifyProductName(String productname) {
		if(prodNameVer.getText().contains(productname)) {
			System.out.println(productname+"is created==pass");
		}
		else {
			System.out.println(productname+"is not created==fail");
		}
	}

	public void verifyStartDate(String startDate) {
		if(stDateVer.getText().contains(startDate)) {
			System.out.println(startDate+"is created==pass");
		}
		else {
			System.out.println(startDate+"is not created==fail");
		}
	}

	public void verifyEndDate(String endDate) {
		if(saleEndDateVer.getText().contains(endDate)) {
			System.out.println(endDate+"is created==pass");
		}
		else {
			System.out.println(endDate+"is not created==fail");
		}
	}

}

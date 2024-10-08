package com.vtiger.crm.objectrepositoryutility.ProductPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ProductInfoPage {
	SoftAssert sa=new SoftAssert();
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
		boolean flag = headerTXT.getText().contains(productname);
		Assert.assertTrue(flag);
	}

	public void verifyProductName(String productname) {
		boolean flag = prodNameVer.getText().contains(productname);
		Assert.assertTrue(flag);
	}

	public void verifyStartDate(String startDate) {
		boolean flag = stDateVer.getText().contains(startDate);
	    sa.assertTrue(flag);
		sa.assertAll();
	}

	public void verifyEndDate(String endDate) {
		boolean flag = saleEndDateVer.getText().contains(endDate);
		sa.assertTrue(flag);
		sa.assertAll();
	}

}

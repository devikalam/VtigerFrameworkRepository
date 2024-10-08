package com.vtiger.crm.objectrepositoryutility.VendorPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PurchaseOrderVerifyPage {
	public PurchaseOrderVerifyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//@FindBy(xpath = "//tr[@style=\"height:25px\"]/td[@id=\"mouseArea_Subject\"]")
	@FindBy(xpath = "//span[text()='computers']")
	private WebElement verifySubject;
	
	@FindBy(id = "mouseArea_Billing Address")
	private WebElement verifyBillingAddress;
	
	@FindBy(id = "dtlview_Shipping Address")
	private WebElement verifyShippingAddress;

	@FindBy(xpath = "//span[@class=\"lvtHeaderText\"]")
	private WebElement headerText;

	public WebElement getVerifySubject() {
		return verifySubject;
	}

	public WebElement getVerifyBillingAddress() {
		return verifyBillingAddress;
	}

	public WebElement getVerifyShippingAddress() {
		return verifyShippingAddress;
	}

	public WebElement getHeaderText() {
		return headerText;
	}
	
	public void verifyHeader(String subject) {
		if(headerText.getText().contains(subject)) {
			System.out.println(subject+ "is created==pass");
		}
		else {
			System.out.println(subject+ "is not created==fail");
		}
	}
	
	public void verifySubject(WebDriver driver,String subjec) {
		WebElement verSub = driver.findElement(By.xpath("//span[text()='"+subjec+"']"));
		
		boolean flag = verSub.getText().contains(subjec);
		Assert.assertTrue(flag);
	}
	
	public void verifyBillingAdd(String bilAddress) {
		boolean flag = verifyBillingAddress.getText().contains(bilAddress);
		Assert.assertTrue(flag);
	}
	
	public void verifyShippingAdd(String shipAddress) {
		boolean flag = verifyShippingAddress.getText().contains(shipAddress);
		Assert.assertTrue(flag);
	}
	
	
	
	
	
	
}

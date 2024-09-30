package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		
		if(verSub.getText().contains(subjec)) {
			System.out.println(subjec+ "is created==pass");
		}
		else {
			System.out.println(subjec+ "is not created==fail");
		}
	}
	
	public void verifyBillingAdd(String bilAddress) {
		if(verifyBillingAddress.getText().contains(bilAddress)) {
			System.out.println(bilAddress+ "is created==pass");
		}
		else {
			System.out.println(bilAddress+ "is not created==fail");
		}
	}
	
	public void verifyShippingAdd(String shipAddress) {
		if(verifyShippingAddress.getText().contains(shipAddress)) {
			System.out.println(shipAddress+ "is created==pass");
		}
		else {
			System.out.println(shipAddress+ "is not created==fail");
		}
	}
	
	
	
	
	
	
}

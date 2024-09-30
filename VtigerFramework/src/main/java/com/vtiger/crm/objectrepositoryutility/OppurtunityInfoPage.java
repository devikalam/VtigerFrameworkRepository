package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppurtunityInfoPage{
	public OppurtunityInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement verifyOppoName;
	
	@FindBy(xpath = "//a[text()='Tekp_76']")
	private WebElement verifyrelatedToOrg;
	
	@FindBy(xpath = "//a[text()=\"Team Selling\"]")
	private WebElement verifyassignedTo;
	
	@FindBy(id = "dtlview_Sales Stage")
	private WebElement verifySalesStage;
	
	public WebElement getVerifyrelatedToContact() {
		return verifyrelatedToContact;
	}
	@FindBy(xpath = "//a[text()=\" devika\"]")
	private WebElement verifyrelatedToContact;
	
	public WebElement getVerifyrelatedToOrg() {
		return verifyrelatedToOrg;
	}
	public WebElement getVerifyassignedTo() {
		return verifyassignedTo;
	}
	public WebElement getVerifySalesStage() {
		return verifySalesStage;
	}
	public WebElement getVerifyOppoName() {
		return verifyOppoName;
	}
	public void verifyOppoInfo(String opponame,String assign,String sales) {
		if(verifyOppoName.getText().contains(opponame)) {
			System.out.println(opponame+"is created==pass");
		}
		else {
			System.out.println(opponame+"is not created==pass");
			
		} 
		
		
System.out.println("--------------------");
		
		if(verifyassignedTo.getText().contains(assign)) {
			System.out.println(assign+"is created==pass");
		}
		else {
			System.out.println(assign+"is not created==pass");
			
		} 
		
		
		System.out.println("--------------------");
				
				if(verifySalesStage.getText().contains(sales)) {
					System.out.println(sales+"is created==pass");
				}
				else {
					System.out.println(sales+"is not created==pass");
					
				} 
				
	}
	
	public void verifyRelatedContact(String contacttext) {
		
		if(verifyrelatedToContact.getText().contains(contacttext)) {
			System.out.println(contacttext+"is created==pass");
		}
		else {
			System.out.println(contacttext+"is not created==pass");
			
		} 
}
	public void verifyOrg(WebDriver driver,String orgName) {
		WebElement org = driver.findElement(By.xpath("//a[text()='"+orgName+"']"));
	
		if(org.getText().contains(orgName)) {
			System.out.println(orgName+"is created==pass");
		}
		else {
			System.out.println(orgName+"is not created==pass");
			
		} 
		
	}

}

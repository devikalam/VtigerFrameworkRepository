package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpputunitiesPage {
	public OpputunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title=\"Create Opportunity...\"]")
	private WebElement createOPPoBtn;

	public WebElement getCreateOPPoBtn() {
		return createOPPoBtn;
	}
	

}

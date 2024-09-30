package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOppurtunityPage extends WebDriverUtility{
	
	public CreateNewOppurtunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "potentialname")
	private WebElement oppoNameTF;
	
	@FindBy(xpath = "//td[@class='dvtCellInfo']/input[@value='T']")
	private WebElement radioBtn;
	
	@FindBy(id = "jscal_field_closingdate")
	private WebElement closeDate;
	
	@FindBy(name = "sales_stage")
	private WebElement salesDP;
	
	@FindBy(name = "button")
	private WebElement saveBTN;
	
	@FindBy(xpath = "//select[@name=\"assigned_group_id\"]")
	private WebElement assignedToDD;
	
	public WebElement getAssignedToDD() {
		return assignedToDD;
	}



	public WebElement getSaveBTN() {
		return saveBTN;
	}



	public WebElement getSalesDP() {
		return salesDP;
	}



	public WebElement getCloseDate() {
		return closeDate;
	}



	public WebElement getRadioBtn() {
		return radioBtn;
	}
	
	

	public WebElement getOppoNameTF() {
		return oppoNameTF;
	}

	
	@FindBy(xpath = "//input[@id=\"related_to_display\"]/following-sibling::img[@alt=\"Select\"]")
	private WebElement relatedOppoBtn;
	
	@FindBy(xpath ="//select[@id='related_to_type']")
	private WebElement relatedToContact;

	public WebElement getRelatedToContact() {
		return relatedToContact;
	}



	public WebElement getRelatedOppoBtn() {
		return relatedOppoBtn;
	}
public void dateField(String enddate) {
	closeDate.clear();
	closeDate.sendKeys(enddate);
}
public void salesDropDown(String salesdp) {
	selectByValue(salesDP, salesdp);
}
	

public void groupRadioBtn() {
	radioBtn.click();
}

public void assignedDropDown(String text) {
	assignedToDD.click();
	selectByText(assignedToDD, text);
	}

public void contactRelated(String contact) {
	selectByValue(relatedToContact, contact);
}

}

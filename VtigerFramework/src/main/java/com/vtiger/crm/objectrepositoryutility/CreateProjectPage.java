package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.JavaUtility;

public class CreateProjectPage extends JavaUtility{
	WebDriver driver;
	public CreateProjectPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "projectname")
	private WebElement projectName;
	
	@FindBy(name = "startdate")
	private WebElement projectstartDt;
	
	@FindBy(name = "targetenddate")
	private WebElement projectEndDt;

@FindBy(name = "button")
private WebElement saveButton;

public WebElement getProjectName() {
	return projectName;
}

public WebElement getProjectstartDt() {
	return projectstartDt;
}

public WebElement getProjectEndDt() {
	return projectEndDt;
}

public WebElement getSaveButton() {
	return saveButton;
}


public void projectDate(String startDT,String endDT) {
	projectstartDt.clear();
	projectstartDt.sendKeys(startDT);
	projectEndDt.clear();
	projectEndDt.sendKeys(endDT);
	}


}

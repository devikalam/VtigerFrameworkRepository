package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectInfoPage {
	WebDriver driver;
	public ProjectInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement projectHeadetText;
	
	@FindBy(id = "dtlview_Project Name")
	private WebElement projectNameVerification;
	
	public WebElement getProjectHeadetText() {
		return projectHeadetText;
	}

	public WebElement getProjectNameVerification() {
		return projectNameVerification;
	}
	
	public void verifyProjectinfo(String name) {
		if(projectNameVerification.getText().contains(name)) {
			System.out.println(name+"is created==pass");
			}
		else {
			System.out.println(name+"is not created==fail");
		}
		}
	
	public void verifyheaderinfo(String header) {
		if(projectHeadetText.getText().contains(header)) {
			System.out.println(header+"is created==pass");
			}
		else {
			System.out.println(header+"is not created==fail");
		}
	}
	
	
	
	

}

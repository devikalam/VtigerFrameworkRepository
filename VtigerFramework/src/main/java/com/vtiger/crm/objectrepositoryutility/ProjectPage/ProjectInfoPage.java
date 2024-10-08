package com.vtiger.crm.objectrepositoryutility.ProjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
		boolean flag = projectNameVerification.getText().contains(name);
		Assert.assertTrue(flag);
	}
	
	public void verifyheaderinfo(String header) {
		boolean flag = projectHeadetText.getText().contains(header);
		Assert.assertTrue(flag);
			
	}
	
	
	

}

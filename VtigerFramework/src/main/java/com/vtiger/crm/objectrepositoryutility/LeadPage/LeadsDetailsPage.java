package com.vtiger.crm.objectrepositoryutility.LeadPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class LeadsDetailsPage extends WebDriverUtility{
	
	public LeadsDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text")
	private WebElement searchTF;
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchDD;
	
	@FindBy(name = "submit")
	private WebElement searchNowBtn;

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
public void leadsDetails(String lastname,String nameOfLead) {
	searchDD.click();
	selectByText(searchDD, nameOfLead);
	searchTF.sendKeys(lastname);
	searchNowBtn.click();
}

}

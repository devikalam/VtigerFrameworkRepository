package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class OrgSelectPage  extends WebDriverUtility{
	public OrgSelectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement selectOrgName;
	
	@FindBy(xpath = "//a[text()='Tekp_76']")
	private WebElement selOrgName;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchNowBtn;
	
	
	public WebElement getSelOrgName() {
		return selOrgName;
	}


	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getSelectOrgName() {
		return selectOrgName;
	}
	
public void switchTheWindow(WebDriver driver,String partialtitle) {
	//switchToNewTabOnTitle(driver, partialtitle);
}
public void selectOrgPageName(WebDriver driver,String switchToChild,String orgname,String switchToParent) {
	switchToNewTabOnTitle(driver, switchToChild);
	selectOrgName.sendKeys(orgname);
	searchNowBtn.click();
	
	 driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	//if(name.equals(orgname)) {
		//name.click();
	//}
	switchToNewTabOnTitle(driver, switchToParent);
}
	
public void switchBacktoMainWin(WebDriver driver,String switchToParent ) {
	
	switchToNewTabOnTitle(driver, switchToParent);
}
public void searchBtn() {
	searchNowBtn.click();
}
//public void clickOnOrgName(WebDriver driver,String org) {
	//driver.findElement(By.xpath("//a[text()='"+org+"']")).click();

//}

}

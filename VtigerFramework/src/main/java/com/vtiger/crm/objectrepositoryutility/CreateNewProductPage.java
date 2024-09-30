package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.JavaUtility;

public class CreateNewProductPage extends JavaUtility{
	WebDriver driver;
	public CreateNewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement productNameTF;
	
	public WebElement getProductNameTF() {
		return productNameTF;
	}
	@FindBy(name = "button")
	private WebElement saveBtn;
	
	@FindBy(id = "jscal_field_sales_start_date")
	private WebElement supportStartDate;
	
	@FindBy(id = "jscal_field_sales_end_date")
	private WebElement supportEndDate;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSupportDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}
	
	public void productDate(String stDate,String endDate) {
		supportStartDate.sendKeys(stDate);
		supportEndDate.sendKeys(endDate);
	}
	
	public void productName(String name ) {
		productNameTF.sendKeys(name);
		//saveBtn.click();
	}

	public void saveButton( ) {
		//productNameTF.sendKeys(name);
		saveBtn.click();
	}
	

	
	}



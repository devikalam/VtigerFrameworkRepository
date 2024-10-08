package com.vtiger.crm.objectrepositoryutility.ProductPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class ProductSelectPage extends WebDriverUtility{
	public ProductSelectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//input[@name='search_text']")
private WebElement searchContext;

@FindBy(name = "search")
private WebElement searchNow;

@FindBy(xpath = "//a[text()=\"iphone\"]")
private WebElement product;


public WebElement getSearchContext() {
	return searchContext;
}

public WebElement getSearchNow() {
	return searchNow;
}

public WebElement getProductName() {
	return product;
}

public void productInfo(WebDriver driver,String partialUrl,String productName) {
	switchToNewTabOnCurrentUrl(driver, partialUrl);
	searchContext.sendKeys(productName);
	searchNow.click();
	product.click();
	switchToNewTabOnCurrentUrl(driver, partialUrl);
}
}

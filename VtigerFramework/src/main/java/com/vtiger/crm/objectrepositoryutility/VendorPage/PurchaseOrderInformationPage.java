package com.vtiger.crm.objectrepositoryutility.VendorPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
import com.vtiger.crm.objectrepositoryutility.ProductPage.ProductSelectPage;

public class PurchaseOrderInformationPage extends WebDriverUtility{
	public PurchaseOrderInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "subject")
	private WebElement subject;

	@FindBy(xpath = "//textarea[@name=\"bill_street\"]")
	private WebElement billingAdress;

	@FindBy(xpath = "//textarea[@name=\"ship_street\"]")
	private WebElement shippingAddress;

	@FindBy(xpath = "//input[@onclick=\"this.form.action.value='Save';  return validateInventory('PurchaseOrder')\"]")
	private WebElement saveBtn;

	@FindBy(xpath = "//img[@title='Products']")
	private WebElement itemSearchBtn;

	@FindBy(id = "qty1")
	private WebElement quantity;

	public WebElement getShippingAddress() {
		return shippingAddress;
	}

	public WebElement getItemSearchBtn() {
		return itemSearchBtn;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getBillingAdress() {
		return billingAdress;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	@FindBy(xpath = "//input[@name=\"vendor_name\"]/following-sibling::img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement purchaseOrderSymbol;

	public WebElement getPurchaseOrderSymbol() {
		return purchaseOrderSymbol;
	}

	public WebElement getSubject() {
		return subject;
	}
	public void purchaseOrderInfo(WebDriver driver,String biladress,String shipaddress,String partialurl,String vendorname,String quantityno,String productname) {
		subject.sendKeys("laptop");
		//billingAdress.sendKeys(address);
		purchaseOrderSymbol.click();
		VendorSelectPage vs=new VendorSelectPage(driver);
		vs.selectVendor(driver, partialurl, vendorname);
		scrollingDown(driver);
		billingAdress.sendKeys(biladress);
		shippingAddress.sendKeys(shipaddress);
		itemSearchBtn.click();
		quantity.sendKeys(quantityno);
		ProductSelectPage psp=new ProductSelectPage(driver);
		psp.productInfo(driver, partialurl, productname);
		saveBtn.click();
	}

}

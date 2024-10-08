package com.vtiger.crm.objectrepositoryutility.HomePage;

import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class HomePage extends WebDriverUtility{

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;

	public WebElement getContactLink() {
		return contactLink;
	}

	@FindBy(id = "qccombo")
	private WebElement quickCreateDB;

@FindBy(linkText = "Leads")
private WebElement leadsLink;

	public WebElement getLeadsLink() {
	return leadsLink;
}


	public WebElement getQuickCreateDB() {
		return quickCreateDB;
	}

	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactLink;

	@FindBy(xpath="//a[text()=\"Products\"]")
	private WebElement  productsLink;

	public WebElement getOppurtunityLink() {
		return oppurtunityLink;
	}

	@FindBy(linkText = "Opportunities")
	private WebElement oppurtunityLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrationLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	@FindBy(xpath = "//a[text()=\"More\"]")
	private WebElement moreLink;
	
	public WebElement getPurchaseOrder() {
		return purchaseOrder;
	}

	@FindBy(linkText = "Purchase Order")
	private WebElement purchaseOrder;

	public WebElement getMoreLink() {
		return moreLink;
	}


	public WebElement getSignoutLink() {
		return signoutLink;
	}


	public WebElement getAdministrationLink() {
		return administrationLink;
	}


	public WebElement getProductsLink() {
		return productsLink;
	}


	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public void signout(WebDriver driver) {
		//Actions act=new Actions(driver);
		//act.moveToElement(administrationLink).perform();
		moveToElement(driver, administrationLink);
		signoutLink.click();
	}

	public void orgLink() {
		organizationLink.click();
	}
	public void clickContactLink() {
		contactLink.click();
	}
	public void clikOnProductlink() {
		productsLink.click();
	}
	
	public void clickOnOppurtunity() {
		oppurtunityLink.click();
	}
	
	public void vendor(String text) {
		selectByValue(quickCreateDB, text);
		
	}
	
	public void purchaseOrder(WebDriver driver) {
		HomePage hp=new HomePage(driver);
		moveToElement(driver, moreLink);
		purchaseOrder.click();
		}
	
	public void createProject(String value) {
		selectByValue(quickCreateDB, value);
	}
	





}

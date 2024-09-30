package com.vtiger.crm.vendortest;
import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.objectrepositoryutility.CreateVendorPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.PurchaseOrderInformationPage;
import com.vtiger.crm.objectrepositoryutility.PurchaseOrderPage;
import com.vtiger.crm.objectrepositoryutility.PurchaseOrderVerifyPage;
import com.vtiger.crm.objectrepositoryutility.VendorInfoPage;

public class CreateVendorTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createVendorTest() throws Throwable {
		String newVendor = elib.getDataFromExcelFile("vendor", 1, 2);
		String vendorName = elib.getDataFromExcelFile("vendor", 1, 3);
		
		HomePage hp=new HomePage(driver);
		hp.vendor(newVendor);
		CreateVendorPage cv=new CreateVendorPage(driver);
		cv.createVendor(vendorName);
		VendorInfoPage vip=new VendorInfoPage(driver);
		vip.verifyHeadeText(vendorName);
		vip.verifyVendorName(vendorName);
		}
	
	@Test(groups = "regressionTest")
	public void CreateVendorWithOrder() throws Throwable {
		String newVendor = elib.getDataFromExcelFile("vendor", 1, 2);
		String vendorName = elib.getDataFromExcelFile("vendor", 1, 3);
		String subject = elib.getDataFromExcelFile("vendor", 4, 2);
		String newWindowPartialUrl = elib.getDataFromExcelFile("vendor", 4, 3);
		String OwnWindowpartialUrl = elib.getDataFromExcelFile("vendor", 4, 4);
		String billingAddress = elib.getDataFromExcelFile("vendor", 4, 5);
		String product = elib.getDataFromExcelFile("vendor", 4, 6);
		String shippingAddress = elib.getDataFromExcelFile("vendor", 4, 7);
		String Quantity = elib.getDataFromExcelFile("vendor", 4, 8);
		
		HomePage hp=new HomePage(driver);
		hp.vendor(newVendor);
		CreateVendorPage cv=new CreateVendorPage(driver);
		cv.createVendor(vendorName);
		VendorInfoPage vip=new VendorInfoPage(driver);
		vip.verifyHeadeText(vendorName);
		vip.verifyVendorName(vendorName);
		
		hp.purchaseOrder(driver);
		PurchaseOrderPage pp=new PurchaseOrderPage(driver);
		pp.createPurchaseOrderSymbol();
		
		PurchaseOrderInformationPage poi=new PurchaseOrderInformationPage(driver);
		poi.purchaseOrderInfo(driver, billingAddress, shippingAddress, OwnWindowpartialUrl, vendorName, Quantity, product);
		PurchaseOrderVerifyPage pov=new PurchaseOrderVerifyPage(driver);
		pov.verifyHeader(subject);
		pov.verifySubject(driver, subject);
		
		pov.verifyBillingAdd(billingAddress);
		pov.verifyShippingAdd(shippingAddress);
		
	
	}

}

package com.vtiger.crm.producttest;

import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.objectrepositoryutility.HomePage.HomePage;
import com.vtiger.crm.objectrepositoryutility.ProductPage.CreateNewProductPage;
import com.vtiger.crm.objectrepositoryutility.ProductPage.ProductInfoPage;
import com.vtiger.crm.objectrepositoryutility.ProductPage.ProductPage;

public class CreateProduct extends BaseClass{

	@Test(groups = "SmokeTest")
	public void createproduct() throws Throwable, Throwable {

		String productname = elib.getDataFromExcelFile("product", 1, 2);

		HomePage hp=new HomePage(driver);
		hp.clikOnProductlink();

		ProductPage p=new ProductPage(driver);
		p.productSymbol();

		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.productName(productname);
		cnp.saveButton();

		ProductInfoPage pi=new ProductInfoPage(driver);
		pi.verifyHeaderText(productname);
		pi.verifyProductName(productname);

	}
	@Test(groups = "RegressionTest")
	public void productWithDate() throws Throwable, Throwable {
		String productname = elib.getDataFromExcelFile("product", 1, 2)+jlib.getRandomNumber();

		HomePage hp=new HomePage(driver);
		hp.clikOnProductlink();

		ProductPage p=new ProductPage(driver);
		p.productSymbol();

		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.productName(productname);

		String sdate = jlib.getSystemDate();
		String edate = jlib.getDaysLater(60);

		cnp.productDate(sdate, edate);
		cnp.saveButton();

		ProductInfoPage pip=new ProductInfoPage(driver);
		pip.verifyStartDate(sdate);
		pip.verifyEndDate(edate);
	}

}

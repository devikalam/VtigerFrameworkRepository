package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;

public class Invoice  extends BaseClass{
	@Test(retryAnalyzer = com.vtiger.crm.listenerutility.RetryAnalyzerimp.class)
	public void createInvoiceContact() {
		// WebDriver driver=new EdgeDriver();
		System.out.println("execute create contact test");
		String acttitle = driver.getTitle();
		Assert.assertEquals(acttitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		// driver.close();
	}

}

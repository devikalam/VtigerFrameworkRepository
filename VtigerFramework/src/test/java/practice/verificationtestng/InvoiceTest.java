package practice.verificationtestng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.crm.baseclassutility.BaseClass;

@Listeners(com.vtiger.crm.listenerutility.ListenerImpClass.class)
public class InvoiceTest extends BaseClass {
	@Test(retryAnalyzer = com.vtiger.crm.listenerutility.RetryAnalyzerimp.class)
	public void activateSim() {
		// WebDriver driver=new EdgeDriver();
		System.out.println("execute create contact test");
		String acttitle = driver.getTitle();
		//Assert.assertEquals(acttitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		// driver.close();
	}

	/*@Test
	public void createInvoicewithPhno() {
		// WebDriver driver=new EdgeDriver();
		System.out.println("execute create contact test");
		// String acttitle = driver.getTitle();

		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		// driver.close();
	}*/

}

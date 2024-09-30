package practiceverification.testng;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest {
	@Test
	public void homeSampleTest() {
		Reporter.log("test starts");
		Reporter.log("step1");
		Reporter.log("step2");
		Reporter.log("step3",true);
		Reporter.log("step4",true);
		Reporter.log("step5",true);
		Reporter.log("test ends");
		
	}

}

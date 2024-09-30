package practice.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Sample {
	@Test(invocationCount = 3,threadPoolSize = 3)
	public void createContact() {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.amazon.com");
		System.out.println("execute");
	}

}

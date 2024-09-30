package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductPriceTest {
	@Test(dataProvider = "getData")
	public void getProductPrice(String productname, String brandname) {
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@title=\"Search for Products, Brands and More\"]")).sendKeys(productname,Keys.ENTER);
		//-----//div[text()="Apple iPhone 15 Plus (Blue, 128 GB)"]/../../div[2]/div[1]/div[1]/div[1]----
		String price = driver.findElement(By.xpath("//div[text()=\'"+brandname+"']/../../div[2]/div[1]/div[1]/div[1]")).getText();
		System.out.println(price);
		driver.quit();//Apple iPhone 15 Plus (Blue, 128 GB)\
	}
	@DataProvider
	public Object[][] getData() {
		 Object[][] objArr = new Object[3][2];
		objArr[0][0]="iphone";
		objArr[0][1]="Apple iPhone 15 Plus (Blue, 128 GB)";
		
		objArr[1][0]="iphone";
		objArr[1][1]="Apple iPhone 15 (Blue, 128 GB)";
		
		objArr[2][0]="iphone";
		objArr[2][1]="Apple iPhone 15 (Black, 128 GB)";
		return objArr;
	}

}

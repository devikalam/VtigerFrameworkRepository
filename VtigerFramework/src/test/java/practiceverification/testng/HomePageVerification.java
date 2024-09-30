package practiceverification.testng;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerification {
	@Test
	public void homeTest(Method mtd) {
		System.out.println(mtd.getName()+"test is start");
		String expectedText = "Home page";
		WebDriver driver=new EdgeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		  String actText = driver.findElement(By.xpath("//a[contains(text(),\"Home\")]")).getText();
	Assert.assertEquals(actText, expectedText);
	driver.close();
		 System.out.println(mtd.getName()+"test is closed");
	}
	
	
	public void verifyLogoTest(Method mtd) {
		//String expectedlogo = "Vtiger";
		WebDriver driver=new EdgeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		  boolean actlogo = driver.findElement(By.xpath("//img[@title=\"vtiger-crm-logo.gif\"]")).isEnabled();
		Assert.assertTrue(actlogo);
		driver.close();
		 System.out.println(mtd.getName()+"test is closed");
	}
		
	}



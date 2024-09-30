package practice.pom.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SampleTestWithoutPom {

	public static void main(String[] args) {
	WebDriver driver=new EdgeDriver();
	driver.get("http://localhost:8888/");
	WebElement username = driver.findElement(By.name("user_name"));;
	WebElement pwd = driver.findElement(By.name("user_password"));
	WebElement login = driver.findElement(By.id("submitButton"));
	username.sendKeys("admin");
	pwd.sendKeys("admin");
	driver.navigate().refresh();
	
	username.sendKeys("admin");
	pwd.sendKeys("admin");
	
	login.click();

	}

}

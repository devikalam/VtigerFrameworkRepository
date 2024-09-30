package practice.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ProductPrice {
	public static void main(String[] args) {
		
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@title=\"Search for Products, Brands and More\"]")).sendKeys("iphone",Keys.ENTER);
	
	List<WebElement> names = driver.findElements(By.xpath("//div[@class=\"KzDlHZ\"]"));
	System.out.println(names);
	List<WebElement> price = driver.findElements(By.xpath("//div[@class=\"Nx9bqj _4b5DiR\"]"));
	for(WebElement name:names) {
		for(WebElement ele:price) {
			System.out.println(name.getText()+"  :  "+ele.getText());
			
		}
	}
	}
	}


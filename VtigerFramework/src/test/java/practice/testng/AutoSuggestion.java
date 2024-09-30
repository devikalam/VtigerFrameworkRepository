package practice.testng;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoSuggestion {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.microsoftEdge.com");
		//String title = driver.getTitle();
		WebDriver newwindow = driver.switchTo().newWindow(WindowType.WINDOW);
		newwindow.get("https://www.google.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@title=\"Search\"]")).sendKeys("flipcart");
		
		List<WebElement> alldata = driver.findElements(By.xpath("//div[@role='presentation']"));
		for (WebElement ele : alldata) {
			Thread.sleep(2000);
			String data = ele.getText();
			System.out.println(data);
			if(data.contains("flipkart customer care number")) {
				ele.click();
				break;
			}
		}
		
	}

}

package practiceverification.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class AmazonTest {
	@Test
	public void sampleScreenshot() throws Throwable {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.flipkart.com/");
	TakesScreenshot screen=(TakesScreenshot)driver;
	File srcfile = screen.getScreenshotAs(OutputType.FILE);
	
//in order to copy this file to our local system, we need a 3rd party tool i.e., common io jar
//store screenshot on local driver
	//. <- means parent directory
	FileUtils.copyFile(srcfile, new File("./Screenshot/test.png"));
	}

}

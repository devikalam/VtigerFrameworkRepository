package com.vtiger.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void getwaitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	//EXPLICIT WAIT

	public void elementTobeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void elementTobeSelected(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void elementTobeVisisble(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void textToBePresentInElement(WebDriver driver,WebElement element,String text) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public void alertIsPresent(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}



	public void switchToNewTabOnTitle(WebDriver driver,String PartialTitle) {

		Set<String> allwin = driver.getWindowHandles();
		for (String win1 : allwin) {
			driver.switchTo().window(win1);
			String title = driver.getTitle();
			System.out.println(title);
			if(title.contains(PartialTitle)) {
				break;
			}
		}}


	public void switchToNewTabOnCurrentUrl(WebDriver driver,String PartialURL) {

		Set<String> allwin = driver.getWindowHandles();
		for (String win1 : allwin) {
			driver.switchTo().window(win1);
			String title = driver.getTitle();
			System.out.println(title);
			if(title.contains(PartialURL)) {
				break;
			}
		}

	}
	//switching from child parent  to own parent
	public void switchingChildToOwnParent(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	//switching from child frame to grand parent
	public void switchingChildToGrandparent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	//switching to frame---index,visibletext,value
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);

	}


	public void switchToFrame(WebDriver driver,String nameId) {
		driver.switchTo().frame(nameId);

	}

	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);

	}

	//switch to alert
	public void switchToAlertOnAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertOnDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	//select class
	public void selectByText(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void selectByIndex(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}

	public void selectByValue(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}

	//Action Class

	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement target) {
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target);
	}
	public void clickAndhold(WebDriver driver,WebElement source,WebElement target) {
		Actions act=new Actions(driver);
		act.clickAndHold(source).release(target).perform();
	}
	public void dobleClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}

	public void dobleClickOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void rightClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	//minimize
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	//maximize
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void scrollingDown(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
	}
	//scrolling using JSE
	public void scrollingUp(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-500)");
	}
	public void scrollingToParticularElement(WebDriver driver,WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()",element);
	}
	public void scrollingToParticularHeight(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)","");
	}

	//TakeScreen shot
	public String takingScreenshot(WebDriver driver, String screenshotName) {
		String systemDate = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot screen=(TakesScreenshot)driver;
		String path = screen.getScreenshotAs(OutputType.BASE64);
		File source = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+ screenshotName+systemDate+".png");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}	
}
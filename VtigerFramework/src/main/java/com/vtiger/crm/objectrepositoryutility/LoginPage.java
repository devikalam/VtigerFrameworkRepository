package com.vtiger.crm.objectrepositoryutility;

import java.time.Duration;
/**
 * @author devis
 * contains Login Page elements & business library logics
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(name="user_name")
	private WebElement usernameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement LoginButton;
	
	
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}
	
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	
	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	
	
/**
 * @author devis
 * provide action using business methods
 * @param username
 * @param password
 */
	public void loginToApp(String username,String password) {
	
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		LoginButton.click();
	}
	
	

}

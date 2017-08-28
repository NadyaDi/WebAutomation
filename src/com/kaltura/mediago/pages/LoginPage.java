/**
 * 
 */
package com.kaltura.mediago.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author nadya.digolean
 * 
 *         This class will store all the locators and methods of login page
 *
 */
public class LoginPage {

	private WebDriver driver;
	//find all elements to perform login
	@FindBy(how = How.XPATH, using = "//a[@href='/login']")
	public WebElement login;

	@FindBy(how = How.NAME, using = "user_name")
	public WebElement userName;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "(//button[@type='submit'])[2]")
	public WebElement loginButton;
	
	@FindBy(how = How.XPATH, using = "//p[@ng-show='formVm.error']")
	public WebElement pswErrorMessage;
	
	//create methods that will run in VerifyLogin test
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openLoginPage() {
		login.click();
	}

	public void typeUserName(String name) {
		userName.clear();
		userName.sendKeys(name);
	}

	public void typePassword(String passwordValue) {
		password.clear();
		password.sendKeys(passwordValue);
	}

	public void submit() {
		loginButton.click();
	}

	public boolean isSubmitDisabled() {
		return !loginButton.isEnabled();
	}

	public boolean isIncorrectLoginDisplayed() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*System.out.println(pswErrorMessage);
		System.out.println(pswErrorMessage.isDisplayed());*/
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return pswErrorMessage.isDisplayed();// && "Oops, That e-mail / password combination is not valid".equals(pswErrorMessage.getText());
	}

}

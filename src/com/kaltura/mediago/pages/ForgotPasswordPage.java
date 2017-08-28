package com.kaltura.mediago.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author nadya.digolean
 *
 *  This class will store all the locators and methods of forgot password
 *
 */
public class ForgotPasswordPage {
	
	private WebDriver driver;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "//a[@text='Forgot password']")
	public WebElement forgotPsw;
	
	@FindBy(how = How.ID, using = "//input[@id='user_name']")
	public WebElement userName;
	
	@FindBy(how = How.XPATH, using = "(//button[@type='submit'])")
	public WebElement resetPsw;
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	

}

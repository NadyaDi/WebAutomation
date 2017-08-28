package com.kaltura.mediago.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.kaltura.mediago.pages.LoggedPage;
import com.kaltura.mediago.pages.LoginPage;

public class VerifyLogin 
{
	private static LoginPage login;
	private static LoggedPage logged;
	private static WebDriver driver;
	
	@BeforeClass
	public static void openBrowser()
	{		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nadya.digolean\\workspace\\WebAutomation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://web-preprod.ott.kaltura.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//class association - where to pull data from
		login = PageFactory.initElements(driver, LoginPage.class);
		logged = PageFactory.initElements(driver, LoggedPage.class);
     }

	@Test
	public void verifyValidLogin_2997()
	{	//verify when password is incorrect	
		login.openLoginPage();
		login.typeUserName("mus@m.com");
		assertTrue(login.isSubmitDisabled());
		login.typePassword("12345678");
		login.submit();		
		assertTrue(login.isIncorrectLoginDisplayed());
		
		//verify when user is incorrect
		login.typeUserName("mus123@m.com");
		login.submit();
		assertTrue(login.isIncorrectLoginDisplayed());
		
		//verify when password & user are correct
		login.typeUserName("mus@m.com");
		login.typePassword("123456");
		login.submit();
		assertTrue("Mus2".equals(logged.getLoggedUserName()));			
	}
	
	 @AfterClass
	 public static void closeBrowser()
	 {
		driver.quit();
	 }	
}

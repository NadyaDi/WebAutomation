package com.kaltura.mediago.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoggedPage {
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//div[@ng-if='app.session.isLoggedIn']/span")
	public WebElement loggedIn;

	public LoggedPage(WebDriver driver) {
		this.driver = driver;
	}
	//verify that user is really logged in
	public String getLoggedUserName() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@ng-if='app.session.isLoggedIn']/span"));
		return loggedIn.getText();
	}
}

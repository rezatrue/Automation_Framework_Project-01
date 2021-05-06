package com.technogearup.E2EProject;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateTitle extends Base{
	public WebDriver driver;
	
	@BeforeTest
	public void launcBrowser() throws IOException {
		driver = initializerDriver();
		//log.info("Login Page Title validation: "+"Driver is Initialized");
		driver.get(prop.getProperty("url"));
		//log.info("Login Page Title validation: "+"Successfully open URL");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		//log.info("Login Page Title validation: "+"Closed");
	}
	
	@Test
	public void validateTitle() throws IOException {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.getLogin().click();
		log.info("Login Page Title validation: "+"Opening Login page");
		driver.switchTo().frame(landingPage.getLoginFrame());
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertEquals(loginPage.pageHeading().getText(), loginPage.getheadingText());
		log.info("Login Page Title validation: "+"Title visible");
		
	}
	

	
}

package com.technogearup.E2EProject;

import static org.testng.Assert.assertTrue;

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

public class ValidateNavigationBar extends Base{
	public WebDriver driver;
	
	@BeforeTest
	public void launcBrowser() throws IOException {
		driver = initializerDriver();
		//log.info("NavigationBar Validation: "+"Driver is Initialized");
		driver.get(prop.getProperty("url"));
		//log.info("NavigationBar Validation: "+"Successfully open URL");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		//log.info("NavigationBar Validation: "+"Closed");
	}
	
	@Test(dataProvider="getData")
	public void validateNavigation(String userID, String password, String userName) throws IOException {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.getLogin().click();
		log.info("NavigationBar Validation: "+"Opening Login page");
		
		driver.switchTo().frame(landingPage.getLoginFrame());
			
		LoginPage loginPage= new LoginPage(driver);
		System.out.println("-- "+userName+" --");
		loginPage.getUserInput().sendKeys(userID);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginBtn().click();
		log.info("NavigationBar Validation: "+"Clicked in Login button");
		driver.switchTo().parentFrame();
		
		System.out.println(driver.getTitle());
		
		assertTrue(landingPage.getDropDownExpandBtn().isDisplayed());
		log.info("NavigationBar Validation: "+" Nav Dispalyed");
		
		
		
	}
	

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][3];
		data[0][0] = "lgdbmunrekiqcfvyxp";
		data[0][1] = "lgdbmunrekiqcfvyxp";
		data[0][2] = "User-01";
		return data;
	}
	
}

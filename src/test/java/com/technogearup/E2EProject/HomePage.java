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

public class HomePage extends Base{
	public WebDriver driver;
	
	@BeforeTest
	public void launcBrowser() throws IOException {
		driver = initializerDriver();
		log.info("HomePage: "+"Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("HomePage: "+"Successfully open URL");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("HomePage: "+"Closed");
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String userID, String password, String userName) throws IOException {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getLogin().click();
		log.info("HomePage: "+"Opening Login page");
		driver.switchTo().frame(landingPage.getLoginFrame());
		
		
		LoginPage loginPage= new LoginPage(driver);
		System.out.println("-- "+userName+" --");
		log.info("HomePage: "+"User Name "+ userName);
		loginPage.getUserInput().sendKeys(userID);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginBtn().click();
		
		driver.switchTo().parentFrame();
		
		System.out.println(driver.getTitle());
		log.info("HomePage: "+"Clicked in Login button");
		driver.manage().window().fullscreen();
		//driver.switchTo().activeElement().
		
		
		try {
			landingPage.getDropDownExpandBtn().click();
		} catch (StaleElementReferenceException e) {
			//e.printStackTrace();
			landingPage.getDropDownExpandBtn().getText();
			landingPage.getDropDownExpandBtn().click();
			log.info("HomePage: "+"Dropdown button clicked");
		}
		
		landingPage.loginUserMenu().sendKeys(Keys.PAGE_DOWN);
		landingPage.getLogoutBtn().click();
		log.info("HomePage: "+"Successfully logged out");
		System.out.println(driver.getTitle());
		Assert.assertEquals(landingPage.getPageTitle(), driver.getTitle());
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "lgdbmunrekiqcfvyxp";
		data[0][1] = "lgdbmunrekiqcfvyxp";
		data[0][2] = "User-01";
		
		data[1][0] = "unregistered_user";
		data[1][1] = "unregistered_user";
		data[1][2] = "User-02";
		
		return data;
	}
	
}

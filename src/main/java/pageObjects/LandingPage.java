package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	private WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	
	By loginNavBy = By.xpath("//a[contains(text(),'Log In')]");
	By iframeLoginBy = By.xpath("//iframe[contains(@src, 'login')]");
	//iframe[contains(@src, 'login_link=enabled')]
	By dropDownExpandBtnBy = By.xpath("//button[@id='USER_DROPDOWN_ID']");
	By logoutBtnBy = By.xpath("//a[child::div[contains(text(),'Log Out')]]");
	By loginUserMenuBy = By.xpath("//div[@role='menu']");
	
	String pageTitle = "reddit: the front page of the internet";
	
	
	public String getPageTitle(){
		return pageTitle;
	}
	
	public WebElement getLogin(){
		return driver.findElement(loginNavBy);
	}
	
	public WebElement getLoginFrame(){
		return driver.findElement(iframeLoginBy);
	}
	
	public WebElement getDropDownExpandBtn(){
		return driver.findElement(dropDownExpandBtnBy);
	}
	
	public WebElement loginUserMenu(){
		return driver.findElement(loginUserMenuBy);
	}
	
	
	public WebElement getLogoutBtn(){
		return driver.findElement(logoutBtnBy);
	}
	
}

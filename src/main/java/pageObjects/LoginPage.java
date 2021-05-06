package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	//input[@id="loginUsername"]
	//input[@id="loginPassword"]
	
	By userInputBy = By.xpath("//input[@id='loginUsername']");
	By passwordInputBy = By.xpath("//input[@id='loginPassword']");
	By loginBtnBy = By.xpath("//button[@type='submit']");
	By pageHeadingBy = By.xpath("//h1[contains(text(),'Login')]");
	
	String headingText = "Login";
	
	public WebElement pageHeading(){
		return driver.findElement(pageHeadingBy);
	}
	
	public String getheadingText(){
		return headingText;
	}
	
	public WebElement getUserInput(){
		return driver.findElement(userInputBy);
	}
	
	public WebElement getPasswordInput(){
		return driver.findElement(passwordInputBy);
	}
	
	public WebElement getLoginBtn(){
		return driver.findElement(loginBtnBy);
	}


}

package com.InetBanking.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name = "uid")
	WebElement txtUserName;
	
	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//*[@href='Logout.php']")
	WebElement btnLogOut;
	
	@FindBy(xpath = "//div[@class='cbb']")
	WebElement btnCloseAdd;

	
	
	
	public void clickCloseAdd() {
		btnCloseAdd.click();
	}

	public void clickLogOut() {
	JavascriptExecutor executor = (JavascriptExecutor)ldriver;
	executor.executeScript("arguments[0].click();", btnLogOut);
		
		
//		Actions a = new Actions(ldriver);
//		a.moveToElement(btnLogOut).click().build().perform();
	}
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}

	
	

}

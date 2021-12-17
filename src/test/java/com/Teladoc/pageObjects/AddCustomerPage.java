package com.Teladoc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}



	@FindBy(how = How.CSS, using = "input[name='FirstName']")
	WebElement txtFirstName;

	@FindBy(how = How.CSS, using = "input[name='LastName']")
	WebElement txtLastName;

	@FindBy(how = How.CSS, using = "input[name='Password']")
	WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using = "(//input[@name='optionsRadios'])[1]")
	WebElement radioCompany;
	
	@FindBy(how = How.XPATH, using = "//select[@name='RoleId']")
	WebElement slctRole;
	
	@FindBy(how = How.XPATH, using = "//input[@type='email']")
	WebElement txtEmail;
	
	@FindBy(how = How.XPATH, using = "//input[@name='Mobilephone']")
	WebElement txtMobile;
	
	@FindBy(how = How.CSS, using = "button[class='btn btn-success']")
	WebElement btnSubmit;

	@FindBy(how = How.CSS, using = "input[name='UserName']")
	WebElement txtUserName;

	
	public void setUserName(String value) {
		txtUserName.sendKeys(value);
	}
	

	public void clickSubmit() {
		btnSubmit.click();
	}

		
	public void setPhoneNUmber(String value) {
		txtMobile.sendKeys(value);
	}
	
	
	public void setEmail(String value) {
		txtEmail.sendKeys(value);
	}
	
	public void setRole(String value) {
		Select s = new Select(slctRole);
		s.selectByVisibleText(value);
	}


	public void setCompanyName() {
		radioCompany.click();	
		}

	
	public void setFirstName(String Name) {
		txtFirstName.sendKeys(Name);	
		}

	public void setLastName(String LastName) {
		txtLastName.sendKeys(LastName);	
		}

	public void setPassword(String Password) {
		txtPassword.sendKeys(Password);	
		}
	
	
	
	
	
	
	
	
	
}

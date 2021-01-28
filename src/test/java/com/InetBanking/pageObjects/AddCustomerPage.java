package com.InetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}


	@FindBy(how = How.XPATH, using = "//a[@href='addcustomerpage.php']")
	WebElement btnAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	WebElement txtCustomerName;
	
	@FindBy(how = How.XPATH, using = "//input[@value='f']")
	WebElement btnGender;

	@FindBy(how = How.NAME, using = "dob")
	WebElement txtDateOfBirth;

	@FindBy(how = How.CSS, using = "textarea[name ='addr']")
	WebElement txtAddress;

	@FindBy(how = How.CSS, using = "input[name='city']")
	WebElement txtCity;

	@FindBy(how = How.NAME, using = "state")
	WebElement txtState;
	
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtPinNUmber;
			
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txtTelNumber;
	
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtEmailId;

	@FindBy(how = How.CSS, using = "input[name='password']")
	WebElement txtPassword;

	@FindBy(how = How.CSS, using = "input[value='Submit']")
	WebElement btnSubmit;
	

	public void clicklSubmit() {
		btnSubmit.click();
	}

	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}

	public void setEmailId(String email) {
		txtEmailId.sendKeys(email);
	}

	public void setTelNumber(String tel) {
		txtTelNumber.sendKeys(tel);
	}
	
	public void setPinNumber(String pin) {
		txtPinNUmber.sendKeys(pin);
	}

	public void setstate(String state) {
		txtState.sendKeys(state);
	}
	
	public void setCity(String city) {
		txtCity.sendKeys(city);
	}
		

	public void setAddress(String address) {
		txtAddress.sendKeys(address);
	}
	
	public void setDOB(String month, String day, String year) {
		txtDateOfBirth.sendKeys(month);
		txtDateOfBirth.sendKeys(day);
		txtDateOfBirth.sendKeys(year);
	}

	public void setGender() {
		btnGender.click();
	}
	
	public void clickAddNewCustomer() {
		btnAddNewCustomer.click();
	}
	
	public void setCustomerName(String name) {
		txtCustomerName.sendKeys(name);
	}	
	
	
}

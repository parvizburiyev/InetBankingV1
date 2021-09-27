package com.InetBanking.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ExpediaLandingPage {
	
	WebDriver ldriver;
	
	public ExpediaLandingPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(how = How.CSS, using = "input[value='Submit']")
	WebElement btnSubmit;

	@FindBy(how = How.XPATH, using = "//button[contains(@data-stid, 'destination-menu')]")
	WebElement txtGoingTo;
	
	@FindBy(how = How.XPATH, using = "//button[text() = 'Search']")
	WebElement btnSearch;
	
	
	
	
	
	
	public void setGoingTo(String destination) {
		Actions a = new Actions(ldriver);
		a.click(txtGoingTo).sendKeys(destination).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void clickSearch() {
		btnSearch.click();
		
	}
	
	

	
	
	
	

}

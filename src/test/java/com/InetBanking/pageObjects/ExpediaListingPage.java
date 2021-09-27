package com.InetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ExpediaListingPage {
	
	WebDriver ldriver;
	
	public ExpediaListingPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='listing__link uitk-card-link']")
	WebElement lnkListing;

	@FindBy(how = How.XPATH, using = "//button[contains(@data-stid, 'destination-menu')]")
	WebElement txtGoingTo;
	
	@FindBy(how = How.XPATH, using = "//button[text() = 'Search']")
	WebElement btnSearch;
	
	String ListingXpath = "//a[@class='listing__link uitk-card-link']";
	
	@FindBy(how = How.XPATH, using = 	"(//button[@data-stid='open-date-picker'])[1]")
	WebElement btnCheckIn;
	

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'menu-months-container')]/div/h2)[1]")
	WebElement txtCheckInMonth;
	
	@FindBy(how = How.XPATH, using = "(//button[@data-stid='date-picker-paging'])[2]")
	WebElement btnNextMonth;
	
	@FindBy(how = How.XPATH, using = "//button[@data-stid='apply-date-picker']/span")
	WebElement btnDone;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@data-stid,'hotels-destination')]")
	WebElement txtDestinationVerify;
	
	@FindBy(how = How.CSS, using = "button[id='hotels-check-in-btn']")
	WebElement txtCheckInVerify;
	
	@FindBy(how = How.CSS, using = "button[id='hotels-check-out-btn']")
	WebElement txtCheckOutVerify;
	
	

	public String getCheckIn() {
		return txtCheckInVerify.getText();
	}

	public String getCheckOut() {
		return txtCheckOutVerify.getText();
	}

	public String getDestination() {
		return txtDestinationVerify.getText();
	}
	
	
	public void clickDone() {
		Actions a = new Actions(ldriver);
		a.moveToElement(btnDone).click().build().perform();
	}
	
	public void clickNextMonth() {
		btnNextMonth.click();
	}
	
	public String getCheckInMonth() {
		return txtCheckInMonth.getText();
	}
	
	public void setCheckInMonth(String month, String day) throws InterruptedException {
		while(!(month.equalsIgnoreCase(getCheckInMonth()))) {
			Thread.sleep(1000);
			clickNextMonth();
		}
			pickDay(day);
	}
	
	public void setCheckOutMonth(String month, String day) throws InterruptedException {
		while(!(month.equalsIgnoreCase(getCheckInMonth()))) {
			Thread.sleep(1000);
			clickNextMonth();
		}
			pickDay(day);
	}
	
	
	
	public void pickDay(String day) {
		ldriver.findElement(By.xpath("(//button[@data-day='"+day+"'])[1]")).click();
		
	}
	
	
	public void clickCheckIn() {
		btnCheckIn.click();
	}
	
	

	
	public String linkXpath() {
		return ListingXpath;
		
	}
	
	

	
	
	
	

}

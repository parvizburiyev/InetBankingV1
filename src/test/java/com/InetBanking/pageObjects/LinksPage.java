package com.InetBanking.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LinksPage {

	WebDriver ldriver;
	
	public LinksPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(how = How.XPATH, using = "//a[@href='https://www.expediagroup.com/']")
	WebElement lnkAbout;
	
	@FindBy(how = How.XPATH, using = 	"//ul[contains(@class, 'grid-columns-large-5')]")
	WebElement elmFooterDriver;
	

	
	public WebElement FooterDriver() {
		return elmFooterDriver;
		
	}
	
	public void clickLinkAbout() {
		lnkAbout.click();
	}
	
	public List<WebElement> ListOfFooterLinks() {
	List<WebElement> links =	elmFooterDriver.findElements(By.tagName("a"));
	return links;
		
	}
	
	
	
}

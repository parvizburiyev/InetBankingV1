package com.InetBanking.TestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.LinksPage;



public class TC_04_ExpediaLinkCount extends BaseClass{
	
	
	@Test
	public void LinkCountManually() throws InterruptedException {
		LinksPage lp = new LinksPage(driver);
		List<WebElement> links = lp.ListOfFooterLinks();
		List<String> titles = new ArrayList<String>();
		log.info("Links size " +links.size()+"");
		String homeWindow = driver.getWindowHandle();

		for(WebElement elm: links) 
		{
			String url = elm.getAttribute("href");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(url);
			titles.add(driver.getTitle());
			log.info(driver.getTitle());
			driver.close();
			driver.switchTo().window(homeWindow);
			Thread.sleep(2000);
		} 
		
		if(titles.contains("Page not fount")) {
			log.info(titles.size());
			Assert.assertFalse(false);
			log.info("Test failed");
		}else {
			log.info(titles.size());
			Assert.assertTrue(true);
			log.info("Test passed");
			
		}
		
		
		
		}
	
	
	

}

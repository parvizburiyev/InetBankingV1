package com.InetBanking.TestCases;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.LinksPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03_ExpediaLinkCountHttpConn extends BaseClass {

	
	
	@Test
	public void LinkCount() throws InterruptedException, IOException {
		
		LinksPage lp = new LinksPage(driver);
		List<WebElement> links = lp.ListOfFooterLinks();
		log.info("Links size " +links.size()+"");
//		links.get(1).click(); 
//		Thread.sleep(5000);
//		log.info(driver.getTitle());
//		driver.navigate().back();
		
		int BrokenLink = 0;
		int WorkingLink = 0;
		
		
		
		for(WebElement elm: links) {
			String url = elm.getAttribute("href");	
			URL link = new URL(url); // special url class. Once we pass url it will create a link object

			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection(); // create a connection using url object 'link'
			Thread.sleep(6000);
			
			httpConn.connect(); //establish conncetion
			int resCode = httpConn.getResponseCode();
			log.info(resCode);
			if (resCode>400) {
				log.info(url +" - " + " is broken link"); 
				BrokenLink++;
			}else {
				log.info(url +" - " + " is working link");
				WorkingLink++;
			}
		}
		
		if(BrokenLink >=1) {
			Assert.assertFalse(false);
			log.info("Test Failed");		
			}else {
				log.info("NUmber of working links are " + WorkingLink);
				Assert.assertTrue(true);
				log.info("Test Passed");		
				
			}
		

		
	}
}

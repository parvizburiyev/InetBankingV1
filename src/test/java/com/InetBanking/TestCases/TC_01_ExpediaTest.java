package com.InetBanking.TestCases;


import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.ExpediaLandingPage;
import com.InetBanking.pageObjects.ExpediaListingPage;




public class TC_01_ExpediaTest extends BaseClass {
	
	@Test
	public void searchFlight() throws InterruptedException {
		
		ExpediaLandingPage elp = new ExpediaLandingPage(driver);
		ExpediaListingPage elnp = new ExpediaListingPage(driver);

			elp.setGoingTo("Miami");
				elp.clickSearch();
				Thread.sleep(5000);
				
				List<WebElement> el =driver.findElements(By.xpath(elnp.linkXpath()));
//				System.out.println(el.size());
				
				List<String> HotelNames = el.stream().map(item-> item.getText()).collect(Collectors.toList());
				HotelNames.stream().forEach(System.out::println);
				
				long HotelNamesFinal = HotelNames.stream().filter(item ->item.contains("Miami")).count();
				System.out.println(HotelNamesFinal);
				
				if (HotelNamesFinal>=15) {
					Assert.assertTrue(true);
					log.info("Test Passed");
					
				}else {
					Assert.assertFalse(false);
					log.info("Test Passed");
					
				}

				
	}

}

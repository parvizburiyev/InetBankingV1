package com.InetBanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.InetBanking.pageObjects.ExpediaLandingPage;
import com.InetBanking.pageObjects.ExpediaListingPage;


public class TC_02_ExpediaDatePickTest extends BaseClass {

	
	@Test
	public void pickDateTest() throws InterruptedException {
		String GoingTo = "Miami";
		String CheckInMonth = "October 2021";
		String CheckOutMonth = "November 2021";
		String CheckInDate = "4";
		String CheckOutDate = "1";

		ExpediaLandingPage elp = new ExpediaLandingPage(driver);
		ExpediaListingPage elnp = new ExpediaListingPage(driver);
		SoftAssert sa = new SoftAssert();
			elp.setGoingTo(GoingTo);
				elnp.clickCheckIn();
				log.info(elnp.getCheckInMonth());
					elnp.setCheckInMonth(CheckInMonth, CheckInDate);
						elnp.setCheckOutMonth(CheckOutMonth, CheckOutDate);
						elnp.clickDone();
							elp.clickSearch();
							Thread.sleep(10000);
							
							log.info(elnp.getCheckIn());
							log.info(elnp.getCheckOut());
							
							if((elnp.getCheckIn().contains(CheckInMonth.substring(0, 3) +" "+ CheckInDate)) && (elnp.getCheckOut().contains(CheckOutMonth.substring(0, 3) +" "+ CheckOutDate))) {
								Assert.assertTrue(true);
								log.info("Test passed");
							} else {
								Assert.assertTrue(false);
								log.info("Test failed");
							}
							
						

							
							
							
							

	}
}

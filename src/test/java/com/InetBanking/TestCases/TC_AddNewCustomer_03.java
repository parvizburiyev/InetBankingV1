package com.InetBanking.TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.AddCustomerPage;
import com.InetBanking.pageObjects.LoginPage;



public class TC_AddNewCustomer_03 extends BaseClass {

	@Test
	public void AddNewCustromer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		AddCustomerPage acp = new AddCustomerPage(driver);
		lp.setUserName(userName);
			lp.setPassword(password);
				lp.clickLogin();
				Thread.sleep(1500);
		acp.clickAddNewCustomer();
		log.info("new customer button clicked");
			acp.setCustomerName("Parviz");
			log.info("Customer name set");
				acp.setGender();
				log.info("gender selected");
					acp.setDOB("10", "04", "1988");
					Thread.sleep(1500);
						acp.setAddress("470 Stratford Road");
							acp.setCity("Culver city");
		acp.setstate("Washington");
			acp.setTelNumber(RandomNumber());
				acp.setPinNumber("554455");
					acp.setEmailId(RandomString()+"@gmail.com");
						acp.setPassword("11142248");
							acp.clicklSubmit();
							Thread.sleep(1500);
							
		boolean bool = driver.getPageSource().contains("Customer Registered Successfully!!!");					
			if (bool) {
				Assert.assertTrue(true);
				log.info("Test passed");
			}else{
				captureScreen(driver, "AddCustomerPage");
				Assert.assertTrue(false);
				log.warn("Test failed");

			}
	}
	
	

	
	
	
	
}

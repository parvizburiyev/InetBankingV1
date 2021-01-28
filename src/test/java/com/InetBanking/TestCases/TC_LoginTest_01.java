package com.InetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.LoginPage;



public class TC_LoginTest_01 extends BaseClass {

	@Test
	public void LoginTest() throws IOException {
		driver.get(baseURL);
		log.info("url opened");
		LoginPage lp = new LoginPage(driver); 
		lp.setPassword(password);
		log.info("password entered");
		lp.setUserName(userName);
		log.info("UserName entered"); 
		lp.clickLogin();
		log.info("login button clicked");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			log.info("Test passed");

		}else {
			captureScreen(driver, "LoginFailed");
			Assert.assertTrue(false);
			log.info("Test failed");

		}
		
	}
}



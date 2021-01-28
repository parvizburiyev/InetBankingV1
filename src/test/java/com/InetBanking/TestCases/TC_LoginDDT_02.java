package com.InetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.InetBanking.Utilities.XLUtils;
import com.InetBanking.pageObjects.LoginPage;



public class TC_LoginDDT_02 extends BaseClass {
	
	
	@Test(dataProvider = "LoginData")
	public void LoginDDT(String user, String pwd) throws InterruptedException {
	
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		log.info("User name provided");
		lp.setPassword(pwd);
		log.info("Password provided");
		lp.clickLogin();
		log.info("Submit clicked");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='75%'");

		
		if(IsAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login failed");
		} else {
			
			Assert.assertTrue(true);
			log.info("Login passed");
			lp.clickLogOut();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean IsAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/Inetbanking/TestData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String [rownum][colcount];
			for(int i = 1; i<=rownum; i++ ) {
				for(int j = 0; j< colcount; j++) {
					logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				}
			}
		return logindata;
	}

}

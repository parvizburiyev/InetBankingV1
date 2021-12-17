package com.Teladoc.TestCases;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Teladoc.pageObjects.AddCustomerPage;
import com.Teladoc.pageObjects.LandingPage;



public class TC_01_AddValidateUser extends BaseClass
{

public	List<String> acc = Arrays.asList("Paul", "Burk","PaulBurk@gmail.com", "Password","","Admin", "wwwwww@dwwwww.com", "3473479999" );
public List<String> ActualAcc = Arrays.asList("Paul", "Burk","PaulBurk@gmail.com","Admin","wwwwww@dwwwww.com", "3473479999" );
	@Test(priority =1)
	public void StartSS() throws InterruptedException {
		int mismatch = 0;
		SoftAssert a = new SoftAssert();
		LandingPage lp = new LandingPage(driver);
		AddCustomerPage acp = new AddCustomerPage(driver);
			lp.clickAddUser();
			acp.setFirstName(acc.get(0));
			acp.setLastName("error");
			acp.setUserName(acc.get(2));
			acp.setPassword(acc.get(3));
			acp.setCompanyName();
			acp.setRole(acc.get(5));
			acp.setEmail(acc.get(6));
			acp.setPhoneNUmber(acc.get(7));
			acp.clickSubmit();
			Thread.sleep(2000);
			
			log.info(lp.VerifyFirstRecord());
				
			List<String> ExpectedAcc = lp.VerifyFirstRecord();
			
			for(int i = 0; i<ActualAcc.size(); i++) {
					if(ExpectedAcc.contains(ActualAcc.get(i))) {
						log.info(ActualAcc.get(i) +" record exist in table");
					} else {
						log.info(ActualAcc.get(i) +" record do not exist in table");
						mismatch++;
					}
			}
			
			if (mismatch ==0) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
				
			}
	}
	
	@Test(priority=2)
	public void DeleteRecord() throws InterruptedException {
		LandingPage lp = new LandingPage(driver);
		Thread.sleep(3000);
		List <WebElement> rows = lp.AllRows();
			String RowValues = rows.get(0).getText();
			if (RowValues.contains("Paul")) {
				lp.clickDelete(1);
				log.info("record deleted");
			}
		

	
}

	

}

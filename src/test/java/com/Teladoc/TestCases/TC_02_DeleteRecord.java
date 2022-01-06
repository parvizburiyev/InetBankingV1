package com.Teladoc.TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Teladoc.pageObjects.LandingPage;

public class TC_02_DeleteRecord extends BaseClass{

	@Test(enabled = true)
	public void DeleteRecord() throws InterruptedException {
		String RecordToDelete = "Blue";
		LandingPage lp = new LandingPage(driver);
		Thread.sleep(3000);
		List <WebElement> rows = lp.AllRows();
		for(int i = 0; i< rows.size(); i++) {
			String RowValues = rows.get(i).getText();
			if (RowValues.contains(RecordToDelete)) {
				Thread.sleep(500);
				lp.clickDelete(i+1);
				log.info("record deleted");
				break;
			}
		}
		if(checkIfRecordDeleted(RecordToDelete)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		

	
}

	
	
		public boolean checkIfRecordDeleted(String S) {
			LandingPage lp = new LandingPage(driver);
			List <WebElement> rows = lp.AllRows();
			for(int i = 0; i< rows.size(); i++) {
					if(!lp.checkEachCell(rows.get(i).getText(), S)) {
						return false;
					}
			}
			
			return true;
	
}
		
		
	

}

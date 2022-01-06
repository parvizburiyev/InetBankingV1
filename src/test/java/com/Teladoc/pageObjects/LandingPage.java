package com.Teladoc.pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver ldriver;
	
	public LandingPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(how = How.CSS, using = "*[class ='btn btn-link pull-right']")
	WebElement btnAddUser;

	@FindBy(how = How.XPATH, using = "//button[contains(@data-stid, 'destination-menu')]")
	WebElement txtGoingTo;
	
	@FindBy(how = How.XPATH, using = "//button[text() = 'Search']")
	WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using = "//button[text() = 'OK']")
	WebElement btnOk;
	
	

	public void clickOK() {
		btnOk.click();
	}
	
	
	
	public String tableSize() {
		return "//tr[contains(@class, 'smart-table-data-row')]";
	}
	
	public String FirstCellXpath(String s) {
		return "//tr[@class='smart-table-data-row ng-scope'][1]/td["+s+"]";
	}
	
	public String RawXpath(int col, int row) {
		return "//tr[@class='smart-table-data-row ng-scope']["+row +"]/td["+col+"]";
	}
	
	
//	public boolean FindNovak(String str) {
//		
//		List<WebElement> table = ldriver.findElements(By.xpath(tableSize()));
//		System.out.println(table.size()); 
//		for (int i=1; i<=table.size();i++) {
//			
//			if(checkFirstThreeCell(i, str)) {
//				return true;
//			}
//			
//		}
//		return false;
//	}
	
	public List<WebElement> AllRows() {
		List <WebElement> rows = ldriver.findElements(By.xpath("//tr[contains(@class, 'smart-table-data-row')]"));
			
			return rows;
	}
	
	public boolean checkEachCell(String str, String word) {

		String strArray[] = str.split(" ");
			for(int i = 0; i<3; i++) {
				if(strArray[i].equalsIgnoreCase(word)) {
					return false;
				}
			}
		
			return true;
		}
			
		
		
		
	
	
	
	public  void clickDelete(int row) throws InterruptedException {
		 Actions a = new Actions(ldriver);
		 a.moveToElement(ldriver.findElement(By.xpath("(//button[@ng-click='delUser()'])["+row+"]"))).click().build().perform();;
		 clickOK();
	}
	
	
	
	public ArrayList<String> VerifyFirstRecord() throws InterruptedException {
		ArrayList<String> list=new ArrayList<String>();
		for(int i = 0; i<=7;i++) {
			list.add(ldriver.findElement(By.xpath(FirstCellXpath(Integer.toString(i+1)))).getText());
			Thread.sleep(300);
		}
		
	list.removeAll(Collections.singleton(""));
		
		return list;
		
	}
	
	public ArrayList<String> VerifyFirstLastUsernameRecord(String First,String Last, String username) throws InterruptedException {
		ArrayList<String> list=new ArrayList<String>();
		for(int i = 0; i<=3;i++) {
			
			list.add(ldriver.findElement(By.xpath(FirstCellXpath(Integer.toString(i+1)))).getText());
			Thread.sleep(300);
		}
		
		return list;
		
	}
	


	
	
	

	public void clickAddUser() {
		btnAddUser.click();
		
	}
	
	

	
	
	
	

}

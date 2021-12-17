package com.Teladoc.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Teladoc.Utilities.ReadConfig;



public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL =  readconfig.GetApplicationUrl(); 
	public String userName =  readconfig.getUserName(); 
	public String password =   readconfig.getPassword();
	public static WebDriver driver;
	public static Logger log;
	
	@Parameters("browser")
	@BeforeClass
	public void SetUp(String br) {

		log = Logger.getLogger("teladoc");
		PropertyConfigurator.configure("log4j.properties");

		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChropath());
			driver = new ChromeDriver();
		}else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		
		}else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIepath());//.getFirefoxpath());
			driver = new InternetExplorerDriver();
			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL); 
		driver.manage().window().maximize();
	}
		
		
	
	@AfterClass(enabled=false)
	public void TearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screnshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String RandomString() {
		String str = RandomStringUtils.randomAlphabetic(7);
	return str;
	}
	public String RandomNumber() {
		String str = RandomStringUtils.randomNumeric(9, 10);
	return str;
	}
	
	
}

package com.automate.withme.testNgUtils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;




public class testngUtils extends AbstractTestNGCucumberTests {
	
	//public  WebDriver driver;
	public static Scenario sc ;	
	
	  @Parameters({"Browser"})
	  @BeforeTest
	  public void beforeTest(String browser) throws Exception {
//		  if(browser.equalsIgnoreCase("chrome")){
//			//Driver exe config
//				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\Tutorials\\Drivers\\chromedriver.exe");
//				//Instantiation the WebDriver Instance
//				 driver = new ChromeDriver();
//		  }
//		  else if(browser.equalsIgnoreCase("IE")){
//			  System.setProperty("webdriver.ie.driver", "C:\\Users\\Dell\\Desktop\\Tutorials\\Drivers\\IEDriverServer.exe");
//				 driver= new InternetExplorerDriver();
//		  }
//		  else if(browser.equalsIgnoreCase("FF")){
//			  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Desktop\\Tutorials\\Drivers\\geckodriver.exe");
//				 driver= new FirefoxDriver();
//		  }
		  
		  if(browser.equalsIgnoreCase("chrome")){
		  BrowserFactory browserFactory = BrowserFactory.getInstance();
			browserFactory.setDriver("chrome");
		  }
		  else if(browser.equalsIgnoreCase("IE")){
			  BrowserFactory browserFactory = BrowserFactory.getInstance();
				browserFactory.setDriver("IE");
		  }
		  else if(browser.equalsIgnoreCase("FF")){
			  BrowserFactory browserFactory = BrowserFactory.getInstance();
				browserFactory.setDriver("FF");
		  }
	  }

	
	  @AfterTest
	  public void afterTest() {
		 
		BrowserFactory browserFactory = BrowserFactory.getInstance();
		browserFactory.getDriver().close();
		browserFactory.getDriver().quit();
		  
//		  driver.close();
//		  driver.quit();
//		  driver=null;
	  }
	  
	  @Parameters({"Sender","receiver","password"})
	  @AfterSuite 
	  public void aftersuite(String sender, String receiver, String password){
		  System.out.println("Send mail from "+sender+" reciever "+receiver+" password "+password);
		  /**
		   * 
		   * Replcae your data accordingly
		   * 
		   * 
		   */
		//  Mailutils.Sendmail(sender, password, receiver);
		  
	  }
}

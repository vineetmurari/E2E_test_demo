package com.automate.withme.testNgUtils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	private static BrowserFactory instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	private BrowserFactory() {

	}

	public static BrowserFactory getInstance() {
		if (instance == null) {
			instance = new BrowserFactory();
		}
		return instance;
	}

	public final void setDriver(String browser) throws Exception {
		DesiredCapabilities caps = null;
		if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\Tutorials\\Drivers\\chromedriver.exe");
			webDriver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("IE")){
			 System.setProperty("webdriver.ie.driver", "C:\\Users\\Dell\\Desktop\\Tutorials\\Drivers\\IEDriverServer.exe");
			 webDriver.set(new InternetExplorerDriver());
		}
		else if(browser.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Desktop\\Tutorials\\Drivers\\geckodriver.exe");
			 webDriver.set(new FirefoxDriver());
		}
	}

	public WebDriver getDriver() {
		return webDriver.get();
	}
	}


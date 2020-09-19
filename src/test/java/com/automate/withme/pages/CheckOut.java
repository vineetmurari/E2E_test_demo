package com.automate.withme.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.utils.DataBaseUtils;
import com.util.utils.ExcelSheetUtils;
import com.util.utils.Utilities;

import io.cucumber.java.Scenario;

public class CheckOut {

	WebDriver driver;
	Scenario sc;
	
	@FindBy(xpath ="//h2[text()='Almost there!!']")
	private WebElement heading;
	
	@FindBy(id ="fname")
	private WebElement username;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id ="adr")
	private WebElement addr;
	
	@FindBy(id ="zip")
	private WebElement zip;
	
	@FindBy(id ="state")
	private WebElement state;
	
	@FindBy(id ="city")
	private WebElement city;
	
	@FindBy(name="sameadr")
	private WebElement checkbox;
	
	@FindBy(xpath="//input[@value ='Continue to checkout']")
	private WebElement Contd_button;
	
	
	public CheckOut(WebDriver driver , Scenario sc){
		this.driver = driver;
		this.sc=sc;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void check_if_checkoutpage(){
		try{
			if(heading.isDisplayed()){
				System.out.println("Page Heading is displayed");
				sc.write("PASS: Page Heading is displayed");
				byte[] screenshot =utils.Take_A_ScreenShot(driver);
				sc.embed(screenshot, "image/png", sc.getName());
			}
		}
		catch(Exception e){
			System.out.println("Exception Page Heading is displayed");
			byte[] screenshot =utils.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png", sc.getName());
		}
	}
	
	public void Fill_billing_details(){
		
		//Read the Value from Excel Sheet 
		List<String> test_value_list = ExcelSheetUtils.Read();
		//get the desired test value from list to a variable
		String test_value = test_value_list.get(1);
		//Take down db data into a list and pass the test value
		List<String> DB_data = DataBaseUtils.Get_Billing_data(test_value);
		
		utils.Input_Text(driver, username, DB_data.get(0));
		utils.Input_Text(driver, email, DB_data.get(1));
		utils.Input_Text(driver, addr, DB_data.get(2));
		utils.Input_Text(driver, city, DB_data.get(3));
		utils.Input_Text(driver, zip, DB_data.get(4));
		utils.Input_Text(driver, state, DB_data.get(5));
		if(DB_data.get(6).equalsIgnoreCase("Y")){
		utils.check_that_if_not_yet(driver, checkbox);
		}
		else{
		utils.uncheck_that_if_checked(driver, checkbox);
		}
	}
	
	public void checkout_click(){
		utils.Button_Link_Click(driver, Contd_button);
	}
	
}

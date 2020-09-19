package com.automate.withme.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.utils.Utilities;

import io.cucumber.java.Scenario;

public class OrderPlaced {

	WebDriver driver;
	Scenario sc;
	
	@FindBy(xpath ="//h2[text()='Order Details']")
	private WebElement Order_details;
	
	@FindBy(xpath ="//div[1]//p[1]")
	private WebElement success_message;
	
	@FindBy(id ="email")
	private WebElement Email;
	
	@FindBy(id ="Address")
	private WebElement Address;
	
	@FindBy(id ="TotalItems")
	private WebElement Tot_items;
	
	@FindBy(id ="cost")
	private WebElement tot_price;
	
	@FindBy(xpath ="//button[text()=' Logout']")
	private WebElement Logout;
	
	
	public OrderPlaced(WebDriver driver,Scenario sc){
		this.driver=driver;
		this.sc=sc;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void Check_if_Heading_is_displayed(){
		try{
			if(Order_details.isDisplayed()){
				System.out.println("Page Heading is displayed");
				sc.write("PASS: Page Heading is displayed");
			}
		}
		catch(Exception e){
			System.out.println("Exception Page Heading is displayed");
			byte[] screenshot =utils.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png", sc.getName());
		}
	}
	
	public void verify_success_message(){
		try{
			if(success_message.isDisplayed()){
				System.out.println("PASS: The success message is displayed");
				sc.write("The success message is displayed");
			}
			Assert.assertTrue(success_message.getText().equalsIgnoreCase("Success! your order is placed."));
		}
		catch(Exception e){
			System.out.println("Exception Page Success Message is displayed");
			byte[] screenshot =utils.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png", sc.getName());
		}
	}
	
	public void  verify_if_details_are_displayed(){
		try{
			if(Email.isDisplayed()){
				System.out.println("PASS: The Email is displayed");
				sc.write("The Email is displayed");
			}
		}
		catch(Exception e){
			System.out.println("Exception Page Email is displayed");
			byte[] screenshot =utils.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png", sc.getName());
		}
		
		try{
			if(Address.isDisplayed()){
				System.out.println("PASS: The Address is displayed");
				sc.write("The Address is displayed");
			}
		}
		catch(Exception e){
			System.out.println("Exception Page Address is displayed");
			byte[] screenshot =utils.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png", sc.getName());
		}
		
		try{
			if(Tot_items.isDisplayed()){
				System.out.println("PASS: The Total items is displayed");
				sc.write("The  Total items is displayed");
			}
		}
		catch(Exception e){
			System.out.println("Exception Page  Total items is displayed");
			byte[] screenshot =utils.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png", sc.getName());
		}
		
		try{
			if(tot_price.isDisplayed()){
				System.out.println("PASS: The total price is displayed");
				sc.write("The total price is displayed");
			}
		}
		catch(Exception e){
			System.out.println("Exception Page total price is displayed");
			byte[] screenshot =utils.Take_A_ScreenShot(driver);
			sc.embed(screenshot, "image/png", sc.getName());
		}
	}
	
	public void click_On_Logout(){
		utils.Button_Link_Click(driver, Logout);
	}
}

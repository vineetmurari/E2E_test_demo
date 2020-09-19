package com.automate.withme.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.utils.Utilities;

import io.cucumber.java.Scenario;

public class Login {

	WebDriver driver;
	
	@FindBy(xpath="//h2[text()='Fruits and Veggies']")
	private WebElement Heading;
	
	@FindBy(xpath="//body//input[1]")
	private WebElement UsernameField;
	
	@FindBy(xpath="//body//input[2]")
	private WebElement PasswordField;
	
	@FindBy(className="loginbtn")
	private WebElement Login_Button;
	
	
	public Login(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void Launch_the_APP(String URL){
		utils.Naigate_to_URL(this.driver,URL);
		utils.maximize_my_window(this.driver);
	}
	
	
	public void Check_if_Heading_is_displayed(Scenario sc){
		try{
			if(Heading.isDisplayed()){
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
	
	
	public void Type_Username(String Uname){
		utils.Input_Text(driver,UsernameField, Uname);
	}
	
	public void Type_Password(String pass){
		utils.Input_Text(driver,PasswordField, pass);
	}
	
	public void login_click(){
		utils.Button_Link_Click(driver, Login_Button);
	}
}

package com.automate.withme.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.util.utils.Utilities;

import io.cucumber.java.Scenario;

public class Add_to_Cart {

	WebDriver driver;
	Scenario sc;
	
	@FindBy(xpath ="//button[text()='Add to Cart']")
	private List<WebElement> Add_to_cart_Buttons;
	
	@FindBy(xpath ="//button[text()='Remove item']")
	private List<WebElement> Remove_item_Buttons;
	
	@FindBy(id ="numberofitems")
	private WebElement Total_items;
	
	@FindBy(id ="priceamt")
	private WebElement Total_price;
	
	@FindBy(xpath="//body//div//div//a[@class='qtyqty']")
	private List<WebElement> Qty;
	
	@FindBy(xpath="//p[@class='price']")
	private List<WebElement> prices;
	
	@FindBy(xpath ="//button[text()='Checkout']")
	private WebElement checkout_button;
	
	public Add_to_Cart(WebDriver driver, Scenario sc){
		this.driver=driver;
		this.sc=sc;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void select_items(int [] data){
		//Apple
		for(int i=0; i<data[0];i++){
			utils.Button_Link_Click(driver, Add_to_cart_Buttons.get(0));
		}
		//Banana
		for(int i=0; i<data[1];i++){
			utils.Button_Link_Click(driver, Add_to_cart_Buttons.get(1));
		}
		//Orange
		for(int i=0; i<data[2];i++){
			utils.Button_Link_Click(driver, Add_to_cart_Buttons.get(2));
		}
		//Brinjal
		for(int i=0; i<data[3];i++){
			utils.Button_Link_Click(driver, Add_to_cart_Buttons.get(3));
		}
		//potato
		for(int i=0; i<data[4];i++){
			utils.Button_Link_Click(driver, Add_to_cart_Buttons.get(4));
		}
		
	}
	
	public void Verify_the_Qty(int Expected_data []){
		String Apple_qty =Qty.get(0).getText().replace("Qty :", "").trim();
		String Banana_qty =Qty.get(1).getText().replace("Qty :", "").trim();
		String Orange_qty =Qty.get(2).getText().replace("Qty :", "").trim();
		String Brinjal_qty =Qty.get(3).getText().replace("Qty :", "").trim();
		String Potato_qty =Qty.get(4).getText().replace("Qty :", "").trim();
		
		int Actual_UI_data[] = new int[]{
			Integer.parseInt(Apple_qty),
			Integer.parseInt(Banana_qty),
			Integer.parseInt(Orange_qty),
			Integer.parseInt(Brinjal_qty),
			Integer.parseInt(Potato_qty)};
			
			Assert.assertTrue(Arrays.equals(Expected_data, Actual_UI_data));
			System.out.println("PASS: THE UI Quantity and Expected Quantity matched");
			sc.write("THE UI Quantity and Expected Quantity matched");
	}
	
	public void Verify_total_cost(int data[]){
		ArrayList<Integer> prices_arr = new ArrayList<Integer>();
		
		for(WebElement i : prices){
			prices_arr.add(Integer.parseInt(i.getText().replace("$", "").trim()));
		}
		
		int Expected_tot_cost =0;
		int counter=0;
		for(int t: prices_arr){
			if(counter!=0){
				counter++;
			}
			Expected_tot_cost =Expected_tot_cost+(t*data[counter]);
		}
		
		int Actual_tot_cost_UI=Integer.parseInt(Total_price.getText().replace("$", "").trim());
		
		Assert.assertTrue(Expected_tot_cost==Actual_tot_cost_UI);
		System.out.println("PASS: The UI Actual Total cost matched with the Expected Total cost");
		sc.write("The UI Actual Total cost matched with the Expected Total cost");
	}
	
	public void Verify_total_items(int data []){
		int expected_tot_items=0;
		
		for(int i :data ){
			expected_tot_items +=i;
		}
		
		int Actual_UI_tot_items = Integer.parseInt(Total_items.getText());
		
		Assert.assertTrue(expected_tot_items==Actual_UI_tot_items);
		System.out.println("PASS: THE UI Total items and Expected Total items Matched");
		sc.write("THE UI Total items and Expected Total items Matched");
	}
	
	public void click_On_checkOut(){
		utils.Button_Link_Click(driver, checkout_button);
	}
	
}

package com.automate.withme.steps;


import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.openqa.selenium.WebDriver;

import com.automate.withme.pages.Add_to_Cart;
import com.automate.withme.pages.CheckOut;
import com.automate.withme.pages.Login;
import com.automate.withme.pages.OrderPlaced;
import com.automate.withme.testNgUtils.BrowserFactory;
import com.automate.withme.testNgUtils.testngUtils;
import com.util.utils.Decode;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.reactivex.rxjava3.schedulers.TestScheduler;

public class E2e_stepDefs extends testngUtils {
	
BrowserFactory browserFactory = BrowserFactory.getInstance();
WebDriver driver = browserFactory.getDriver();	
	
Login login =new Login(driver);
Add_to_Cart add_items = new Add_to_Cart(driver,sc);
CheckOut checkout = new CheckOut(driver, sc);
OrderPlaced order = new OrderPlaced(driver, sc);



private int qty[];
	
@Given ("^User Launches the APP$")
public void launch(DataTable url){
	List<String> URL_List = url.asList();
	String URL = URL_List.get(0);
	login.Launch_the_APP(URL);
}
	
@When("User gives the Username as {string}")
public void user_gives_the_Username_as(String uname) {
    login.Type_Username(uname);
}

@And("User gives the password as {string}")
public void user_gives_the_password_as(String pass) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException {
	String Pass =Decode.decypt_data(pass);	
   login.Type_Password(Pass);
}

@Then("User Clicks on Login button")
public void user_Clicks_on_Login_button() {
    login.login_click();
}

@Given("User lands on the Add to cart page")
public void user_lands_on_the_Add_to_cart_page() {
	 login.Check_if_Heading_is_displayed(sc);
}

@And("User selects the items and add them to cart")
public void user_selects_the_items_and_add_them_to_cart(DataTable dataTable) {
  Map<String, String> data = dataTable.asMap(String.class, String.class);
 
   qty=new int[]{
	Integer.parseInt(data.get("Apple")),
	Integer.parseInt(data.get("Banana")),
	Integer.parseInt(data.get("Orange")),
	Integer.parseInt(data.get("Bringal")),
	Integer.parseInt(data.get("Potatos"))};
  
  add_items.select_items(qty);
  
}

@Then("Verify the Quantity")
public void verify_the_Quantity() {
 add_items.Verify_the_Qty(qty);
}

@And("Verify the Total iteams is accurate")
public void verify_the_Total_iteams_is_accurate() {
  add_items.Verify_total_items(qty);
}

@And("Verify the Total cost is accurate")
public void verify_the_Total_cost_is_accurate() {
   add_items.Verify_total_cost(qty);
}

@And("User clicks on the checkout button")
public void user_clicks_on_the_checout_button() {
 add_items.click_On_checkOut();
}

@Given("User lands on the Checkout Page")
public void user_lands_on_the_Checkout_Page() {
	checkout.check_if_checkoutpage();
}

@Then("User Fills the Billing address details")
public void user_Fills_the_Billing_address_details() {
    checkout.Fill_billing_details();
}

@And("User clicks on the continue to checkout button")
public void user_clicks_on_the_checkout_button() {
    checkout.checkout_click();
}

@Given("User lands on the Order placed Page")
public void user_lands_on_the_Order_placed_Page() {
    order.Check_if_Heading_is_displayed();
}

@And("User verfies the success message")
public void user_verfies_the_success_message() {
   order.verify_success_message();
}

@And("Verify if the Details are displayed")
public void verify_the_Details_are_accurate() {
	order.verify_if_details_are_displayed();
}

@Then("User clicks on logout button")
public void user_clicks_on_logout_button() {
    order.click_On_Logout();
}
}

$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/E2eTests.feature");
formatter.feature({
  "name": "Testing Online Fruits and Veggies",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@E2e"
    }
  ]
});
formatter.scenario({
  "name": "Login to Online Fruits and Veggies",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@E2e"
    },
    {
      "name": "@Login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Launches the APP",
  "rows": [
    {}
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.launch(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User gives the Username as \"Online_User\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.user_gives_the_Username_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User gives the password as \"T25saW5lX1VzZXI\u003d\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.user_gives_the_password_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Clicks on Login button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.user_Clicks_on_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Add items into Cart",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@E2e"
    },
    {
      "name": "@AddToCart"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User lands on the Add to cart page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.user_lands_on_the_Add_to_cart_page()"
});
formatter.write("PASS: Page Heading is displayed");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects the items and add them to cart",
  "rows": [
    {},
    {},
    {},
    {},
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.user_selects_the_items_and_add_them_to_cart(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the Quantity",
  "keyword": "Then "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.verify_the_Quantity()"
});
formatter.write("THE UI Quantity and Expected Quantity matched");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the Total iteams is accurate",
  "keyword": "And "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.verify_the_Total_iteams_is_accurate()"
});
formatter.write("THE UI Total items and Expected Total items Matched");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the Total cost is accurate",
  "keyword": "And "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.verify_the_Total_cost_is_accurate()"
});
formatter.write("The UI Actual Total cost matched with the Expected Total cost");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the checkout button",
  "keyword": "And "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.user_clicks_on_the_checout_button()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "User checkout",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@E2e"
    },
    {
      "name": "@CheckOut"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User lands on the Checkout Page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.user_lands_on_the_Checkout_Page()"
});
formatter.write("PASS: Page Heading is displayed");
formatter.embedding("image/png", "embedded0.png", "User checkout");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Fills the Billing address details",
  "keyword": "Then "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.user_Fills_the_Billing_address_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the continue to checkout button",
  "keyword": "And "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.user_clicks_on_the_checkout_button()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Order placed",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@E2e"
    },
    {
      "name": "@OederPlaced"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User lands on the Order placed Page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.user_lands_on_the_Order_placed_Page()"
});
formatter.write("PASS: Page Heading is displayed");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verfies the success message",
  "keyword": "And "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.user_verfies_the_success_message()"
});
formatter.write("The success message is displayed");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify if the Details are displayed",
  "keyword": "And "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.verify_the_Details_are_accurate()"
});
formatter.write("The Email is displayed");
formatter.write("The Address is displayed");
formatter.write("The  Total items is displayed");
formatter.write("The total price is displayed");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on logout button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.automate.withme.steps.E2e_stepDefs.user_clicks_on_logout_button()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
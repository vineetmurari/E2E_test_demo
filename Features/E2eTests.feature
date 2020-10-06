@E2e
Feature: Testing Online Fruits and Veggies
 
  @Login
  Scenario: Login to Online Fruits and Veggies
  	Given User Launches the APP
  				|http://ec2-13-235-132-243.ap-south-1.compute.amazonaws.com:8080/|
    When User gives the Username as "Online_User"
    And User gives the password as "T25saW5lX1VzZXI="
    Then User Clicks on Login button
    
    @AddToCart
    Scenario: Add items into Cart
    Given User lands on the Add to cart page
    And User selects the items and add them to cart
    			|items|quantity|
    			|	  Banana	|		2			|
    			|		Apple		|		2			|
    			|		Orange	|		2			|
    			|		Bringal	|		2			|
    			|		Potatos	|		2			|
    Then Verify the Quantity
    And Verify the Total iteams is accurate
    And Verify the Total cost is accurate
    And User clicks on the checkout button

    @CheckOut
    Scenario: User checkout
    Given User lands on the Checkout Page
    #And Verify the Iteams and Quantity is accurate
    Then User Fills the Billing address details
    And User clicks on the continue to checkout button
    
    @OederPlaced
    Scenario: Order placed
    Given User lands on the Order placed Page
    And User verfies the success message
    And Verify if the Details are displayed
    Then User clicks on logout button

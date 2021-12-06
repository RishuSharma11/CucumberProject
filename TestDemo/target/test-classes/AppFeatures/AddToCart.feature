@tag
Feature: Add Product to the cart

Background: 
	Given User is on the home page

  @tag1
  Scenario: Adding a single product to the cart
		When User search a product 
		And User clicks on add to cart
		Then The product should be added to the cart
		
	@tag2
	Scenario: Adding a single product multiple times to the cart
		When User search a product
		And User clicks on add to cart
		And User repeates to click on add to cart
		Then Product should be added to the cart the times user clicked on add to cart
		
	@tag3
	Scenario: Adding the product to the cart by entering the quantity
		When User search a product
		And User enters the quantity of the product
		And User clicks on add to cart
		Then Product should be added to the cart with given quantity
		
	@tag4
	Scenario: Adding different products to the cart
		When User search a product
		And User clicks on add to cart
		And User search another product
		And User clicks on add to cart
		Then All the product should be added to the cart
@tag
Feature: Search a product

Background: 
	Given The user is on home page

  @tag1
  Scenario: Search with blank fields
  	When User leaves the search field empty
  	And User clicks on search button
  	Then An alert box with error message should be displayed to the user
  	
  @tag2
  Scenario: Search a non existing product
  	When User enters a non existing product name
  	And User clicks on search button
  	Then An error of no such product should be displayed
  	
  @tag3
  Scenario: Search with partial name
  	When User enters a partial name of the product
  	Then User should be given suggestions with respect to the keyword entered
  	When User selects one of the suggestions
  	Then User should be redirected to the page of the selected product
  
  @tag4
  Scenario: Search with invalid name like special character numbers
  	When User enters the input
  	And User clicks on search button
  	Then An error of no such product should be displayed

@tag
Feature: Login Verification

Background: 
	Given User is on the Login page
	
	@tag1
  Scenario: Login URL verification
    When User clicks on Login button
    Then User should be redirected to the Login page

  @tag2
  Scenario Outline: Login with valid details
    When User enters the "<Username>" and "<Password>"
    And Clicks on login button
    Then User should be logged in successfully
    
    Examples: 
      | Username    | Password |
      | abc@xyz.com | xyz1234  |
      
	@tag3
	Scenario: Login with empty fields
		When User keeps the email and password field empty
		And Clicks on the login button
		Then An error message should be displayed to the user
	
	@tag4
	Scenario: Login with invalid username
		When User enters the invalid username and password
		And Clicks on the login button
		Then An error message should be displayed to user
	
	@tag5
	Scenario Outline: Login with valid username and invalid password
		When User enters the valid "<username>" and invalid "<password>"
		And Clicks on login button
		Then User should recieve an error message
		
		Examples: 
		| username    | password |
		| abc@xyz.com | asdf1234 |
@tag
Feature: Forget Password Verification

Background: 
Given User is on the password recovery page

  @tag1
  Scenario: Password recovery with valid email
		When User enter the email to recover the password
		And clicks on recover password
		Then user should recieve the email
		And A message of recovery link successfully send should be displayed 
	
	@tag2
	Scenario: Password recovery with invalid email
		When User enter the invalid email
		And clicks on recover password
		Then Error message of no email found should be displayed
		
	@tag3
	Scenario: Password recovery with blank fields
		When User leaves the email field empty 
		And clicks on recover password
		Then An error message of mandatory email field should be displayed
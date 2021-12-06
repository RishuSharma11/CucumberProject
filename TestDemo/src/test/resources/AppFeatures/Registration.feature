
Feature: Registration verification 
Background: 
Given User is on the registration page
@tag1
  Scenario: Registration URL verification
    When User clicks on register button
    Then User should be redirected to the registration page.
@tag2
	Scenario Outline: Registration with valid user details
		When Selects the gender
		And User enters following details "<Firstname>","<Lastname>","<DOBD>","<DOBM>","<DOBY>","<Email>","<Company>","<Password>" and "<Cpassword>"
		And Clicks on register button
		Then Registration should be successfully done 
		And A message a should be displayed
		
		Examples:
		| Firstname | Lastname | DOBD |   DOBM  | DOBY |      Email     | Company | Password | Cpassword|
		| Raj       | Sharma   | 6    | December| 2010 | xyz@abc.com    | abcd    | abc123   | abc223   |  
		| Seema     | roy      | 19   | May     | 1995 | abc@xyz.com    | efgh    | xyz1234  | xyz1234  |
		 
		
@tag3		
	Scenario Outline: Mandatory field verification
		When User enters "<Firstname>" and "<Lastname>"
		And Clears both the field
		Then An error message of mandatory field should be displayed
		
		Examples: 
		| Firstname | Lastname |
		| V         | N        | 
	

@tag4
	Scenario: Invalid email or blank field
	When User enters invalid email
	Then An error message should be displayed
	
@tag5
	Scenario: Week Password Verification
	When User Enters A week password
	Then Error message should be displayed
	
	
	
	
	
	
	
	
	
	
	
	
	
	
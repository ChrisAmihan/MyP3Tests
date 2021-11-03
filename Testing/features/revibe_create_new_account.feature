#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Creating a New Account if a New User to Revibe
	
	@tag
	Scenario: Creating A New Account 
		Given The user is on the registration page
		When the user inputs their name
		And the user inputs a username
		And the user inputs a password
		And the user inputs an email
		And the user clicks the submit button
		Then the user is redirected to the login page
		


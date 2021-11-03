
@tag
Feature: Forget Password Feature	
	@tag
	Scenario: The user needs their password reset
		Given The user is on the reset-password page
		When the user inputs their email
		And the user clicks reset password
		Then the user will go back to the login page after clicking the button
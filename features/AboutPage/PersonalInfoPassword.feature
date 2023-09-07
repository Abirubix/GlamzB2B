Feature: Validation of about Personal Info Page Password funtionality

@PersonalInfoPassword
Scenario: Validation of about Personal Info Page Password funtionality
Given User launch an Glamz web application
And User click on Login button 
When User enter username "keerthi@gmail.com" and password "123456789" and logs in
Then User click Setup->About
And User clicks on About->PersonalInfo
And User verifies if password label and edit button is present
And User verifies that password field is non editable
And User then clicks on edit button and edit password pop up is obtained
And User verifies for all the texts and labels and action buttons are present in edit password popup
Then User verifies that the password field in popup is non editable
Then User enters "1234567890" in the new password field and "1234" in the Confirm New Password field
Then User click on save and "Password must match" error message is obtained
Then User clears the new password field and "Password is required" message is obtained
And User clears the Confirm New Password field and "Confirm Password is required" message is obtained
Then User enters "1234567" in the new password field
And "Password must be atleast 8 characters" message is obtained
Then User enters "1234567890" in the new password field and "1234567890" in the Confirm New Password field
And User clicks on save button and saved toaster message is obtained and the pop up closes
And User then clicks on edit button and edit password pop up is obtained
Then User enters "123456789" in the new password field and "123456789" in the Confirm New Password field
And User clicks on save button and saved toaster message is obtained and the pop up closes
And User then clicks on edit button and edit password pop up is obtained
And User clicks on cancel in edit password popup and the popup closes and Personal Info page is displayed
And User then clicks on edit button and edit password pop up is obtained
And User clicks on cross mark in edit password popup and the popup closes



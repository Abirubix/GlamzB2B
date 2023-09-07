Feature: Validation of about Personal Info Page Email funtionality

@PersonalInfoemail
Scenario: Validation of about Personal Info Page Email funtionality
Given User launch an Glamz web application
And User click on Login button 
When User enter username "keerthi@gmail.com" and password "123456789" and logs in
Then User click Setup->About
And User clicks on About->PersonalInfo
And User verifies if email label and edit button is present
And User verifies that email field is non editable
And User then clicks on edit button and edit email pop up is obtained
And User verifies for all the texts and labels and action buttons are present in edit email popup
Then User verifies that the email present in pop up is same as the email in Personal info email value
Then User enters the new email value as same as the existing email value and gives the same email in email cofirmation field
And User clicks on save button in edit email popup an error message should appear
When User clears the new email and confirmation email field "Invalid Email" message should be displayed
Then User enters "keerthi123@gmail.com" in new email and "keerthi12@gmail.com" in the confirmation email
And User clicks on save button in edit email popup an error message indicating emails are not same should appear
Then User enters "12345abc" in new email and "12345abc" in the confirmation email
And User clicks on save button in edit email popup an error message  "Invalid Email" should appear
Then User enters "keerthi1@gmail.com" in new email and "keerthi1@gmail.com" in the confirmation email
And User clicks on save button in edit email popup a confirmation toaster is displayed and the popup closes
Then The new email "keerthi1@gmail.com" is updated in personal info email field
And User then clicks on edit button and edit email pop up is obtained
Then User enters "keerthi@gmail.com" in new email and "keerthi@gmail.com" in the confirmation email
And User clicks on save button in edit email popup a confirmation toaster is displayed and the popup closes
Then The new email "keerthi@gmail.com" is updated in personal info email field
And User then clicks on edit button and edit email pop up is obtained
When User clicks on cancel button the edit email popup is closed
And User then clicks on edit button and edit email pop up is obtained
Then User clicks on cross mark to close the popup
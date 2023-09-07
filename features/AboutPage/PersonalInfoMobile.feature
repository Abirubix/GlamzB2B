Feature: Validation of about Personal Info Page Mobile Phone for login functionality

@PersonalInfoPhone
Scenario: Validation of about Personal Info Page Mobile Phone for login functionality

Given User launch an Glamz web application
And User click on Login button 
When User enter username "keerthi@gmail.com" and password "123456789" and logs in
Then User click Setup->About
And User clicks on About->PersonalInfo
And User verifies if mobile phone for login label and edit button is present
And User verifies that mobile phone field is non editable
And User then clicks on edit button and edit mobile number pop up is obtained
And User verifies for all the texts and labels and action buttons are present in edit mobile number popup
Then User verifies if current mobile number in pop up is same as the mobile number in personal info mobile field
Then User enters "0907665545" in the new mobile number field and is notified with an error message
Then User enters "0567788999" in the new mobile number field and the error message is gone
And User clicks on Send Verification Code button and an otp sent succesfully message toaster is displayed
And User enters the wrong otp "000000" and clicks on save button
Then Invalid Otp message should be displayed
And User enters the wrong otp "654"
Then User should be notified with error message as "Enter your 6 digit otp number" in the edit mobile number popup
Then User clicks on Cancel button in Edit MobileNumber popup and the popup closes
And User then clicks on edit button and edit mobile number pop up is obtained
And User clicks on cross mark in Edit Mobile Number popup to close the popup



